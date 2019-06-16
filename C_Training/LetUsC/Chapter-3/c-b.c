/*Program to Find Whether a number is even or odd
----------------------------------------------------------
Version  Author           Changelog
----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int in;
  puts("Enter a Number: ");
  scanf("%d",&in);
  if(in%2==0){
    puts("Even Number");
  }else{
    puts("Odd Number");
  }
  return 1;
}
