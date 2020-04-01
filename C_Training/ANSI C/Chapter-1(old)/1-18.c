/*
Program to remove trailing blanks and tabs from each line of input,
and to delete entirely blank lines
--------------------------------------------------------------------
Version   Date       Author          Changelog
--------------------------------------------------------------------
1.0    24/07/2019  Arvind Bakshi    Initial Version
--------------------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define MAXLENGTH 1000
int main(){
  int c,i;
  char ch[MAXLENGTH];
  while((c=getchar())!=EOF){ // reading multiple lines
    i=0;
    while(c!='\n'){ // reading one line
        ch[i]=c;
        ++i;
      c=getchar();
    }
    ch[i]='\0';
    int blank=0,j;
    i=0;
    while(ch[i]!='\0'){ // checking entire blank line
      if(ch[i]==' ')
          ++blank;
      i++;
    }
    j=i;
    while(j>0 && (ch[j]==' ' || ch[j]=='\t')){ //moving backwards
      j--;
    }
    ch[j]='\0'; //eliminating trailing blanks and tabs
    if(blank<i) // printing accepted lines
      printf("%s\n",ch);
  }
  return 0;
}
