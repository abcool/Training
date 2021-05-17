#include<stdio.h>
#define LOWER 0
#define UPPER 300
#define STEP 20
int main(){
float fahr,celsius;
celsius=LOWER;
puts("--------------------------|");
puts("Celsius->Farenhiet Table  |");
puts("--------------------------|");
printf("Celsius\t|\tFarenhiet |\n");
puts("--------------------------|");
while(celsius<=UPPER){
fahr=(celsius*9.0)/5.0+32.0;
//celsius=(5.0/9.0)*(fahr-32.0);
printf("%3.0f \t|\t %6.1f\t  |\n",celsius,fahr);
celsius=celsius+STEP;
}
puts("--------------------------");
return 0;
}
