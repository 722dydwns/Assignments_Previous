#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 1000
#define FALSE 0
#define TRUE 1
typedef struct Process {
	int pid;
	int size;
}Process;
typedef struct Memory {
	Process process[30];
	int Using[30]; //각 프로세스 사용중 여부 
	int address = 0;
}Memory;
void createMemory(Memory* m) {//초기 공백 메모리 상태
	int i;
	for (int i = 1; i < 10; i++) {
		if (i <= 5) {
			m->Using[i] = TRUE;
			m->process[i].size = (rand() % 100) + 10;
		}
		if (6 <= i) {
			m->Using[i] = FALSE;
			m->process[i].size = m->process[i].size = (rand() % 100) + 10;
		}
	}
}
void insertFirstProcess(Memory* m, Process* p) { //프로세스 삽입(최초적합)
	if ((m->address) > MAX_SIZE) { //메모리 주소가 1000 넘어가면 오버플로우
		printf("메모리 오버플로우\n");
		return;
	}
	for (int i = 0; i < 30; i++) { //Using[] 내부 차례로 돌면서 

		if ((m->Using[i] == FALSE) && (m->process[i].size > p->size)) { //처음 발견한 빈 공간 (최초적합)
			m->Using[i] = TRUE; //현재 공간 사용중 업데이트 
			m->process[i].pid = p->pid;
			m->process[i].size = p->size;
			m->address += p->size; //주소 ++ 처리

			break;
		}
	}
}
void insertWorstProcess(Memory* m, Process* p) { //프로세스 삽입 (최악적합)

	int insert; //삽입위치저장용
	if ((m->address) > MAX_SIZE) {//메모리 주소가 1000 넘어가면 오버플로우
		printf("메모리 오버플로우\n");
		return;
	}
	int max = m->process[0].size; //max 사이즈 갖는 공간찾을 용도
	for (int i = 0; i < 30; i++) {
		if ((m->Using[i] == FALSE)) { //Using[] 돌면서 비어있는 공간 중
			if (max < m->process[i].size) { //현 max보다 큰 공간 발견시
				max = m->process[i].size;
				insert = i; //max값 갖는 i 저장시킴 
			}
		}
	}
	//for 빠져나온 insert는 현재 size max값 갖는 공간
	m->Using[insert] = TRUE; //max 메모리 공간 사용처리 
	m->process[insert].pid = p->pid;
	m->process[insert].size = p->size;
	m->address += p->size; //주소 ++ 처리
}
void deleteProcess(Memory* m, int pid) { //프로세스 삭제
	for (int i = 0; i < 30; i++) {
		if (m->process[i].pid == pid) {
			m->Using[i] = FALSE;
			m->address -= m->process[i].size; //주소 --처리
			m->process[i].size = 0;
		}
	}
}
void printMemory(Memory* m) { //빈 메모리 목록
	for (int i = 0; i < 30; i++) { //홀 관리 
		if ((m->Using[i] == FALSE) && (m->Using[i + 1] == FALSE)) { //연달아 빈공간인 경우 합침										
			m->process[i].size += m->process[i + 1].size; //size 합쳐주고 
			m->process[i + 1].size = 0;
		}
	}
	printf("비어있는 메모리 공간 Hole 목록\n");
	for (int i = 0; i < 30; i++) {
		if ((m->Using[i] == FALSE) && (m->process[i].size != 0)) {
			printf("[Hole] size : %d", m->process[i].size);
		}
	}
}
int main() {
	int o;
	int id;
	int Psize;
	Process p;
	Memory* m = (Memory*)malloc(sizeof(Memory));
	createMemory(m);
	for (int i = 0; i < 30; i++) { //30번 루프 돌면서 
		printf("\n ----------------------------------------------- \n");
		printf("프로세스 생성  = 1 or 삭제  = 2 \n");
		scanf_s("%d", &o);
		if (o == 1) { //프로세스 생성 
			printf("생성할 프로세스 id번호\n");
			scanf_s("%d", &id);
			printf("생성할 프로세스 크기 (10~100)\n");
			scanf_s("%d", &Psize);
			Process p;
			p.pid = id;
			p.size = Psize;
			printf("최초적합 = 1, 최악적합 = 2  \n");
			scanf_s("%d", &o);
			if (o == 1) { //최초적합 
				insertFirstProcess(m, &p);
				printMemory(m);
			}
			else if (o == 2) {//최악적합 
				insertWorstProcess(m, &p);
				printMemory(m);
			}
			else {
				printf("잘못 입력하셨습니다.");
			}
		}
		else if (o == 2) { //프로세스 삭제 
			printf("삭제할 프로세스 pid 번호\n");
			scanf_s("%d", &id);
			deleteProcess(m, id);
			printMemory(m);
		}
		else {
			printf("잘못 입력하셨습니다. 다시 입력하세요\n ");
		}
	}
	printf("\n ----------------------------------------------- \n");
	printf("\n\n 최종 사용 중인 프로세스 목록 : \n");
	for (int i = 0; i < 30; i++) {
		if (m->Using[i] == TRUE) {
			printf("[P %d] size : %d, address : %d \n", i, m->process[i].size, m->address);
		}
	}
	printf("\n ----------------------------------------------- \n");
	printf("최종");
	printMemory(m);
	getchar();
	getchar();
	return 0;
}

