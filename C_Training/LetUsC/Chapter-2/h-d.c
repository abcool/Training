#include<stdio.h>
#include<math.h>
int main(){
  float x1,x2,r,theta;
  printf("Enter Cartesian Coordinates: ");
  scanf("%f %f", &x1,&x2);
  r=sqrt(x1*x1+x2*x2);
  theta = atan2(x2,x1);
  theta*=180/3.14;
  printf("Polar Coordinates: R= %f | Theta= %f\n", r,theta);
  return 0;
}
