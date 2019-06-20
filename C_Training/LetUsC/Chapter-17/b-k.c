/*
Program to implement ascending order linked list
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/06/2019  Arvind Bakshi    Initial Version
1.1    20/06/2019  Arvind Bakshi    Fixed segmentation fault issue
2.0    20/06/2019  Arvind Bakshi    Replaced whole logic with a working one
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
struct node *add(struct node *);
void display(struct node *);
int main(){
  int choice,flag=1;
  do{
    puts("Select choice:");
    puts("1. Enter into linked list");
    puts("2. Display linked list");
    puts("3. Exit");
    scanf("%d",&choice);
    switch(choice){
      case 1:
            d=add(d);
            break;
      case 2:
            display(d);
            break;
      case 3:
            free(d);
            flag=0;
            break;
      default:
            puts("Wrong choice entered, please try again");
    }
  }while(flag);
  return 0;
}
struct node *add(struct node *n){
  int val;
  puts("Enter a value");
  scanf("%d",&val);
  struct node *temp,*ptr=n;
  temp=(struct node *)malloc(sizeof(struct node));
  temp->data = val;
  if(n==NULL || val<n->data){
    temp->next=n;
    n=temp;
  }else{
    while(ptr->next!=NULL){
      if(ptr->data<=val &&(ptr->next->data>val || ptr->next==NULL)){
        temp->next=ptr->next;
        ptr->next=temp;
        return n;
      }
      ptr=ptr->next;
    }
    temp->next=NULL;
    ptr->next=temp;
  }
  return n;
}
void display(struct node *n){
  if(n==NULL){
    puts("Empty linked list,nothing to display");
  }else{
    struct node *ptr=n;
    while(ptr!=NULL){
      printf("|%d|->",ptr->data);
      ptr=ptr->next;
    }
    printf("NULL\n");
  }
}
