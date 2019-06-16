/*
Program to obtain mean,absolute,upp->lower, biggestofthree using macros in a header file
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include "c-d.h"
int main(){
  int n1,n2,n3;
  char ch,ch2;
  puts("Enter two numbers: ");
  scanf("%d %d",&n1,&n2);
  n3=MEAN(n1,n2);
  printf("Mean of %d and %d is %d\n",n1,n2,n3);
  puts("Enter a number: ");
  scanf("%d",&n1);
  n2=ABS(n1);
  printf("Absolute value of %d is %d\n",n1,n2);
  fflush(stdin);
  fflush(stdout);
  printf("Enter an uppercase alphabet: ");
  scanf("%c",&ch);
  ch2=UPTOLOW(ch);
  printf("Lowercase of %c is %c\n",ch,ch2);
  puts("Enter three numbers: ");
  scanf("%d %d %d",&n1,&n2,&n3);
  printf("Biggest of %d , %d , %d is %d\n",n1,n2,n3,BIGGEST(n1,n2,n3));
  return 0;
}
