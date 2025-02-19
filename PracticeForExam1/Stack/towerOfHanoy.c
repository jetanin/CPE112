#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node *next;
} node;

typedef struct stack {
    node *top;
} stack;

void push(stack *s, int value) {
    node *newNode = (node*)malloc(sizeof(node));
    newNode->value = value;
    newNode->next = s->top;
    s->top = newNode;
}

int pop(stack *s) {
    if (s->top == NULL) {
        // printf("Stack is empty\n");
        return -1;
    }
    node *temp = s->top;
    int value = temp->value;
    s->top = s->top->next;
    free(temp);
    return value;
}

void moveDisk(stack *source, stack *destination, char s, char d) {
    int pole1TopDisk = pop(source);
    int pole2TopDisk = pop(destination);

    if (pole1TopDisk == -1) {
        push(source, pole2TopDisk);
        printf("Move disk %d from %c to %c\n", pole2TopDisk, d, s);
    } else if (pole2TopDisk == -1) {
        push(destination, pole1TopDisk);
        printf("Move disk %d from %c to %c\n", pole1TopDisk, s, d);
    } else if (pole1TopDisk > pole2TopDisk) {
        push(source, pole1TopDisk);
        push(source, pole2TopDisk);
        printf("Move disk %d from %c to %c\n", pole2TopDisk, d, s);
    } else {
        push(destination, pole2TopDisk);
        push(destination, pole1TopDisk);
        printf("Move disk %d from %c to %c\n", pole1TopDisk, s, d);
    }
}

void towerOfHanoi(int num_of_disks, stack *src, stack *aux, stack *dest) {
    char s = 'A', d = 'C', a = 'B';
    int total_num_of_moves = (1 << num_of_disks) - 1;

    for (int i = num_of_disks; i >= 1; i--) {
        push(src, i);
    }

    for (int i = 1; i <= total_num_of_moves; i++) {
        if (i % 3 == 1) {
            moveDisk(src, dest, s, d);
        } else if (i % 3 == 2) {
            moveDisk(src, aux, s, a);
        } else if (i % 3 == 0) {
            moveDisk(aux, dest, a, d);
        }
    }
    printf("Total moves: %d", total_num_of_moves);
}

int main() {
    int disk;
    scanf("%d", &disk);

    stack src, aux, dest;
    src.top = NULL;
    aux.top = NULL;
    dest.top = NULL;

    towerOfHanoi(disk, &src, &aux, &dest);

    return 0;
}