/*
Program to count the number of occurences of two vowels in succession
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    29/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int count(char *);
void gets(char *);
int main(){
  char s[100];
  puts("Enter a sentence");
  gets(s);
  int n= count(s);
  printf("The number of two successive vowels =  %d\n",n);
  return 0;
}
int count(char *s){
  int i=0,count=0;
  while(*(s+i)!='\0'){
    if( *(s+i)=='a' || *(s+i)=='A' || *(s+i)=='e' || *(s+i)=='E' || *(s+i)=='i' || *(s+i)=='I' ||
       *(s+i)=='o' || *(s+i)=='O' || *(s+i)=='u' || *(s+i)=='U' ){
         if( *(s+i+1)=='a' || *(s+i+1)=='A' || *(s+i+1)=='e' || *(s+i+1)=='E' || *(s+i+1)=='i' || *(s+i+1)=='I' ||
            *(s+i+1)=='o' || *(s+i+1)=='O' || *(s+i+1)=='u' || *(s+i+1)=='U' ){
              //printf("%c %c\n",*(s+i),*(s+i+1));
              count++;
            }
       }
       i++;
  }
  return count;
}
