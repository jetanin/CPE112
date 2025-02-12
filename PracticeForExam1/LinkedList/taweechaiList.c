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
    int n1, n2, num;
    node *newNode1 = NULL, *newNode2 = NULL;
    scanf("%d", &n1);
    for(int i = 0; i < n1; i++){
        scanf("%d", &num);
        insert(&newNode1, num);
    }
    scanf("%d", &n2);
    for(int i = 0; i < n2; i++){
        scanf("%d", &num);
        insert(&newNode2, num);
    }

    traverse(newNode1);
    traverse(newNode2);

    return 0;
}