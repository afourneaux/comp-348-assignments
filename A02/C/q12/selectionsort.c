#include "selectionsort.h"
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>

void selectionsort(int toSort[], int size, int* (*min)(int*,int)) {
    int bound;
    int* smallest;
    int swap;
    if (min == NULL) {
        printf("No compare function given.");
        exit(1);
    }
    for (bound = 0; bound < size; bound++) {
        smallest = min(&toSort[bound], size - bound);
        swap = toSort[bound];
        toSort[bound] = *smallest;
        *smallest = swap;
    }
}