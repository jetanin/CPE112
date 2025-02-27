#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    int value;
    struct node *next;
}node;

void traverse(node *Node){
    node *ptr = Node;
    if(Node == NULL)printf("none\n");
    else{
        while(ptr != NULL){
            printf("%d ", ptr->value);
            ptr = ptr->next;
        }
        printf("\n");
    }
}

void insert(node **Node, int val){
    node *newNode = (node*)malloc(sizeof(node));
    newNode->value = val;
    newNode->next = NULL;

    if(*Node == NULL)*Node = newNode;
    else{
        node *ptr = *Node;
        while (ptr->next != NULL)
        {
            ptr = ptr->next;
        }
        ptr->next = newNode;
    }

}


int main(){
    int num;
    node *head = NULL;
    for(int i = 0; i < 5; i++){
        scanf("%d", &num);
        insert(&head, num);
    }
    for(int i = 0; i < 5; i++){
        scanf("%d", &num);
        insert(&head, num);
    }
    traverse(head);

    return 0;
}