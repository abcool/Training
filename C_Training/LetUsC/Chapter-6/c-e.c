/*
Program to print intelligence Table
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    03/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int y;
  float x,clc;
  printf("i \t y \t x\n");
  for(y=1;y<=6;y++){
    for(x=5.5;x<=12.5;x=x+0.5){
      clc=2+(y+(0.5*x));
      printf("%f \t %d \t %f\n",clc,y,x);
    }
  }
  return 0;
}
