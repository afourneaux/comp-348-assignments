#include "selectionsort.h"
#include "selectionsort.h" // included twice
#include<stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

static int* findmin(int* arr, int size);
static int* findmax(int* arr, int size);
static int* getarray(int n);
static void printarr(int* arr, int size, int* (*comparator)(int*,int));
static double average(int* arr, int size);
static double standarddeviation(int* arr, int size, int mean);

int main(void) {
    int i, n;
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int *p_array = getarray(n);

    int* (*minfunc)(int*,int) = findmin;
    int* (*maxfunc)(int*,int) = findmax;

    //Ascending
    printarr(p_array, n, minfunc);
    printf("-----------------------\n");
    printarr(p_array, n, maxfunc);

    free(p_array);
    return 0;
}

static int* getarray(int n)
{
    //Allocate memory and create pointer
    int *p_array;
    int i;

    p_array = (int *)calloc(n, sizeof(int));

    //Error handling
    if(p_array == NULL) {
        printf("Out of memory.\n");
        exit(1);
    }

    //Assign random integers to array
    srand(time(NULL));
    for(i = 0; i < n; i++) {
        p_array[i] = rand() % 100;
    }

    return p_array;
}

static void printarr(int* arr, int size, int* (*comparator)(int*,int)) {
    int i;
    double avg;

    selectionsort(arr, size, comparator);

    for (i = 0; i < size; i++) {
        printf("%d: %d\n", i, arr[i]);
    }

    avg = average(arr, size);

    printf("\nMax: %d\n", *findmax(arr, size));
    printf("Min: %d\n", *findmin(arr, size));
    printf("Average: %f\n", avg);
    printf("Standard Deviation: %f\n\n", standarddeviation(arr, size, avg));
}

static int* findmin(int* arr, int size) {
    int val = arr[0];
    int * ref = &arr[0];
    int i;
    for (i = 1; i < size; i++) {
        if (arr[i] < val) {
            val = arr[i];
            ref = &arr[i];
        }
    }
    return ref;
}

static int* findmax(int* arr, int size) {
    int val = arr[0];
    int * ref = &arr[0];
    int i;
    for (i = 1; i < size; i++) {
        if (arr[i] > val) {
            val = arr[i];
            ref = &arr[i];
        }
    }
    return ref;
}

static double average(int* arr, int size) {
    int i;
    int sum = 0;
    for (i = 0; i < size; i++) {
        sum += arr[i];
    }
    return sum/size;
}

static double standarddeviation(int* arr, int size, int avg) {
    int i;
    double newsum = 0;

    for (i = 0; i < size; i++) {
        newsum += pow(arr[i]-avg, 2);
    }

    return sqrt(newsum/size);
}