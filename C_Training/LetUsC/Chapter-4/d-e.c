/*
Program that converts R,G,B values to C,M,Y,K
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float red,green,blue,white,c,m,y,k,max;
  puts("Enter values of R,G,B");
  scanf("%f %f %f",&red,&green,&blue);
  if(red==0 && green==0 && blue==0){
    c=m=y=0;
    k=1;
  }else{
    red=red/255;
    green=green/255;
    blue=blue/255;
    max=red;
    if(green>max){
      max=green;
    }else if(blue>max){
      max=blue;
    }
  }
  white=max;
  c=(white-red)/white;
  m=(white-green)/white;
  y=(white-blue)/white;
  k=1-white;
  printf("C= %f M= %f Y= %f K= %f\n",c,m,y,k);
  return 1;
}
