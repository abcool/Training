/*
Program to printf all ASCII values and their equivalent characters
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int n=0;
  while(n<48){
    printf("ASCII character of %d is %c \n",n,n);
    n++;
  }
  while(n<58){
    printf("ASCII character of %d is %d\n",n,n);
    n++;
  }
  while(n<256){
    printf("ASCII character of %d is %c\n",n,n);
    n++;
  }
  return 1;
}
