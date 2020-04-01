/*
Program to calculate a number raised to another number(pow(x,y))
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int n,p;
  long int f=1;
  puts("Enter number & its power");
  scanf("%d %d",&n,&p);
  int power=p;
  while(p>0){
    f*=n;
    p--;
  }
  printf("%d to the power %d is %lu\n",n,power,f);
  return 1;
}
