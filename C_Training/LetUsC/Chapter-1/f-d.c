#include<stdio.h>
int main(){
  float fr,cent;
  printf("Enter temperature of city: ");
  scanf("%f",&fr);
  cent=((fr-32)*5)/9;
  printf("Temperature in Centigrate: %f",cent);
  return 0;
}
