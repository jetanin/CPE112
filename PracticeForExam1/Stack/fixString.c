#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct node
{
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
    node *newNode = (node*)malloc(sizeof(int));
    newNode->value = val;
    newNode->next = *top;
    *top = newNode;
}

int main(){
    char str[100];
    scanf("%s", str);

    printf("%s", str);


    return 0;
}