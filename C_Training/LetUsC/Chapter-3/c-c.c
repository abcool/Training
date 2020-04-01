/*Program to Find Whether an Year is Leap Year or Not
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
  puts("Enter a Year: ");
  scanf("%d",&year);
  if(year%100==0){
    if(year%400==0){
    puts("Leap Year\n");
    }else{
    puts("Non-Leap Year\n");
    }
  }else{
    if(year%4==0){
    puts("Leap Year\n");
    }else{
    puts("Non-Leap Year\n");
    }
  }
  return 1;
}
