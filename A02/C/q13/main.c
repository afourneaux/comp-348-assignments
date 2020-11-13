#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct node {
    char data[255];
    struct node *next;
} node;

static node* initlist(char data[]);
static node* insert_dictionary_order(node* head, char* word);
static void print(node *head);
static int find_dict_index(node* head, char* word);

int main() {
    char line[255];
    char delimit[]= "\t\r\n\v\f "; //All whitespace characters
    node *head = NULL;
    printf("Please enter a list of words separated by a white space (space char, tab or newline).\n");
    gets(&line);
    while (strcmp(line, ".") != 0) {
        char *word = strtok(line, delimit);
        while( word != NULL ) {
            if (head == NULL) {
                head = initlist(word);
            } else {
                head = insert_dictionary_order(head, word);
            }
            word = strtok(NULL, " ");
        }
        gets(&line);
    }
    print(head);
    return 0;
}

static node* initlist(char data[]) {
    node *head = NULL;
    head = malloc(sizeof(node));
    if (head == NULL) {
        printf("ERROR: Out of memory.");
        exit(1);
    }
    strcpy(head->data, data);
    head->next = NULL;
    return head;
}

static node* insert_dictionary_order(node* head, char* word) {
    node *newnode = malloc(sizeof(node)), *temp = head;
    int i, index = find_dict_index(head, word);

    if (newnode == NULL) {
        printf("ERROR: Out of memory.");
        exit(1);
    }
    strcpy(newnode->data, word);
    newnode->next = NULL;

    if (index == 0) {
        newnode->next = head;
        head = newnode;
        return head;
    }

    for (i=0; i<index-1; i++) {
        if(temp->next == NULL) {
            break;
        }
        temp = temp->next;
    }
    newnode->next = temp->next;
    temp->next = newnode;
    return head;
}

static int find_dict_index(node* head, char* word) {
    int n = 0;
    node *p = head;
    while (p != NULL) {
        if (strcmp(p->data, word) > 0) { //if after in order
            break;
        } else {
            n+=1;
            p = p->next;
        }
    }
    return n;
}

static void print(node *head) {
    node *p = head;
    while (p != NULL) {
        printf("%s -> ", p->data);
        p = p->next;
    }
}