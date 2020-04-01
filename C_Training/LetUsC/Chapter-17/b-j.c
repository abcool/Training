/*
Program to implement queue using linked list
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
struct node *enQueue(struct node *);
struct node *deQueue(struct node *);
void listQueue(struct node *);
int main(){
  int choice,flag=1;
  do{
    puts("Select choice:");
    puts("1. Enqueue");
    puts("2. Dequeue");
    puts("3. List queue");
    puts("4. Exit");
    scanf("%d",&choice);
    switch(choice){
      case 1:
            d=enQueue(d);
            break;
      case 2:
            d=deQueue(d);
            break;
      case 3:
            listQueue(d);
            break;
      case 4:
            free(d);
            flag=0;
            break;
      default:
            puts("Wrong choice,please try again");
    }
  }while(flag);
  return 0;
}
struct node *enQueue(struct node *n){
  int val;
  puts("Enter a value");
  scanf("%d",&val);
  struct node *temp,*ptr;
  temp=(struct node *)malloc(sizeof(struct node));
  temp->data=val;
  if(n==NULL){
    temp->next=NULL;
    n=temp;
  }else{
    ptr=n;
    while(ptr->next!=NULL){
      ptr=ptr->next;
    }
    ptr->next=temp;
    temp->next=NULL;
  }
  return n;
}
struct node *deQueue(struct node *n){
  if(n==NULL){
    puts("Empty queue, nothing to remove.");
  }else{
    struct node *temp,*ptr;
    ptr=temp=n;
    ptr=ptr->next;
    temp->next=NULL;
    free(temp);
    n=ptr;
  }
  return n;
}
void listQueue(struct node *n){
  if(n==NULL){
    puts("Empty queue.");
  }else{
    struct node *ptr;
    ptr=n;
    while(ptr!=NULL){
      printf("|%d|-",ptr->data);
      ptr=ptr->next;
    }
  }
}
