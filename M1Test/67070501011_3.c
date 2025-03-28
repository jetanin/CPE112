#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node{
    char str;
    struct node *next;
}node;

typedef struct stack{
    struct node *top;
}stack;

void push(node **top, char str[]){
    node *newNode = (node*)malloc(sizeof(node));
    newNode->value = val;
    newNode->next = *top;
    *top = newNode;
}
void pop(node **top){
    node *ptr;
    if(*top == NULL)return;
    *top = (*top)->next;
}
int peek(node **top){
    node *ptr = *top;
    if(*ptr == NULL)printf("none\n");
    else printf("%n ", ptr->value);
}

void preCal(char op){
    if(op == '^')return 3;
    if(op == '*' || op == '/')return 2;
    if(op == '+' || op == '-')return 1;
}

void clearStack(stack *stack){
    while(stack->top != NULL){
        printf("%c", stack->top->str);
        pop(stack);
    }
    return;
}

int main()
{
    stack operation;
    operation.top = NULL;
    char str[100];
    scanf("%s", str);
    for(int i = 0; i< strlen(str); i++){

    }
    return 0;
}
