/*
Program to print amount for set of 10 values
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    04/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<math.h>
#include<stdio.h>
int main(){
  int p,n,q,i;
  float a,r;
  for(i=0;i<10;i++){
    printf("Enter values of p,r,n and q: ");
    scanf("%d %f %d %d",&p,&r,&n,&q);
    a=p*pow((1+(r/q)),(n*q));
    printf("Amount is %f\n",a);
  }
  return 0;
}
