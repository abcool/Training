/*
Program to implement two function xgets() and xputs() that work like gets() and puts()
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    22/06/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<malloc.h>
#include<string.h>
char *xgets();
void xputs(char *);
int main(){
  char *in;
  puts("Enter input");
  in=xgets();
  puts("You have entered");
  xputs(in);
  free(in);
  return 0;
}
char *xgets(){
  char ch,*temp;
  int n=0,i=0;
  temp=(char *)malloc(n*sizeof(char));
  while((ch=getchar())!='\n'){
    n++;
    temp=realloc(temp,n*sizeof(char));
    *(temp+i)=ch;
    i++;
  }
  return temp;
}
void xputs(char *s){
  int i;
  for(i=0;i<strlen(s);i++){
    printf("%c",*(s+i));
  }
  printf("\n");
}
