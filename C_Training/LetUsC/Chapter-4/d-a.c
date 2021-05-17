/*
Program to Find year is leap year or not
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int year;
  puts("Enter a year:");
  scanf("%d",&year);
  if(year%400==0 ||year%100!=0 && year%4==0){
    puts("Leap Year.\n");
  }else{
    puts("Non-Leap Year.\n");
  }
return 1;
}
