/*
Program to print length of longest line and its text
--------------------------------------------------------------------
Version   Date       Author          Changelog
--------------------------------------------------------------------
1.0    23/07/2019  Arvind Bakshi    Initial Version
--------------------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define MAXLINE 1000
int getlines(char line[], int);
void copy(char to[], char from[]);
int main(){
  int len,max;
  char line[MAXLINE],longest[MAXLINE];
  max=0;
  while((len=getlines(line,MAXLINE))>0){
    printf("Length: %d \n Line: %s\n",len,line);
    if(len>max){
      max=len;
      copy(longest,line);
    }
  }
  if(max>0){
    printf("%s",longest);
  }
  return 0;
}
int getlines(char s[], int lim){
  int c,i,j;
  for(i=0,j=0; (c=getchar())!=EOF && c!='\n'; ++i){
    if(i<lim-2){
    s[j]=c;
    ++j;
  }
  }
  if(c=='\n'){
    s[j]=c;
    ++j;
    ++i;
  }
  s[j]='\0';
  return i;
}
void copy(char to[], char from[]){
  int i=0;
  while((to[i]=from[i])!='\0')
        ++i;
}
