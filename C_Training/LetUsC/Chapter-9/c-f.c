/*
Function to determine whether a point lies inside the triangle or not
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<math.h>
float distance(float *, float *, float *, float *);
float area(float *, float *, float *);
int inside(float *, float *, float *, float *);
int main(){
  float x1,y1,x2,y2,x3,y3,x,y,ar1,ar2,ar3,ar,d1,d2,d3;
  puts("Enter coordinates (x,y) of first point of the triangle: ");
  scanf("%f %f", &x1,&y1);
  puts("Enter coordinates (x,y) of second point of the triangle: ");
  scanf("%f %f", &x2,&y2);
  puts("Enter coordinates (x,y) of third point of the triangle: ");
  scanf("%f %f", &x3,&y3);
  d1=distance(&x1,&y1,&x2,&y2);
  d2=distance(&x2,&y2,&x3,&y3);
  d3=distance(&x1,&y1,&x3,&y3);
  ar = area(&d1,&d2,&d3);
  puts("Enter coordinates of the point: ");
  scanf("%f %f", &x,&y);
  float d4,d5,d6;
  d4=distance(&x1,&y1,&x,&y);
  d5=distance(&x2,&y2,&x,&y);
  d6=distance(&x3,&y3,&x,&y);
  ar1=area(&d1,&d4,&d5);
  ar2=area(&d2,&d5,&d6);
  ar3=area(&d3,&d4,&d6);
  if(inside(&ar1,&ar2,&ar3,&ar)){
    puts("Point inside triangle");
  }else{
    puts("Point Outside Triangle");
  }
  return 0;
}
float distance(float *a, float *b, float *c, float *d){
  float ans;
  ans = sqrt(pow((*c - *a),2) + pow((*d - *b),2));
  return ans;
}
float area(float *s1, float *s2, float *s3){
  float s,aa;
  s = (*s1 + *s2 + *s3)/2;
  aa = sqrt(s* (s - *s1) * (s - *s2) * (s- *s3));
  return aa;
}
int inside(float *a1, float *a2, float *a3, float *aout){
  if((*a1 + *a2 + *a3)- *aout <= 0.009){
    return 1;
  }else{
    return 0;
  }
}
