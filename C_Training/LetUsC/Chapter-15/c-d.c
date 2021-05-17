/*
Program that converts "123" to 123
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    23/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<string.h>
int convert(char *);
int atoi(char *); //Protoype for built in library function
void gets(char *); //Protoype for built in library function
int main(){
  char ch[20];
  int out,out1;
  puts("Enter a string");
  //scanf("%[^\n]s",ch);
  gets(ch);
  out = convert(ch);
  out1=atoi(ch);
  puts("Number is (using convert)");
    printf("%d\n",out);
  puts("Number is (using in built atoi)");
    printf("%d\n",out1);
  return 0;
}
int convert(char *s){
  int i=0,n=0;
  while(*(s+i)!='\0'){
    if(*(s+i)>=48 && *(s+i)<=57){
      n=n*10+(*(s+i)-48);
    }else{
      puts("Not a valid string");
      n=-1;
    }
    i++;
  }
  return n;
}
