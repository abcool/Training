/*
Program to Find whether entered character is capital letter,small letter, a digit or a special symbol
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
char in;
puts("Enter a character:");
scanf("%c",&in);
if(in>=65 && in<=90){
  puts("Capital Letter.\n");
}else if(in>=97 && in<=122){
  puts("Small Letter.\n");
}else if(in>=48 && in<=57){
  puts("A Number.\n");
}else{
  puts("A Special Symbol.\n");
}
return 1;
}
