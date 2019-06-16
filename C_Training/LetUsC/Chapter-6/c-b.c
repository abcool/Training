/*
Program to add first seven terms of 1/1! +2/2! + 3/3!... and so on.
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    03/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int i;
  float sum=0,fact;
  for(i=1;i<=7;i++){
    fact=1.0;
    for(int j=1;j<=i;j++){
      fact*=j;
    }
    sum=sum+(i/fact);
  }
  printf("%f\n",sum);
  return 0;
}
