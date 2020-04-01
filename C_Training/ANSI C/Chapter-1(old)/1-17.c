/*
Program to print lines that are greater than 80 characters in length
--------------------------------------------------------------------
Version   Date       Author          Changelog
--------------------------------------------------------------------
1.0    24/07/2019  Arvind Bakshi    Initial Version
--------------------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define MAXLENGTH 1000
#define MINLENGTH 80
int main(){
  int c,i;
  char ch[MAXLENGTH];
  while((c=getchar())!=EOF){
    i=0;
    while(c!='\n'){
      ch[i]=c;
      ++i;
      c=getchar();
    }
    ch[i]='\0';
    if(i>MINLENGTH){
      printf("%s\n",ch);
    }
  }
  return 0;
}
