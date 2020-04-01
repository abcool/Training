/*
Program to obtain area,perimeter of triangle,circle,square using macros in areaperi.h file
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<math.h>
#include "areaperi.h"
int main(){
  int n1,n2,n3,p;
  float r,ar;
  puts("Enter sides of triangle: ");
  scanf("%d %d %d", &n1,&n2,&n3);
  ar=TRIAREA(n1,n2,n3);
  p=TRIPERI(n1,n2,n3);
  printf("Area and perimeter of triangle is %f %d\n",ar,p);
  puts("Enter side of square: ");
  scanf("%d",&n1);
  printf("Area of square is %d \n Perimeter of Square is %d\n",SQAREA(n1),SQPERI(n1));
  puts("Enter radius of circle: ");
  scanf("%f",&r);
  printf("Area of circle is %f \n Perimeter of circle is %f\n",CIRCAREA(r),CIRCPERI(r));
  return 0;
}
