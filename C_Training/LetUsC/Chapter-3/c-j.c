/*
Program to check whether 3 points lie on a straight line
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float x1,y1,x2,y2,x3,y3;
  puts("Enter coordinates of first point");
  scanf("%f %f",&x1,&y1);
  puts("Enter coordinates of second point");
  scanf("%f %f",&x2,&y2);
  puts("Enter coordinates of third point");
  scanf("%f %f",&x3,&y3);
  if((y2-y1)/(x2-x1)==(y3-y2)/(x3-x2)){
    puts("Points lie on a straight line.\n");
  }else{
    puts("Points don't lie on a straight line");
  }
  return 1;
}
