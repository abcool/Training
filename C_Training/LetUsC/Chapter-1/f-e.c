#include<stdio.h>
int main()
{
float len,breadth,radius,ar_rect,peri_rect,ar_circ,circum_circ;
printf("Enter length,breadth of rectangle");
scanf("%f %f",&len,&breadth);
printf("Enter radius of circle:");
scanf("%f",&radius);
ar_rect = len*breadth;
peri_rect = 2*(len+breadth);
ar_circ = 3.14*radius*radius;
circum_circ = 2*3.14*radius;
printf("%f %f %f %f", ar_rect,peri_rect,ar_circ,circum_circ);
return 0;
}
