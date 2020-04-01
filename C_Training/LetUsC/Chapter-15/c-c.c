/*
Program to extract part of string from a specified location
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    23/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void extract(char *, int, int);
int main(){
  char ch[]="Hello World!";
  int loc,n;
  puts("Enter a string");
  scanf("%[^\n]s",ch);
  puts("Enter number of characters to extract");
  scanf("%d",&n);
  if(n>0){
    puts("Enter the beginning position");
    scanf("%d",&loc);
    extract(ch,loc,n);
  }else{
    puts(ch);
  }
  return 0;
}
void extract(char *p, int l, int s){
  int i;
  for(i=l-1;i<l+s-1;i++){
    printf("%c",*(p+i));
  }
  printf("\n");
}
