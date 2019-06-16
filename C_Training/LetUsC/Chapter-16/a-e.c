/*
Program to remove all vowels from a sentence
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    28/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<string.h>
#include<stdio.h>
void gets(char *);
void vRemove(char *);
int main(){
  char s[100];
  puts("Enter a sentence");
  gets(s);
  vRemove(s);
  puts("New Sentence");
  puts(s);
  return 0;
}
void vRemove(char *s){
  int len,i=0,j;
  len = strlen(s);
  printf("%d\n",len);
  while(*(s+i)!='\0'){
    while(*(s+i)=='a'|| *(s+i)=='A' || *(s+i)=='e' || *(s+i)=='E' || *(s+i)=='i' || *(s+i)=='I' || *(s+i)=='o' || *(s+i)=='O' || *(s+i)=='u' || *(s+i)=='U')
    {
      for(j=i;j<len;j++){
        *(s+j)=*(s+j+1);
      }
    }
    i++;
  }
}
