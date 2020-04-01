#include<stdio.h>
#include<malloc.h>

struct node{
  int value;
  struct node *next;
};
struct node *start = NULL; // The value at address stored in start is a structure.
struct node *createList(struct node *); // Prototype declaration to Create Linked List
struct node *displayList(struct node *); // Prototype declaration to Display Linked List.
int main(){
  setbuf(stdout, NULL);
  int option;
  do{
    printf("\n **************Main Menu**************");
    printf("\n Please Select an option from below \n");
    printf("1. Create Linked List \n");
    printf("2. Display Linked List \n");
    printf("3. Exit \n");
    scanf("%d",&option);
    switch (option){
      case 1: start = createList(start);
              printf("Linked List Created");
              break;
      case 2: start= displayList(start);
              break;
    }
  }while(option!= 3);
  return 0;
}
struct node *createList(struct node *start){
  setbuf(stdout, NULL);
  struct node *new_node, *ptr;
  int num;
  printf("\n Enter data or -1 to stop\n");
  scanf("%d",&num);
  while(num!=-1){
    new_node = (struct node*)malloc(sizeof(struct node));
    new_node -> value = num;
    if(start==NULL){
      new_node -> next = NULL;
      start = new_node;
    }else{
      ptr=start;
      while(ptr->next!=NULL){
        ptr=ptr->next;
      }
        ptr->next = new_node;
        new_node->next=NULL;
      }
      //printf("\n Enter the Data: ");
      scanf("%d",&num);
  }
  return start;
}
struct node *displayList(struct node *start){
  struct node *ptr;
  ptr = start;
  while(ptr!=NULL){
    printf("| %d |->", ptr->value);
    ptr = ptr->next;
  }
  printf("NULL");
  return start;
}
