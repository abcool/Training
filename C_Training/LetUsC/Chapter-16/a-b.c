/*
Program to check whether input string is embedded in any of the strings in given array of pointers to strings
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<string.h>
void gets(char *);
int compare(char *[], char *);
int main(){
  char *str[]={
    "We will teach you how to",
    "Move a mountain",
    "Level a building",
    "Erase the past",
    "Make a million",
    "all through C!"
  }, s[20];
  puts("Enter a string");
  gets(s);
  if(compare(str,s)){
    puts("String present");
  }else{
    puts("String not present");
  }
  return 0;
}
int compare(char *p[],char *s){
  int i;
  for(i=0;i<6;i++){
    if(strcmp(p[i],s)==0){
      return 1;
    }
  }
  if(i==6){
    return 0;
  }
}
