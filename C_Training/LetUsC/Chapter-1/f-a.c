#include<stdio.h>
int main(){
  float basic,da,hra,gross;
  printf("Enter Ramesh's Salary: ");
  scanf("%f",&basic);
  da=0.4*basic;
  hra=0.2*basic;
  gross=basic+da+hra;
  printf("Gross: %f\n",gross);
  return 0;
}
