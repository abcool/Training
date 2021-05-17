/*
Program to find factorial of a number
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int n,org;
  long int f=1;
  puts("Enter a number.");
  scanf("%d",&n);
  org=n;
  while(n>1){
    f=f*n;
    n--;
  }
  printf("Factorial of %d is %lu\n",org,f);
  return 1;
}
