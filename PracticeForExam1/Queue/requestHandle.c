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

void printQ(node *Q){
    node *newNode = Q;
    if(Q == NULL)printf("none\n");
    else {
        while (Q != NULL){
            printf("%d ", Q->value);
            Q = Q->next;
        }
        printf("\n");
    }
}

void insertQ(queue *Q, int val){
    node *ptr = (node*)malloc(sizeof(node));
    ptr->value = val;
    ptr->next = NULL;

    if(Q->front == NULL){
        Q->front = ptr;
        Q->rear = ptr;
        Q->front->next = Q->rear->next = NULL;
    }else{
        Q->rear->next = ptr;
        Q->rear = ptr;
        Q->rear->next = NULL;
    }
}

void deleteQ(queue *Q){
    node *ptr;
    if(Q->front == NULL)return;
    ptr = Q->front;
    Q->front = Q->front->next;

    if(Q->front == NULL)Q->rear = NULL;

    free(ptr);
}

int main(){
    int x, t, count = 0;
    queue Q = {NULL, NULL};
    scanf("%d", &x); //each request use x ms
    while(1){
        scanf("%d", &t); //request at t ms
        if(t == -1)break;
        insertQ(&Q, t);
        count++;
        
        while(Q.front != NULL && t >= Q.front->value + x)
        {
            deleteQ(&Q);
            count--;
        }

        if(Q.front != NULL){
            // printQ(Q.front);
            printf(" %d\n", count);
        } else {
            printf("none ");
        }
    }
    return 0;
}