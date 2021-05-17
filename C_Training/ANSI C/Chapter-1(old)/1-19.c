/*
Program to reverse an input a line at a time
--------------------------------------------------------------------
Version   Date       Author          Changelog
--------------------------------------------------------------------
1.0    27/07/2019  Arvind Bakshi    Initial Version
--------------------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define MAXLENGTH 1000
void reverse(char []);
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
    reverse(ch);
  }
  return 0;
}
void reverse(char ch[]){
  int len=0,i;
  for(i=0;ch[i]!='\0';i++)
        len++;
  for(i=len;i>=0;i--){
    printf("%c",ch[i]);
  }
}
