/*
Menu driven program
1. Factorial of a number
2. Prime or not
3. Odd or even
4. Exit
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    10/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int choice,number;
  char ans='y';
  while(ans=='y'){
    puts("Please choose one of the below options.");
    printf("1. Factorial of the number. \n 2. Check number prime or not. \n 3. Check number odd or even. \n 4. Exit.\n");
    scanf("%d",&choice);
    switch(choice){
      case 1:
          puts("Enter a number: ");
          scanf("%d",&number);
          int fact=1;
          while(number>1){
            fact*=number;
            number--;
          }
          printf("Factorial of %d is %d\n",number,fact);
          break;
      case 2:
          puts("Enter the number: ");
          scanf("%d",&number);
          int div=2;
          while(div<number){
            if(number%div ==0){
              puts("Not prime.");
              break;
            }else{
            div++;
            }
          }
          if(div==number){
            puts("Prime Number.");
          }
          break;
      case 3:
          puts("Enter the number: ");
          scanf("%d",&number);
          if(number%2==0){
            puts("Even number");
          }else{
            puts("Odd Number");
          }
          break;
      case 4:
          ans='n';
          break;
    }
  }
  return 0;
}
