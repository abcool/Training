/*
Program to Find whether reversed and original number are same or not
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int number,original,reversed=0,multiplier=10000;
  puts("Enter a number:");
  scanf("%d",&number);
  original=number;
  while(number>0){
    short clc=number%10;
    reversed+=clc*multiplier;
    number/=10;
    multiplier/=10;
  }
  if(reversed==original){
    puts("Equal");
  }else{
    puts("Not Equal");
  }
  return 1;
}
