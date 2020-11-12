#include "selectionsort.h"
#include "selectionsort.h" // included twice
#include<stdio.h>

int arr[] = {1, 4, 5, 6, -1 };
int main() {
    int i;
    selectionsort(arr, 5);
    for(i = 0; i < 5; i++) printf("%d ", arr[i]);
    return 0;
}