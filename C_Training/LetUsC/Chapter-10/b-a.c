/*
Recursive Function to calculate sum of digits of a 5-digit number
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    21/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int sum(int);
int main(){
  int in,s;
  puts("Enter a number: ");
  scanf("%d",&in);
  s=sum(in);
  printf("Sum of digits of %d is %d\n",in,s);
  return 0;
}
int sum(int x){
  int out=0,r;
  if(x==0){
    return out;
  }else{
    r=x%10;
    out=r+sum(x/10);
  }
}
