/*
Program to print 24 hours of a day
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    05/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int i;
  for(i=1;i<=24;i++){
    if(i<12){
      printf("%d AM.\n",i);
    }else if(i==12){
      printf("%d NOON.\n",i);
    }else if(i>12 && i<24){
      printf("%d PM.\n",i-12);
    }else{
      printf("%d MIDNIGHT.\n",i-12);
    }
  }
  return 23;
}
