#include <stdio.h>

int* findmin(int* arr, int size) {
    int smallVal = arr[0];
    int * smallRef = &arr[0];
    int i;
    for (i = 1; i < size; i++) {
        if (arr[i] < smallVal) {
            smallVal = arr[i];
            smallRef = &arr[i];
        }
    }
    return smallRef;
}

int main() {
    int arr[] = {1, 4, 5, 6, -1};
    int * m = findmin(arr, 5);
    printf("%d\n", *m); // -1
    int arr2[] = {3, 2, 5};
    m = findmin(arr2, 3);
    printf("%d\n", *m); // 2
    int arr3[] = {0};
    m = findmin(arr3, 1);
    printf("%d\n", *m); // 0
    return 0;
}