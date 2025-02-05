#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void insertHead(int x) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = x;
    newNode->next = head;
    head = newNode;
}

void insertEnd(int x) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = x;
    newNode->next = NULL;

    if (head == NULL) {
        head = newNode;
        return;
    }

    struct Node *temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
}

void insertLeft(int a, int b) {
    if (head == NULL) return;

    struct Node *current = head;
    struct Node *prev = NULL;

    while (current != NULL) {
        if (current->data == a) {
            struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
            newNode->data = b;

            if (prev == NULL) {
                newNode->next = head;
                head = newNode;
            } else {
                prev->next = newNode;
                newNode->next = current;
            }
            return;
        }
        prev = current;
        current = current->next;
    }
}

void deleteHead() {
    if (head == NULL) return;
    struct Node *temp = head;
    head = head->next;
    free(temp);
}

void deleteEnd() {
    if (head == NULL) return;
    if (head->next == NULL) {
        free(head);
        head = NULL;
        return;
    }

    struct Node *prev = NULL;
    struct Node *current = head;
    while (current->next != NULL) {
        prev = current;
        current = current->next;
    }
    prev->next = NULL;
    free(current);
}

void deleteNode(int a) {
    if (head == NULL) return;

    struct Node *current = head;
    struct Node *prev = NULL;

    while (current != NULL) {
        if (current->data == a) {
            if (prev == NULL) {
                head = current->next;
            } else {
                prev->next = current->next;
            }
            free(current);
            return;
        }
        prev = current;
        current = current->next;
    }
}

int main() {
    char command[10];
    int x, a, b;

    while (scanf("%s", command) != EOF) {
        if (strcmp(command, "END") == 0) {
            break;
        } else if (strcmp(command, "INSH") == 0) {
            scanf("%d", &x);
            insertHead(x);
        } else if (strcmp(command, "INSE") == 0) {
            scanf("%d", &x);
            insertEnd(x);
        } else if (strcmp(command, "INSL") == 0) {
            scanf("%d %d", &a, &b);
            insertLeft(a, b);
        } else if (strcmp(command, "DELH") == 0) {
            deleteHead();
        } else if (strcmp(command, "DELE") == 0) {
            deleteEnd();
        } else if (strcmp(command, "DEL") == 0) {
            scanf("%d", &a);
            deleteNode(a);
        }
    }

    if (head == NULL) {
        printf("none\n");
    } else {
        struct Node *current = head;
        while (current != NULL) {
            printf("%d ", current->data);
            current = current->next;
        }
        printf("\n");
    }

    // Free remaining nodes
    while (head != NULL) {
        struct Node *temp = head;
        head = head->next;
        free(temp);
    }

    return 0;
}