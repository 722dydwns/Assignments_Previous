#include <stdio.h>
#include <stdlib.h>
#define MAX_ELEMENT 100

typedef struct Node { //Node 구조체
	int pid;
	int inputT;
	int prior;
	int runT;
}Node;

typedef struct priorQueue { //우선순위 큐 구조체
	Node heap[MAX_ELEMENT];
	int size;
} priorQueue;

priorQueue* createPriorQueue() { //공백 우선순위 큐 생성 
	priorQueue* pQ = (priorQueue*)malloc(sizeof(priorQueue));
	pQ->size = 0;
	return pQ;
}

Node* createNode(int pid, int inputT, int prior, int runT) {
	Node* node = (Node*)malloc(sizeof(Node));
	node->pid = pid;
	node->inputT = inputT;
	node->prior = prior;
	node->runT = runT;

	return node;
}

void insert(priorQueue* pQ, Node* node) {
	int i;
	pQ->size = pQ->size + 1;
	i = pQ->size;

	while ((i != 1) && (node->prior > pQ->heap[i / 2].prior)) {
		pQ->heap[i] = pQ->heap[i / 2];
		i /= 2;
	}
	pQ->heap[i].inputT = node->inputT;
	pQ->heap[i].pid = node->pid;
	pQ->heap[i].prior = node->prior;
	pQ->heap[i].runT = node->runT;
}
Node getFirst(priorQueue* pQ) {
	int parent, child;
	Node item, temp;
	item = pQ->heap[0]; //삭제할 첫 노드 
	temp = pQ->heap[pQ->size];
	pQ->size = pQ->size - 1;

	parent = 1; //부모인덱스 1
	child = 2; //자식 인덱스 2 
	while (child <= pQ->size) {
		if ((child < pQ->size) && (pQ->heap[child].prior) < pQ->heap[child + 1].prior)
			child++;
		if (temp.prior >= pQ->heap[child].prior) break;
		else {
			pQ->heap[parent] = pQ->heap[child];
			parent = child;
			child = child * 2;
		}
	}
	pQ->heap[parent] = temp;
	return item;
}
void showAll(priorQueue* pQ) { //큐의 내용을 모두 보여주는 showAll() 함수 
	int i;
	printf("priorityQueue : \n");
	for (i = 1; i <= pQ->size; i++)
		printf("[ P%d, %d, (%d), %d ] -> ", pQ->heap[i].pid, pQ->heap[i].inputT, pQ->heap[i].prior, pQ->heap[i].runT);

}
void main() {
	int i, n;
	priorQueue* pQ = createPriorQueue();
	//(pid, inputT, prior, runT)

	//우선순위큐에 노드 20개 삽입 
	insert(pQ, createNode(1, 0, 6, 9));
	insert(pQ, createNode(2, 3, 7, 7));
	insert(pQ, createNode(3, 2, 8, 90));
	insert(pQ, createNode(4, 2, 10, 5));
	insert(pQ, createNode(5, 5, 9, 11));
	insert(pQ, createNode(6, 7, 1, 13));
	insert(pQ, createNode(7, 4, 2, 19));
	insert(pQ, createNode(8, 1, 3, 21));
	insert(pQ, createNode(9, 2, 4, 11));
	insert(pQ, createNode(10, 9, 5, 8));
	insert(pQ, createNode(11, 3, 8, 10));
	insert(pQ, createNode(12, 5, 7, 31));
	insert(pQ, createNode(13, 6, 10, 20));
	insert(pQ, createNode(14, 5, 3, 21));
	insert(pQ, createNode(15, 3, 7, 19));
	insert(pQ, createNode(16, 4, 2, 20));
	insert(pQ, createNode(17, 5, 8, 11));
	insert(pQ, createNode(18, 6, 1, 12));
	insert(pQ, createNode(19, 2, 8, 24));
	insert(pQ, createNode(20, 6, 3, 13));


	printf("우선순위 큐에 삽입된 노드 출력\n\n ");
	showAll(pQ);
	printf("\n\n");

	n = pQ->size;
	for (i = 1; i <= n; i++) {
		Node item = getFirst(pQ);
		printf("\n 큐의 첫 요소 삭제 [P%d, %d, (%d), %d] ", item.pid, item.inputT, item.prior, item.runT);
	}

	getchar();
