#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct node
{
    int value;
    struct node *next;
}node;

void traverse(node *head){
    node *newNode = head;
    if (head == NULL) {
        printf("none\n");
    } else {
        printf("%d ", newNode->value);
        newNode = newNode->next;
        while (newNode != NULL) {
            printf("=>");
            printf("%d ", newNode->value);
            newNode = newNode->next;
        }
        printf("\n");
    }
}

void insertHead(node **head, int val){
    node *newNode;  
    
    newNode = (node*)malloc(sizeof(node));
    newNode->value = val;
    newNode->next = *head;
    *head = newNode;
}

void insertEnd(node **head, int val){
    node *newNode, *ptr;
     
    newNode = (node*)malloc(sizeof(node));
    newNode->value = val;
    newNode->next = NULL;

    if (*head == NULL) {
        *head = newNode;
    } else {
        ptr = *head;
        while(ptr->next != NULL){
            ptr = ptr->next;
        }
        ptr->next = newNode;
    }
}

void insertLeft(node **head, int R, int val){
    node *newNode, *ptr, *prePtr;
    newNode = (node*)malloc(sizeof(node));
    newNode->value = val;
    newNode->next = NULL;

    if (*head == NULL) {
        return;
    }

    if ((*head)->value == R) {
        newNode->next = *head;
        *head = newNode;
        return;
    }

    ptr = *head;
    prePtr = NULL;

    while (ptr != NULL && ptr->value != R)
    {
        prePtr = ptr;
        ptr = ptr->next;
    }
    if(ptr == NULL){
        return;
    }

    prePtr->next = newNode;
    newNode->next = ptr; 
}

void deleteHead(node **head){
    node *temp;

    if(*head == NULL){
        return;
    }

    temp = *head;
    *head = (*head)->next;
    free(temp);
}

void deleteEnd(node **head){
    node *temp, *ptr, *prePtr;
    if(*head == NULL){
        return;
    }

    ptr = *head;
    prePtr = NULL;
    while (ptr->next != NULL) {
        prePtr = ptr;
        ptr = ptr->next;
    }
    prePtr->next = NULL;
}

void delete(node **head, int val){
    node *temp, *ptr, *prePtr;
    if(*head == NULL){
        return;
    }

    ptr = *head;
    prePtr = NULL;
    while (ptr != NULL && ptr->value != val) {
        prePtr = ptr;
        ptr = ptr->next;
    }

    if (ptr == NULL) {
        return;
    }

    if (prePtr == NULL) {
        *head = ptr->next;
    } else {
        prePtr->next = ptr->next;
    }
}

int main(){
    node *head = NULL;
    char buffer[10];
    int a, b;
    while(1){
        scanf("%s", buffer);
        if(strcmp(buffer,"INSH") == 0){
            scanf(" %d", &a);
            insertHead(&head, a);
            traverse(head); //<=========
        }
        else if(strcmp(buffer,"INSE") == 0){
            scanf(" %d", &a);
            insertEnd(&head, a);
            traverse(head); //<=========
        }
        else if(strcmp(buffer,"INSL") == 0){
            scanf(" %d %d", &a, &b);
            insertLeft(&head, a, b);
            traverse(head); //<=========
        }
        else if(strcmp(buffer,"DELH") == 0){
            deleteHead(&head);
            traverse(head); //<=========
        }
        else if(strcmp(buffer,"DELE") == 0){
            deleteEnd(&head);
            traverse(head); //<=========
        }
        else if(strcmp(buffer,"DEL") == 0){
            scanf(" %d", &a);
            delete(&head, a);
            traverse(head); //<=========
        }
        else if(strcmp(buffer,"END") == 0){
            traverse(head); 
            break;
        }
    }

    return 0;
}