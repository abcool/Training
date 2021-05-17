/*
Program to calculate Simple interest & amount using macros in a header file interest.h
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include "interest.h"
int main(){
  float p,r;
  int t;
  puts("Enter principle,rate of interest and time(in years): ");
  scanf("%f %f %d",&p,&r,&t);
  printf("Simple interest is %f\n",SI(p,r,t));
  printf("Net Amount after interest is %f\n",AMOUNT(SI(p,r,t),p));
  return 0;
}
