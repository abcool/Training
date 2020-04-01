/*
Program to sort names stored in array in alphabetic order
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<string.h>
#include<stdio.h>
void sort(char *[]);
int main(){
  char *s[]={
    "We wish u a merry christmas",
    "Happy Holi!",
    "Happy Diwali",
    "Happy New Year",
    "Happy Basant Panchami",
    "Happy Birthday"
  };
  int i;
  sort(s);
  puts("Sorted entries are:");
  for(i=0;i<6;i++){
    printf("%s\n",s[i]);
  }
  return 0;
}
void sort(char *s[]){
  int i,j;
  char *temp;
  for(i=0;i<6; i++){
    for(j=i+1;j<6;j++){
      if(strcmp(s[i],s[j])>0){
        temp=s[i];
        s[i]=s[j];
        s[j]=temp;
      }
    }
  }
}
