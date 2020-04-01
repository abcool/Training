/*
Function to determine leap year
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    11/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void leap(int);
int main(){
  int year;
  puts("Enter a year: ");
  scanf("%d",&year);
  leap(year);
  return 0;
}
void leap(int y){
  if(y%400==0){
    puts("Leap Year\n");
  }else if(y%100!=0 && y%4==0){
    puts("Leap Year\n");
  }else{
    puts("Non-Leap Year\n");
  }
}
