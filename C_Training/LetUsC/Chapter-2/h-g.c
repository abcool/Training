#include<stdio.h>
#include<math.h>
int main(){
  float angle,sangle,cangle,tangle,cotangle;
  printf("Enter angle: ");
  scanf("%f",&angle);
  //angle*=180/3.14;
  printf("Trignometric ratios are %f %f %f %f", sin(angle)*180/3.14,cos(angle)*180/3.14,tan(angle)*180/3.14,1/tan(angle)*180/3.14);
  return 0;
}
