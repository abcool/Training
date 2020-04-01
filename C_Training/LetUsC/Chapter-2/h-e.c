#include<stdio.h>
#include<math.h>
int main(){
  double l1,l2,g1,g2,d;
  printf("Enter Latitude & Longitude of Location 1:\n");
  scanf("%lf %lf",&l1,&g1);
  printf("Enter Latitude & Longitude of Location 2:\n");
  scanf("%lf %lf",&l2,&g2);
  l1*=3.14/180;
  l2*=3.14/180;
  g1*=3.14/180;
  g2*=3.14/180;
  d=3963*acos(sin(l1)*sin(l2)+cos(l1)*cos(l2)*cos(g2-g1));
  printf("Total Distance: %lf\n",d);
  return 0;
}
