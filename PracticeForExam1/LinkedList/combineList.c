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

void insertEnd(node **Node, int val){
    node *newNode, *ptr;

    newNode = (node*)malloc(sizeof(node));
    newNode->value = val;
    newNode->next = NULL;

    if(*Node == NULL){
        *Node = newNode;
    }else {
        ptr = *Node;
        while(ptr->next != NULL){
            ptr = ptr->next;
        }
        ptr->next = newNode;
    }
}


int main(){
    int n1, n2, num;
    node *head = NULL;
    scanf("%d", &n1);
    int *num1 = (int*)malloc(n1 * sizeof(int));
    int *num2 = (int*)malloc(n2 * sizeof(int));
    for(int i = 0; i < n1; i++){
        scanf("%d", &num);
        num1[i] = num;
    }
    scanf("%d", &n2);
    for(int i = 0; i < n2; i++){
        scanf("%d", &num);
        num2[i] = num;
    }
    // for(int i = 0; i < n1; i++){
    //     printf("%d ", *(num1+i));
    // }
    // for(int i = 0; i < n2; i++){
    //     printf("%d ", *(num2+i));
    // }
    int count1 = 0, count2 = 0;
    while(count1 < n1 || count2 < n2){
        if(count1 < n1){
            // printf("%d ", *(num1+count1));
            insertEnd(&head, num1[count1]);
            count1++;
        }
        if(count2 < n2){
            // printf("%d ", *(num2+count2));
            insertEnd(&head, num2[count2]);
            count2++;
        }
    }

    printf("\n");
    traverse(head);
    free(num1);
    free(num2);

    return 0;
}