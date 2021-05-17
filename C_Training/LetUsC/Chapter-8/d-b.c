/*
Function Power(a,b) to calculate a raised to b
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    11/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int power(int,int);
int main(){
  int n,p;
  puts("Enter the number: ");
  scanf("%d",&n);
  puts("\nEnter it's power: ");
  scanf("%d",&p);
  printf("%d raised to %d is %d\n",n,p,power(n,p));
  return 0;
}
int power(int n,int p){
  int mul=n;
  while(p>1){
    n*=mul;
    p--;
  }
  return n;
}
