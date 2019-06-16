/*
Program to printf all Armstrong numbers between 1 and 500
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    28/02/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int lp=1;
  while(lp<=500){
    int last=lp%10;
    int second=lp%100;
    second=(second-last)/10;
    int first=lp/100;
    if((last*last*last)+(second*second*second)+(first*first*first)==lp){
      printf("%d\n",lp);
    }
    lp++;
  }
  return 1;
}
