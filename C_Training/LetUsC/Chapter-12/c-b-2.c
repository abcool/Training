/*
Program to check whether character is uppercase letter or not using macros
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define ISUPPER(a)(a>=65 && a<=90?printf("Uppercase Letter\n"):printf("Not Uppercase\n"))
int main(){
char ch;
puts("Enter a character");
scanf("%c",&ch);
ISUPPER(ch);
return 0;
}
