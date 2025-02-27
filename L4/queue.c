#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct node{
    int value;
    struct node *next;
}node;
typedef struct queue{
    node *front;
    node *rear; 
}queue;

void printQueue(node *q){
    node *newNode = q;
    if(q == NULL)printf("none\n");
    else{
        while(q != NULL){
            printf("%d ", q->value);
            q = q->next;
        }
        printf("\n");
    }
}
void insertQ(queue *q, int val){
    node *ptr = (node*)malloc(sizeof(node));
    ptr->value = val; ptr->next = NULL;
    if(q->front == NULL){
        q->front = ptr; q->rear = ptr;
        q->front->next = q->rear->next = NULL;
    }
    else{
        q->rear->next = ptr; q->rear = ptr;
        q->rear->next = NULL;
    }
}
void deleteQ(queue *q){
    node *ptr;
    if(q->front == NULL){
        // printf("Underflow\n"); 
        return;
    }
    ptr = q->front; q->front = q->front->next;
    if(q->front == NULL)q->rear = NULL;
    free(ptr);
}

void printFront(queue q){
    node *newNode = q.front;
    if(newNode == NULL)printf("none\n");
    else printf("%d\n", newNode->value);
}

int main(){
    char mode[10];
    queue q = {NULL, NULL};
    while(1){
        scanf("%s", mode);
        if(strcmp(mode,"ENQ") == 0){
            int x;
            scanf("%d", &x);
            insertQ(&q, x);
            // printQueue(q.front);
        }
        if(strcmp(mode,"DEQ") == 0){
            deleteQ(&q);
            // printQueue(q.front);
        }
        if(strcmp(mode,"FRONT") == 0){
            printFront(q);
        }
        if(strcmp(mode,"END") == 0){
            break;
        }
    }
    printQueue(q.front);
}