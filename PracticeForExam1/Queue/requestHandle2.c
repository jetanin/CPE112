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

void insert(queue *q, int val){
    node *ptr = (node*)malloc(sizeof(node));
    ptr->value = val;
    ptr->next = NULL;
    if(q == NULL)return;

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

void delete(queue *q){
    node *ptr;
    if(q->front == NULL)return;
    ptr = q->front;
    q->front = q->front->next;

    if(q->front == NULL)q->rear = NULL;

    free(ptr);
}



int main(){
    int x, t, count = 0;
    queue q = {NULL, NULL};
    printf("Each task use ");
    scanf("%d", &x);
    while(1){
        printf("Request at : ");
        scanf("%d", &t);
        if(t == -1)break;
        insert(&q, t);
        count++;

        while (q.front != NULL && t >= q.front->value + x) 
        {
            delete(&q);
            count--;
        }
        printf("running : %d tasks.\n", count);
    }
    return 0;
}