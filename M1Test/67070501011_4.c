#include<stdio.h>
#include<stdlib.h>

typedef struct node{
	int value;
	struct node* next;
}node;

typedef struct queue{
	struct node* front;
	struct node* rear;
}queue;

//เพิ่มคิว
void enQueue(queue *q, int val){
	node *newNode = (node*)malloc(sizeof(node));
	newNode->value = val;
	newNode->next = NULL;
	if(q->rear == NULL){
		q->front = q->rear = newNode;
		return;
	}

	q->rear->next = newNode;
	q->rear = q->rear->next;
}
//ลบตัวแรกออกจากคิว
void deQueue(queue *q){
	if(q->front == NULL)return;
	node *temp = q->front;
	q->front = q->front->next;
	if(q->front == NULL){
		q->rear = NULL;
	}
	free(temp);
}


int main(){
	int x, num, R, T, N, count1 = 0 , count2 = 0;
	queue q ;
	q.front = NULL;
	q.rear = NULL;
	scanf("%d", &x);

	while(1){
		scanf("%d", &num);
		if(num == -1)break;
		enQueue(&q, num);
		count1++;
	}
	scanf("%d %d %d", &R, &T, &N);

	while(N <= T && q.front != NULL && q.front->value < R){
		int usage = 0;
		while(usage < R && q.front != NULL){
			if(q.front->value + usage > R)break;
			usage += q.front->value;
			deQueue(&q);
			count2++;
		}
		N -= T;
	}
	printf("%d %d",count1-count2, count2);
	return 0;
}
