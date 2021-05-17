/*
Recursive Function to print binary equivalent of a number
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
  static int sum=0,div=1;
  int r;
  if(n!=0){
    r=(n%2)*div;
    sum+=r;
    div*=10;
    return binary(n/2);
  }else{
    return sum;
  }
}
