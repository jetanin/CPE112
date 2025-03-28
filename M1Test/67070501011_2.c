#include<stdio.h>
#include<stdlib.h>


//ปรกาศตัวแปรnode เก็บค่าตัวเลขและ address
typedef struct node{
	int value;
	struct node* next;
}node;

//แสดงทุกตัวเลขในทุกnode
void printList(node *head){
	node *ptr = head;
	if(head = NULL)return;
	else{
        while(ptr != NULL){
            printf("%d ", ptr->value);
            ptr = ptr->next;
        }
	}
}

//เพิ่มlist
void circularLL(node **head, int val){
	node *curNode;
	node *newNode = (node*)malloc(sizeof(node));
	newNode->value = val;
	newNode->next = NULL;

	if(*head == NULL){
		*head = newNode;
		newNode->next = *head;
		return;
	}
	curNode = *head;
	while(curNode->next != *head){
		curNode = curNode->next;
	}
	curNode->next = newNode;
	newNode->next = *head;
}

//หาสมาชิกสุดท้าย
void findLastNum(node **head, int val){
	if(*head == NULL)return;
	node *curNode = *head, *prevNode;
	while(curNode->next != *head){
		curNode = curNode->next;
	}
	prevNode = curNode;
	curNode = prevNode->next;

	while(curNode != curNode->next){
		int i = 0;
		for(i; i < val-1; i++){
			prevNode = curNode;
			curNode = curNode->next;
		}
		prevNode->next = curNode->next;
		free(curNode);
		curNode = prevNode->next;
	}
	*head = curNode;
}


int main(){
	int N, K;
	node *head = NULL;
	scanf("%d %d", &N, &K);
	int i = 0;
	for(i; i < N; i++){
		int num;
		scanf("%d", &num);
		circularLL(&head, num);
	}
	findLastNum(&head, K);
	//printList(head);
	printf("%d", head->value);
	return 0;
}
