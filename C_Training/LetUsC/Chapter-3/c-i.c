/*
Program to find whether area of rectangle is greater than perimeter
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float length,breadth;
  puts("Enter length & breadth of rectangle\n");
  scanf("%f %f",&length,&breadth);
  if(length*breadth > 2*(length+breadth)){
    puts("Area is greater than perimeter");
  }else{
    puts("Perimeter is greater than area");
  }
  return 1;
}
