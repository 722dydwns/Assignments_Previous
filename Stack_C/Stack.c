#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define MAX_SIZE 100

typedef struct Stack {
    int capacity;
    int top;
    int* arr;
}Stack;

struct Stack* createStack(int capacity)
{
    Stack* stack = (Stack*)malloc(sizeof Stack);
    stack->top = -1;
    stack->capacity = capacity;
    stack->arr = (int*)malloc(stack->capacity * sizeof(int));
    return stack;
}

void push(Stack* stack, int element)
{
    stack->arr[++stack->top] = element;
}

int peek(Stack* stack)
{
    return stack->arr[stack->top];
}

int pop(Stack* stack)
{
    return stack->arr[stack->top--];
}

int in(Stack* stack, int idx) {
    return stack->arr[idx];
}

int isEmpty(Stack* stack)
{
    if (stack->top == -1) return 1;
    return 0;
}

int solution(Stack** board, int* moves, int N, int M) {

    int i, j;
    int num, value, count;

    Stack* basket = createStack(N * N);

    printf("Claw Crane \n");

    for (i = N - 1; i >= 0; i--) {
        for (j = 0; j < N; j++) {

            printf("|\t");

            if (in(board[j], i) > 0) {
                printf("%d", in(board[j], i));
            }
            else {
                printf(" ");
            }

            printf("\t");
        }
        printf("|\n");
    }
    printf("--------------------------------------------------------------------------------------------\n");
    for (i = 0; i < N; i++) {
        printf("\t[%d]\t", i + 1);
    }
    printf("\n\n");

    count = 0;

    for (i = 0; i < M; i++) {
        num = moves[i] - 1;

        if (isEmpty(board[num]) == 0) {
            value = pop(board[num]);

            if (isEmpty(basket) == 0) {

                if (peek(basket) == value) {
                    pop(basket);
                    count += 2;
                }
                else {
                    push(basket, value);
                }
            }
            else {
                push(basket, value);
            }
        }

    }

    for (i = basket->top; i >= 0; i--) {
        printf("\t");
        if (in(basket, i) != 0) {
            printf("%d", in(basket, i));
        }
        else {
            printf(" ");
        }
        printf("\t\n");
    }
    printf("----------------------\n");

    printf("\t[selected]\t=> answer = ");

    return count;
}

int main()
{
    int N, M, i, j, value, result;
    Stack* board[MAX_SIZE];
    Stack* temp[MAX_SIZE];
    int* moves;

    printf("board 배열 크기 N(5 ~ 30)  입력 : ");
    scanf_s("%d", &N);

    if (N < 5 || N > 30) {
        perror("board 배열 크기 입력 오류 \n");
        exit(100);
    }

    printf("moves 배열 크기 M(1 ~ 1000) 입력 : ");
    scanf_s("%d", &M);

    if (M < 1 || M > 1000) {
        perror("moves 배열 크기 입력 오류 \n");
        exit(100);
    }

    moves = (int*)malloc(sizeof(int) * M);

    for (i = 0; i < N; i++) {
        board[i] = createStack(N);
        temp[i] = createStack(N);
    }

    for (i = 0; i < N; i++) {
        printf("----%d번째 행----\n", i + 1);
        for (j = 0; j < N; j++) {
            printf("[%d]행 [%d] 열의 원소값 입력 : ", i + 1, j + 1);
            scanf_s("%d", &value);
            push(temp[j], value);
        }
    }

    for (i = 0; i < N; i++) {
        while (isEmpty(temp[i]) == 0) {
            value = pop(temp[i]);
            if (value != 0) {
                push(board[i], value);
            }
        }
    }

    for (i = 0; i < M; i++) {
        printf("%d 번째 크레인 작동 줄 위치 입력 : ", i + 1);
        scanf_s("%d", &value);
        moves[i] = value;
    }

    result = solution(board, moves, N, M);
    printf("%d\n", result);
    return 0;
}