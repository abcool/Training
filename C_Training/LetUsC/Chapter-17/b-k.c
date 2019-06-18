/*
Program to implement ascending order linked list
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
  struct node *temp;
  temp=(struct node *)malloc(sizeof(struct node));
  temp->data = val;
  if(n==NULL){
    temp->next=NULL;
    n=temp;
  }else{
    struct node *ptr1,*ptr2;
    ptr1=n;
    int pos=0;
    while(val>=ptr1->data){
      pos++;
      ptr1=ptr1->next;
    }
    if(pos==0){
      temp->next=n;
      n=temp;
    }else{
    ptr1=n+((pos-1)*sizeof(struct node));
    ptr2=n+(pos*sizeof(struct node));
    ptr1->next=temp;
    temp->next=ptr2;
  }
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
  }
}
