// Compile using gcc -lm h-c.c
#include<stdio.h>
#include<math.h>
int main(){
  float s1,s2,s3,ar,s;
  printf("Enter sides of triangle:");
  scanf("%f %f %f",&s1,&s2,&s3);
  s=(s1+s2+s3)/2;
  ar=sqrt(s*(s-s1)*(s-s2)*(s-s3));
  printf("Area of Triangle: %f\n",ar);
  return 0;
}
