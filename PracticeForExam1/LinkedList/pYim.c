#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    int value;
    struct node *next;
}node;

void traverse(node **head){
    node *ptr = *head;
    if(*head == NULL)return;
    else {
        while(*head != NULL){
            printf("%d ", ptr->value);
            ptr = ptr->next;
        }
    }   
}

void insert(node **head, int val){
    node *newNode = (node*)malloc(sizeof(node));
    node *ptr;
    newNode->value = val;
    newNode->next = NULL;

    if(*head == NULL){
        *head = newNode;
    }else{
        ptr = *head;
        while(ptr->next != NULL){
            ptr = ptr->next;
        }
        ptr->next = newNode;
    }
}

void delete(node **head, int val){
    node *ptr, *prePtr, *temp;
    if(*head == NULL)return;
    ptr = *head;
    prePtr = ptr;

    while(ptr != NULL && ptr->value != val){
        prePtr = ptr;
        ptr = ptr->next;
    }

    if(ptr == NULL)return;

    if(prePtr == NULL){
        *head = ptr->next;
    }else{
        temp = ptr; 
        prePtr->next = ptr->next;
    }
    free(ptr);
}

int main(){
    int n, k, num;
    node *head = NULL, *ptr;
    scanf("%d %d", &n, &k);
    for(int i = 0; i < n; i++){
        scanf("%d", &num);
        insert(&head, num);
    }

    
}