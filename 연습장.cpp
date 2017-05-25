#include<iostream>
#include<vector>
#include<queue>
#include<ctime>
#include<cstdlib>
#include<Windows.h>

using namespace std;

class Ball {
public:
	int ballType;
	Ball() {
		ballType = 0;
	}
	Ball(int n) {
		Ball();
		ballType = n;
	}
};

class Ball_Array {
public:
	vector<vector<Ball>> map;
	int sizeOfArray;
	Ball_Array() {
		sizeOfArray = 0;
	}
	Ball_Array(int n) {
		sizeOfArray = n;
		map.resize(n);
		for (int i = 0; i < n; i++) {
			map.at(i).resize(n);
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = Ball();
	}
	Ball_Array(int n, vector<int> a) {
		sizeOfArray = n;
		map.resize(n);
		for (int i = 0; i < n; i++) {
			map.at(i).resize(n);
		}
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				map[i][j] = Ball(a[k++]);
		}
	}
	void randomMap() {
		for (int i = 0; i < sizeOfArray; i++)
			for (int j = 0; j < sizeOfArray; j++)
				map[i][j] = rand() % 4;
	}




	void printArray() {
		printf("┌");
		for (int i = 0; i < sizeOfArray - 1; i++)
			printf("─┬");
		printf("─┐\n");
		for (int i = 0; i < sizeOfArray; i++) {
			for (int j = 0; j < sizeOfArray; j++)
				printf("│%2d", map[i][j].ballType);
			printf("│\n");
			if (i != sizeOfArray - 1) {
				printf("├");
				for (int j = 0; j < sizeOfArray - 1; j++)
					printf("─┼");
				printf("─┤\n");
			}
		}
		printf("└");
		for (int i = 0; i < sizeOfArray - 1; i++)
			printf("─┴");
		printf("─┘\n");
	}
	bool matching(Ball_Array target, int x, int y) {
		int count = 0;
		if (sizeOfArray < target.sizeOfArray)
			return false;
		else {
			for (int i = 0; i < target.sizeOfArray; i++) {
				for (int j = 0; j < target.sizeOfArray; j++) {
					if (map[x + i][y + j].ballType == target.map[i][j].ballType)
						count++;
				}
			}
		}


		if (count == target.sizeOfArray*target.sizeOfArray) {
			//subArray(target.sizeOfArray, x, y);
			return true;
		}
		return false;
	}
	void subArray(int n, int x, int y) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[x + i][y + j].ballType)
					map[x + i][y + j].ballType--;

			}
		}
	}
	Ball_Array generateQueue(int n) {
		int x;
		int y;
		Ball_Array emptyArray = Ball_Array(n);
		Ball_Array outputArray = Ball_Array(n);
		do {
			x = rand() % (sizeOfArray - n + 1);
			y = rand() % (sizeOfArray - n + 1);
			if (!matching(emptyArray, x, y))
				break;
		} while (1);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				outputArray.map[i][j].ballType = map[x + i][y + j].ballType;
		subArray(n, x, y);
		return outputArray;


	}

};



class Ball_Queue {
public:
	queue <Ball_Array> currentQueue;
	void printQueue() {
		for (int i = 0; i < currentQueue.size(); i++) {
			currentQueue.front().printArray();
			currentQueue.push(currentQueue.front());
			currentQueue.pop();
		}
	}
};

int main() {
	srand((unsigned)time(0));
	int input = 0;
	int count = 0;
	int max;
	int k = 0;

	Ball_Queue myQueue = Ball_Queue();
	Ball_Array myMap = Ball_Array(4);            //맵 구성
	Ball_Array emptyArray = Ball_Array(4);
	Ball_Array saveMap;
	Ball_Array beforeMap;
	vector<int> level;


	do {
		if(k++%100 == 99)
			printf("...%d\n", k);
		while (!myQueue.currentQueue.empty())
			myQueue.currentQueue.pop();
		level.resize(0);
		myMap.randomMap();
		saveMap = myMap;
		beforeMap = saveMap;
		max = 0;

		while (!saveMap.matching(emptyArray, 0, 0)) {
			count = 0;
			beforeMap = saveMap;
			myQueue.currentQueue.push(saveMap.generateQueue(2));                        //풀어야 하는 공들
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (beforeMap.matching(myQueue.currentQueue.back(), i, j))
						count++;
				}
			}
			level.push_back(count);
		}
		for (int i = 0; i < level.size(); i++) {
			if (level[i] > max)
				max = level[i];
		}
	} while (max <= 5);
	Sleep(1000);
	system("cls");
	for (int i = 0; i < level.size(); i++) {
		printf("%d ", level[i]);
	}
	printf("\n");
	Sleep(5000);
	

	while (true) {
		system("cls");
		myMap.printArray();
		printf("━━━━━━━━━━━━━\n");
		myQueue.printQueue();
		scanf_s("%d", &input);                                             //input : 00, 01, 02
																		   //input : 10, 11, 12
																		   //input : 20, 21, 22
		if (input == 7)
			input = 00;
		else if (input == 8)
			input = 01;
		else if (input == 9)
			input = 02;
		else if (input == 4)
			input = 10;
		else if (input == 5)
			input = 11;
		else if (input == 6)
			input = 12;
		else if (input == 1)
			input = 20;
		else if (input == 2)
			input = 21;
		else if (input == 3)
			input = 22;

		if (myMap.matching(myQueue.currentQueue.front(), input / 10, input % 10)) {
			myMap.subArray(myQueue.currentQueue.front().sizeOfArray, input / 10, input % 10);
			myQueue.currentQueue.pop();
		}
	}
}

