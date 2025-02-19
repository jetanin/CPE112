#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node {
    char value;
    struct node *next;
} node;

void push(node **top, char val) {
    node *newNode = (node*)malloc(sizeof(node));
    newNode->value = val;
    newNode->next = *top;
    *top = newNode;
}

char pop(node **top) {
    if (*top == NULL) {
        return '\0';
    }
    node *temp = *top;
    char value = temp->value;
    *top = (*top)->next;
    free(temp);
    return value;
}

int isMatchingPair(char character1, char character2) {
    if (character1 == '(' && character2 == ')') return 1;
    else if (character1 == '{' && character2 == '}') return 1;
    else if (character1 == '[' && character2 == ']') return 1;
    else return 0;
}

int areBracketsBalanced(char exp[]) {
    node *stack = NULL;
    for (int i = 0; i < strlen(exp); i++) {
        if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') {
            push(&stack, exp[i]);
        } else if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
            if (stack == NULL) {
                return 0; // Unbalanced
            } else if (!isMatchingPair(pop(&stack), exp[i])) {
                return 0; // Unbalanced
            }
        }
    }
    return stack == NULL; // Balanced if stack is empty
}

int main() {
    char exp[100];
    printf("Enter an expression: ");
    scanf("%s", exp);

    if (areBracketsBalanced(exp)) {
        printf("Balanced\n");
    } else {
        printf("Not Balanced\n");
    }

    return 0;
}