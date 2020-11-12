#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {

    return 0;
}

typedef struct node {
    char data[255];
    struct node *next;
} node;

node initlist(char data[]) {
    node *head = NULL;
    head = malloc(sizeof(node));
    if (head == NULL) {
        printf("Out of memory.");
        exit(1);
    }
    head->data = data;
    head->next = NULL;
}

node *newnode(char data[]) {
    int i;
    node *head = NULL;
    node *temp = NULL;
    node *p = NULL;
    temp = (struct node *)malloc(sizeof(struct node));
    temp->clothing[10] = ch[10];
    temp->next = NULL;
    return temp;
}

// 2) print

void print(node *head) {
    node *p = head;
    while (p != NULL) {
        printf("%s", p->clothing);
        p = p->next;
    }
}

int main() {
    node *head = create("clothing");
    print(head);
}