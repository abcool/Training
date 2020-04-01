/*
Function to calculate factorial of a number
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    11/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int factorial(int);
int main(){
  int number;
  puts("Enter a Number: ");
  scanf("%d",&number);
  printf("Factorial of %d is %d\n",number,factorial(number));
  return 0;
}
int factorial(int n){
  int f=1;
  while(n>1){
    f*=n;
    n--;
  }
  return f;
}
