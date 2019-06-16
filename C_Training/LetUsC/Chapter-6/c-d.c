/*
Program to print multiplication table of a number entered by the user
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    03/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int n,i;
  puts("Enter a Number:");
  scanf("%d",&n);
  for(i=0;i<=10;i++){
    printf("%d * %d = %d\n",n,i,n*i);
  }
  return 0;
}
