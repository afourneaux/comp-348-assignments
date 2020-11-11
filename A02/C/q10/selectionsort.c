#include "selectionsort.h"

static int* findmin(int* arr, int size) {
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

void selectionsort(int toSort[], int size) {
    int bound;
    int* smallest;
    int swap;
    for (bound = 0; bound < size; bound++) {
        smallest = findmin(&toSort[bound], size - bound);
        swap = toSort[bound];
        toSort[bound] = *smallest;
        *smallest = swap;
    }
}