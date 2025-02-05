#include<stdio.h>
#include<stdlib.h>
int main(){
    int arr_size, mode;
    scanf("%d ", &arr_size);

    int *arr = (int*)malloc(arr_size*sizeof(int));

    for(int i = 0; i < arr_size; i++){
        scanf(" %d ", arr+i);
    }

    scanf(" %d", &mode);

    int j;
    if(mode == 0){
        for(int i = 0; i < arr_size; i+=2){
            printf("%d ", *(arr+i));
        }
    }
    else if(mode == 1){
        if(arr_size < 2){
            printf("none");
        }
        else{
            for(int i = 1; i < arr_size; i+=2){
                printf("%d ", *(arr+i));
            }
        }
    }
    free(arr);
    return 0;
}