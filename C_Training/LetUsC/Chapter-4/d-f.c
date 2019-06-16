/*
Program to find grade of steel
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float h,cc,ts;
  puts("Enter hardness,carbon content & tensile strength of steel");
  scanf("%f %f %f",&h,&cc,&ts);
  if(h>50 && cc<0.7 && ts>5600){
    puts("Grade of steel is 10.\n");
  }else if(h>50 && cc<0.7){
    puts("Grade of steel is 9.\n");
  }else if(cc<0.7 && ts>5600){
    puts("Grade of steel is 8.\n");
  }else if(h>50 && ts>5600){
    puts("Grade of steel is 7.\n");
  }else if(h>50 || cc<0.7 || ts>5600){
    puts("Grade of steel is 6.\n");
  }else{
    puts("Grade of steel is 5.\n");
  }
  return 1;
}
