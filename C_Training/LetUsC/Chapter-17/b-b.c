/*
Program to create structure customer and perform some operations on it
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    08/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<malloc.h>
#include<stdio.h>
struct customer{
  int acc_no;
  char name[26];
  double bal;
};
void initialize(struct customer *, int);
void lowBalance(struct customer *, int);
void updateBalance(struct customer *, int, int);
int main(){
  int n,flag;
  puts("Enter number of customers");
  scanf("%d",&n);
  struct customer *c = (struct customer *) malloc(n * sizeof(struct customer));
  initialize(c,n);
  lowBalance(c,n);
  puts("Choose from below option:");
  puts(" Enter 1. for deposit \n 0. for withdrawl");
  scanf("%d",&flag);
  updateBalance(c,n,flag);
  free(c);
  return 0;
}
void updateBalance(struct customer *c, int n, int f){
  double amount;
  int acc,i;
  switch(f){
    case 1:
          puts("Enter account number");
          scanf("%d",&acc);
          puts("Enter deposit amount");
          scanf("%lf",&amount);
          for(i=0;i<n;i++){
            if((c+i)->acc_no == acc){
              (c+i)->bal +=amount;
            }
          }
          break;
    case 0:
          puts("Enter account number");
          scanf("%d",&acc);
          puts("Enter withdrawl amount");
          scanf("%lf",&amount);
          for(i=0;i<n;i++){
            if((c+i)->acc_no == acc){
              if((c+i)-> bal - amount < 100){
                puts("Insufficient balance for withdrawl");
              }else{
                (c+i)-> bal = amount;
              }
            }
          }
          break;
    default:
          puts("Wrong choice entered.");
  }
}
void lowBalance(struct customer *c, int n){
  int i;
  for(i=0;i<n;i++){
    if(((c+i)->bal) < 100.0){ // Error not printing accounts with balance less than RS. 100 even though logic implemented
      printf("Account No: %d \t Name: %s\n",(c+i)->acc_no, (c+i)->name);
    }
  }
}
void initialize(struct customer *c, int n){
  int i;
  for(i=0;i<n;i++){
    puts("Enter account number");
    scanf("%d",&(c+i)->acc_no);
    puts("Enter initial balance");
    scanf("%lf",&(c+i)->bal);
    puts("Enter customer name");
    scanf(" %[^\n]s",(c+i)->name);
  }
}
