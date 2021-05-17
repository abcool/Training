/*
Program to check whether character is smallcase letter or not using macros
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define ISSMALL(a)(a>=97 && a<=122?printf("Smallcase Letter\n"):printf("Not Smallcase\n"))
int main(){
char ch;
puts("Enter a character");
scanf("%c",&ch);
ISSMALL(ch);
return 0;
}
