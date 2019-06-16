/*
Program to check whether point lies on x-axis or y-axis or on origin
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float x,y;
  puts("Enter coordinates of the point");
  scanf("%f %f",&x,&y);
  if(x==0 && y!=0){
    puts("Point lies on Y-axis\n");
  }else if(y==0 && x!=0){
    puts("Point lies on X-axis\n");
  }else if(x==0 && y==0){
    puts("Point is at origin\n");
  }
  return 1;
}
