/*
Program to find absolute value of a number
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float number;
  puts("Enter a number: ");
  scanf("%f",&number);
  if(number<0){
    number*=-1;
  }
  printf("%f\n",number);
  return 1;
}
