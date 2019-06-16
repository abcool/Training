/*
Program to check whether point lies inside the circle
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<math.h>
#include<stdio.h>
_Bool main(){
  float x,y,radius,p1,p2;
  puts("Enter coordinates of center of circle");
  scanf("%f %f",&x,&y);
  puts("Enter radius of circle");
  scanf("%f",&radius);
  puts("Enter coordinates of a point");
  scanf("%f %f",&p1,&p2);
  if(sqrt(pow(p1-x,2)+pow(p2-y,2))<radius){
    puts("Point is inside the circle.");
  }else{
    puts("Point outside the circle");
  }
  return 1;
}
