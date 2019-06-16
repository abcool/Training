/*
Function to calculate area of a triangle
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<math.h>
void area(float *, float *, float *, float *);
int main(){
  float a,b,c,ar;
  puts("Enter sides of the triangle: ");
  scanf("%f %f %f", &a, &b,&c);
  area(&a,&b,&c,&ar);
  printf("Area of triangle is %f\n",ar);
  return 0;
}
void area(float *a, float *b, float *c, float *ar){
  float s;
  s=(*a + *b + *c)/2;
  *ar = sqrt(s*(s- *a)*(s- *b)*(s- *c));
}
