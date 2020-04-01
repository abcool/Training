/*
Program to calculate overtime of the employees
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int n=10,i=0;
  while(n>0){
    int hours;
    printf("Enter work hours of %d employee\n",i+1);
    scanf("%d",&hours);
    if(hours>40){
      int extra=hours-40;
      printf("Overtime amount of %d employee is %d\n",i,extra*12);
    }else{
      puts("NO Overtime.\n");
    }
    i++;
    n--;
  }
  return 1;
}
