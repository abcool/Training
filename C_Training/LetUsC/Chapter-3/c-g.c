/*
Program to check valid triangle
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float angle1,angle2,angle3;
puts("Enter three angles of the triangle:");
scanf("%f %f %f",&angle1,&angle2,&angle3 );
//angle1*=180/3.14;
//angle2*=180/3.14;
//angle3*=180/3.14;
if(angle1+angle2+angle3==180){
  puts("Valid Triangle\n");
}else{
  puts("Invalid Triangle\n");
}
return 1;
}
