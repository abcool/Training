/*
Iterative Function to print binary equivalent of a number
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    21/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int binary(int);
int main(){
  int in;
  puts("Enter a number:");
  scanf("%d",&in);
  printf("Binary of %d is %d",in,binary(in));
  return 0;
}
int binary(int n){
  int sum=0,mul=1,r;
  while(n>0){
    r=(n%2)*mul;
    sum+=r;
    n/=2;
    mul*=10;
  }
  return sum;
}
