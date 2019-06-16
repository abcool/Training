/*
Function to determine GCD of two numbers using Euclid's Algorithm
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int gcd(int *, int *);
int main(){
  int n1,n2,n3,hcf;
  puts("Enter two numbers: ");
  scanf("%d %d",&n1,&n2);
  hcf = gcd(&n1,&n2);
  printf("GCD of %d & %d is %d\n",n1,n2,hcf);
  return 0;
}
int gcd(int *a, int *b){
  int div,dd,r;
  if(*a > *b){
    div = *b; dd= *a;
  }else{
    div = *a; dd=*b;
  }
  while(dd%div !=0){
    r= dd%div;
    dd=div;
    div=r;
  }
  return div;
}
