/*
Program to implement stack using linked list
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/06/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<malloc.h>
struct node{
  int data;
  struct node *next;
};
struct node *n=NULL;
struct node *push(struct node *);
struct node *pop(struct node *);
void display(struct node *);
int main(){
  int choice,flag=1;
  do{
    puts("Select option from below:");
    puts("1. Push");
    puts("2. Pop");
    puts("3. Display");
    puts("4. Exit");
    scanf("%d",&choice);
    switch(choice){
      case 1:
            n=push(n);
            break;
      case 2:
            n=pop(n);
            break;
      case 3:
            display(n);
            break;
      case 4:
            flag = 0;
            free(n);
            break;
      default:
            puts("Wrong Choice!");
            puts("Try again!");
    }
  }while(flag);
  return 0;
}
struct node *push(struct node *d){
  int val;
  puts("Enter a value:");
  scanf("%d",&val);
  struct node *temp;
  temp = (struct node *)malloc(sizeof(struct node));
  temp->data = val;
  temp->next=d;
  d=temp;
printf("\n Successfully pushed %d into stack\n",val);
return d;
}
 struct node *pop(struct node *d){
  if(d==NULL){
    puts("Can't pop, stack is empty");
  }else{
  struct node *ptr,*ptr2;
  ptr=ptr2=d;
  ptr=ptr->next;
  ptr2->data=0;
  ptr2->next=NULL;
  free(ptr2);
  d=ptr;
}
  return d;
}
void display(struct node *d){
  if(d==NULL){
    puts("Stack empty! Nothing to display.");
  }else{
  struct node *ptr;
  ptr=d;
  while(ptr!=NULL){
    printf("|%d|\n",ptr->data);
    ptr=ptr->next;
  }
}
}
