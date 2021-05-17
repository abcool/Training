/*
Program to convert an integer to an octal
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    01/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<math.h>
#include<stdio.h>
_Bool main(){
  int n1,n2,octal,r,p;
  puts("Enter a number:");
  scanf("%d",&n1);
  n2=n1;
  p=0;
  octal=0;
  while(n2>0){
    r=n2%8;
    n2=n2/8;
    octal=octal+r*pow(10,p);
    p++;
  }
  printf("Octal number of %d is %d",n1,octal);
  return 1;
}
