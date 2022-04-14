#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define SIZE 10

struct SCORE {
	int mid;
	int final;
	int total;
};

typedef struct STUDENT {
	char idnum[11];
	char name[20];
	struct SCORE sungjuk;
}STUDENT;

void input_and_calculation(STUDENT array[], int N);
void selection_sort(STUDENT array[], int N);
void print_array(STUDENT array[], int N);


int main(void) {
	STUDENT list[SIZE];

	input_and_calculation(list, SIZE);
	selection_sort(list, SIZE);
	print_array(list, SIZE);

	return 0;
}


void input_and_calculation(STUDENT array[], int N) {

	FILE* file = fopen("data.txt", "r");

	if ((file = fopen("data.txt", "r")) == NULL) {
		printf("Cannot open the data file!\n");
		exit(0);
	}

	for (int i = 0; i < SIZE; i++) {
		fscanf(file, "%s %s %d %d", &array[i].idnum, &array[i].name, &array[i].sungjuk.mid, &array[i].sungjuk.final);
		array[i].sungjuk.total = array[i].sungjuk.mid + array[i].sungjuk.final;
	}

	fclose(file);

}

void selection_sort(STUDENT array[], int N) {	//선택정렬 

	STUDENT temp;

	for (int i = 0; i < N - 1; i++) {
		for (int j = i + 1; j < N; j++) {
			if (array[i].sungjuk.total < array[j].sungjuk.total) {
				temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
	}
}


void print_array(STUDENT array[], int N) {

	//콘솔창 출력 
	printf("\t학번\t이름\t중간\t기말\t총점\n");
	printf("-----------------------------------------------------------------\n");
	for (int i = 0; i < SIZE; i++) {
		printf(" %s\t%s\t%d\t%d\t%d\n", array[i].idnum, array[i].name, array[i].sungjuk.mid, array[i].sungjuk.final, array[i].sungjuk.total);
	}
	printf("-----------------------------------------------------------------\n");


	//result.txt에 출력 
	FILE* fp1 = fopen("result.txt", "w");

	fprintf(fp1, "-----------------------------------------------------------------\n");
	fprintf(fp1, "\t학번\t이름\t중간\t기말\t총점\n");
	fprintf(fp1, "-----------------------------------------------------------------\n");
	for (int i = 0; i < SIZE; i++) {
		fprintf(fp1, "%s\t%s\t%d\t%d\t%d\n", array[i].idnum, array[i].name, array[i].sungjuk.mid, array[i].sungjuk.final, array[i].sungjuk.total);

	}
	fprintf(fp1, "-----------------------------------------------------------------\n");

	fclose(fp1);
}