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
	int Using[30]; //�� ���μ��� ����� ���� 
	int address = 0;
}Memory;
void createMemory(Memory* m) {//�ʱ� ���� �޸� ����
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
void insertFirstProcess(Memory* m, Process* p) { //���μ��� ����(��������)
	if ((m->address) > MAX_SIZE) { //�޸� �ּҰ� 1000 �Ѿ�� �����÷ο�
		printf("�޸� �����÷ο�\n");
		return;
	}
	for (int i = 0; i < 30; i++) { //Using[] ���� ���ʷ� ���鼭 

		if ((m->Using[i] == FALSE) && (m->process[i].size > p->size)) { //ó�� �߰��� �� ���� (��������)
			m->Using[i] = TRUE; //���� ���� ����� ������Ʈ 
			m->process[i].pid = p->pid;
			m->process[i].size = p->size;
			m->address += p->size; //�ּ� ++ ó��

			break;
		}
	}
}
void insertWorstProcess(Memory* m, Process* p) { //���μ��� ���� (�־�����)

	int insert; //������ġ�����
	if ((m->address) > MAX_SIZE) {//�޸� �ּҰ� 1000 �Ѿ�� �����÷ο�
		printf("�޸� �����÷ο�\n");
		return;
	}
	int max = m->process[0].size; //max ������ ���� ����ã�� �뵵
	for (int i = 0; i < 30; i++) {
		if ((m->Using[i] == FALSE)) { //Using[] ���鼭 ����ִ� ���� ��
			if (max < m->process[i].size) { //�� max���� ū ���� �߽߰�
				max = m->process[i].size;
				insert = i; //max�� ���� i �����Ŵ 
			}
		}
	}
	//for �������� insert�� ���� size max�� ���� ����
	m->Using[insert] = TRUE; //max �޸� ���� ���ó�� 
	m->process[insert].pid = p->pid;
	m->process[insert].size = p->size;
	m->address += p->size; //�ּ� ++ ó��
}
void deleteProcess(Memory* m, int pid) { //���μ��� ����
	for (int i = 0; i < 30; i++) {
		if (m->process[i].pid == pid) {
			m->Using[i] = FALSE;
			m->address -= m->process[i].size; //�ּ� --ó��
			m->process[i].size = 0;
		}
	}
}
void printMemory(Memory* m) { //�� �޸� ���
	for (int i = 0; i < 30; i++) { //Ȧ ���� 
		if ((m->Using[i] == FALSE) && (m->Using[i + 1] == FALSE)) { //���޾� ������� ��� ��ħ										
			m->process[i].size += m->process[i + 1].size; //size �����ְ� 
			m->process[i + 1].size = 0;
		}
	}
	printf("����ִ� �޸� ���� Hole ���\n");
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
	for (int i = 0; i < 30; i++) { //30�� ���� ���鼭 
		printf("\n ----------------------------------------------- \n");
		printf("���μ��� ����  = 1 or ����  = 2 \n");
		scanf_s("%d", &o);
		if (o == 1) { //���μ��� ���� 
			printf("������ ���μ��� id��ȣ\n");
			scanf_s("%d", &id);
			printf("������ ���μ��� ũ�� (10~100)\n");
			scanf_s("%d", &Psize);
			Process p;
			p.pid = id;
			p.size = Psize;
			printf("�������� = 1, �־����� = 2  \n");
			scanf_s("%d", &o);
			if (o == 1) { //�������� 
				insertFirstProcess(m, &p);
				printMemory(m);
			}
			else if (o == 2) {//�־����� 
				insertWorstProcess(m, &p);
				printMemory(m);
			}
			else {
				printf("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
		else if (o == 2) { //���μ��� ���� 
			printf("������ ���μ��� pid ��ȣ\n");
			scanf_s("%d", &id);
			deleteProcess(m, id);
			printMemory(m);
		}
		else {
			printf("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���\n ");
		}
	}
	printf("\n ----------------------------------------------- \n");
	printf("\n\n ���� ��� ���� ���μ��� ��� : \n");
	for (int i = 0; i < 30; i++) {
		if (m->Using[i] == TRUE) {
			printf("[P %d] size : %d, address : %d \n", i, m->process[i].size, m->address);
		}
	}
	printf("\n ----------------------------------------------- \n");
	printf("����");
	printMemory(m);
	getchar();
	getchar();
	return 0;
}

