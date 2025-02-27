#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct node{
    int value;
    struct node *next;
}node;
void printStack(node *top){
    node *newNode = top;
    if(top == NULL)printf("none\n");
    else{
        while(newNode != NULL){
            printf("%d ", newNode->value);
            newNode = newNode->next;
        }
        printf("\n");
    }
}
void push(node **top, int val){
    node *newNode = (node*)malloc(sizeof(node));
    newNode->value = val; newNode->next = *top;
    *top = newNode;
}
void pop(node **top){
    node *ptr;
    if(*top == NULL) return;
    *top = (*top)->next;
}
int peek(node *top){
    node *newNode = top;
    if(newNode == NULL)printf("none\n");
    else printf("%d\n", newNode->value);
}

int main(){
    char mode[10];
    node *top = NULL;
    while(1){
        scanf("%s", mode);
        if(strcmp(mode,"PUSH") == 0){
            int x;
            scanf("%d", &x);
            push(&top, x);
            // printStack(top);
        }
        if(strcmp(mode,"POP") == 0){
            pop(&top);
            // printStack(top);
        }
        if(strcmp(mode,"PEEK") == 0){
            peek(top);
        }
        if(strcmp(mode,"END") == 0){
            break;
        }
    }
    printStack(top);
}