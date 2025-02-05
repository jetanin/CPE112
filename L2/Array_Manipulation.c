#include<stdio.h>
#include<stdlib.h>

void printArr(int *arr, int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", *(arr + i));
    }
    printf("\n");
}

int* insertArr(int *arr, int size, int index, int value) {
    if (index > size) {
        printf("Index out of bounds\n");
        return arr;
    }
    int* newArr = malloc((size + 1) * sizeof(int));
    int i = 0;
    for (i; i < index; i++) {
        *(newArr + i) = *(arr + i);
    }
    *(newArr + index) = value;
    for (i; i < size; i++) {
        *(newArr + i + 1) = *(arr + i);
    }
    free(arr);
    printArr(newArr, size + 1);
    return newArr;
}

int* deleteArr(int *arr, int size, int index) {
    if (index >= size) {
        printf("Index out of bounds\n");
        return arr;
    }
    int* newArr = malloc((size - 1) * sizeof(int));
    int i = 0;
    for (i; i < index; i++) {
        *(newArr + i) = *(arr + i);
    }
    for (i = index; i < size - 1; i++) {
        *(newArr + i) = *(arr + i + 1);
    }
    free(arr);
    printArr(newArr, size - 1);
    return newArr;
}

int* mergeArr(int *arr1, int size1, int *arr2, int size2) {
    int* merged = malloc((size1 + size2) * sizeof(int));
    for (int i = 0; i < size1; i++) {
        *(merged + i) = *(arr1 + i);
    }
    for (int j = 0; j < size2; j++) {
        *(merged + size1 + j) = *(arr2 + j);
    }
    printArr(merged, size1 + size2);
    return merged;
}

int main() {
    int n;
    scanf("%d", &n);
    int* arr1 = malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        scanf("%d", arr1 + i);
    }

    int m;
    scanf("%d", &m);
    int* arr2 = malloc(m * sizeof(int));
    for (int i = 0; i < m; i++) {
        scanf("%d", arr2 + i);
    }
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);

    arr1 = insertArr(arr1, n, a, b);
    if (a <= n) {
        n++;
    }

    arr1 = deleteArr(arr1, n, c);
    if (c < n) {
        n--;
    }

    int* arr3 = mergeArr(arr1, n, arr2, m);
    free(arr3);
    return 0;
}