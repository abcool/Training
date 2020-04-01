/*
Program to convert numeric string to integer number
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    22/06/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<string.h>
#include<malloc.h>
#include<math.h>
int parseInt(char *);
char *getsString();
int main(){
  char *s;
  int n;
  s=getsString();
  //printf("String entered:%s\n",s);
  n=parseInt(s);
  printf("Number entered is %d\n",n);
  free(s);
  return 0;
}
int parseInt(char *s){
  int n=0,len,i=0;
  len=strlen(s);
  //printf("Len:%d\n",len);
  if(len==1){
    return (*(s+i)-48);
  }else{
  while(len!=0){
    n+=((*(s+i)-48)*(pow(10,len-1)));
    i++;
    len--;
  }
}
  return n;
}
char *getsString(){
  char ch,*temp;
  int n=0,i=0;
  puts("Enter a number");
  temp=(char *)malloc(n*sizeof(char));
  while((ch=getchar())!='\n'){
    n++;
    temp=realloc(temp,n*sizeof(char));
    *(temp+i)=ch;
    i++;
  }
  return temp;
}
