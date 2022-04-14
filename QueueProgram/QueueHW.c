#include <stdio.h>	
#include<stdlib.h>
#define cQ_SIZE 51

typedef int element;
typedef struct {
	element queue[cQ_SIZE];
	int front, rear;
}QueueType;

QueueType* createQueue() {
	QueueType* cQ;
	cQ = (QueueType*)malloc(sizeof(QueueType));
	cQ->front = 0;
	cQ->rear = 0;
	return cQ;
}

int isEmpty(QueueType* cQ) {
	if (cQ->front == cQ->rear) {
		return 1;
	}
	else return 0;
}

int isFull(QueueType* cQ) {
	if (((cQ->rear + 1) % cQ_SIZE) == cQ->front) {

		return 1;
	}
	else return 0;
}

void enQueue(QueueType* cQ, element item) {
	if (isFull(cQ)) return;
	else {
		cQ->rear = (cQ->rear + 1) % cQ_SIZE;
		cQ->queue[cQ->rear] = item;
	}
}

element deQueue(QueueType* cQ) {
	if (isEmpty(cQ)) exit(1);
	else {
		cQ->front = (cQ->front + 1) % cQ_SIZE;
		return cQ->queue[cQ->front];
	}
}

void main(int) {
	QueueType* cQ = createQueue();
	element deVal;

	int N, K;
	int i;

	printf("N(1~50) N입력: ");
	scanf_s("%d", &N);

	printf("널판지로 보낼 k번째(k <= N) 입력: ");
	scanf_s("%d", &K);

	if (N < K)
		printf("입력 오류: N <= K");
	else if (N < 1 || N > 50)
		printf("입력 오류: N < 1 or N > 50");
	else {
		for (i = 1; i <= N; ++i)
			enQueue(cQ, i);

		while (!isEmpty(cQ))
		{
			i = 0; // count = 0

			while (1)
			{
				deVal = deQueue(cQ);
				if (isEmpty(cQ))
				{
					printf("%d ", deVal);
					break;
				}
				++i; // ++count 

				if (i != K)
					enQueue(cQ, deVal);
				else
				{
					printf("%d ", deVal);
					break;
				}
			}
		} return;
	}
}