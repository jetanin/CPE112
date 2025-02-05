#include<stdio.h>
#include<stdlib.h>

int top, MAX;

void push(int stack[], int val){
    if(top == MAX-1){
        printf("Overflow\n");
        return;
    }
    top++;
    stack[top] = val;
}

int pop(int stack[]){
    int val;
    if(top == -1){
        printf("Underflow\n");
        return -1;
    }else{
        val = stack[top];
        top--;
        return val;
    }
}

int peek(int stack[]){
    if(top == -1){
        printf("Stack is empty. \n");
        return -1;
    }
    return stack[top];
}

int main(){

}