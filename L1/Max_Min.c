#include<stdio.h>

int main(){
    int n;
    int max = -9999;
    int index_max = 0;
    int min = 9999;
    int index_min = 0;
    int index = 0;
    while(1){
        scanf("%d", &n);
        if(n == -9999)break;
        if (n > max){
            max = n;
            index_max = index;
        }
        if (n < min){
            min = n;
            index_min = index;
        }   
        index++;
    }

    printf(" %d %d\n", max, index_max+1);
    printf(" %d %d\n", min, index_min+1);
}