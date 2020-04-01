/*
Program to implement linked list
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    30/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<malloc.h>
struct node{
  int data;
  struct node *next;
};
struct node *d=NULL;
struct node *addAtBegin(struct node *);
struct node *addAtEnd(struct node *);
struct node *addAtMiddle(struct node *);
struct node *display(struct node *);
int main(){
  //d=(struct node*)malloc(sizeof(struct node));
  int flag=1,option;
  while(flag){
    puts("Please choose an option from below:");
    puts("1. Add element at the beginning");
    puts("2. Add element at the end");
    puts("3. Add element in the middle");
    puts("4. Display linked list");
    puts("5. Exit");
    scanf("%d",&option);
    switch(option){
      case 1:
            d=addAtBegin(d);
            break;
      case 2:
            d=addAtEnd(d);
            break;
      case 3:
            d=addAtMiddle(d);
            break;
      case 4:
            d=display(d);
            break;
      default:
            flag=0;
            free(d);
    }
  }
  return 0;
}
struct node *addAtBegin(struct node *n){
  struct node *new_node;
  int val;
  puts("Enter an integer value");
  scanf("%d",&val);
  new_node = (struct node *)malloc(sizeof(struct node));
  new_node->data=val;
  new_node->next=n;
  n=new_node;
  return n;
}
struct node *addAtEnd(struct node *n){
  int val;
  puts("Enter an integer value");
  scanf("%d",&val);
  struct node *new_node,*ptr;
  new_node = (struct node *)malloc(sizeof(struct node));
  ptr=n;
  while(ptr->next!=NULL){
    ptr=ptr->next;
  }
  new_node->data=val;
  new_node->next=NULL;
  ptr->next=new_node;
  return n;
}
struct node *addAtMiddle(struct node *n){
  struct node *new_node,*ptr2,*ptr1;
  int len=0,pos,i,val;
  ptr2=n;
  while(ptr2->next!=NULL){
    len++;
    ptr2=ptr2->next;
  }
  pos=len/2;
  ptr2=n;
  for(i=0;i<pos;i++){
    ptr2=ptr2->next;
  }
  ptr1=ptr2;
  ptr2=ptr2->next;
  puts("Enter a value");
  scanf("%d",&val);
  new_node=(struct node *)malloc(sizeof(struct node));
  new_node->data=val;
  ptr1->next=new_node;
  new_node->next=ptr2;
  return n;
}
struct node *display(struct node *n){
  struct node *ptr;
  ptr=n;
  while(ptr!=NULL){
    printf("|%d|->",ptr->data);
    ptr=ptr->next;
  }
  printf("NULL");
  return n;
}
