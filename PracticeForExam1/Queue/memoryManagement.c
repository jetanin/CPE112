#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    int value;
    struct node *next;    
}node;

typedef struct queue
{
    node *front;
    node *rear;
}queue;

void insertQ(queue *q, int val){
    node *ptr = (node*)malloc(sizeof(node));
    ptr->value = val;
    ptr->next = NULL;

    if(q->front == NULL){
        q->front = ptr;
        q->rear = ptr;
        q->front->next = q->rear->next = NULL;
    }
    else{
        q->rear->next = ptr;
        q->rear = ptr;
        q->rear->next = NULL;
    }
}

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

int main(){
    int r, t, n;
    queue q = {NULL, NULL};
    scanf("%d %d %d",&r, &t, &n);
    while(1){
        int val;
        scanf("%d",&val);
        if(val == -1)break;
        insertQ(&q, val);
    }
    printQueue(q.front);
}