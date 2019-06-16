/*
Program to check whether character is alphabet or not using macros
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define ISALPHABET(a)(a>=65 && a<=90 || a>=97 && a<=122?printf("Alphabet\n"):printf("Not Alphabet\n"))
int main(){
char ch;
puts("Enter a character");
scanf("%c",&ch);
ISALPHABET(ch);
return 0;
}
