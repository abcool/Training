#include<stdio.h>
#define LOWER 0
#define UPPER 300
#define STEP 20
int main(){
float fahr,celsius;
fahr=LOWER;
puts("--------------------------|");
puts("Farehiet->Celsuis Table   |");
puts("--------------------------|");
printf("Fahr \t|\t Celsius  |\n");
puts("--------------------------|");
while(fahr<=UPPER){
celsius=(5.0/9.0)*(fahr-32.0);
printf("%3.0f \t|\t %6.1f\t  |\n",fahr,celsius);
fahr=fahr+STEP;
}
return 0;
}
