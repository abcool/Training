//Celcius to Farenhiet table
#include<stdio.h>
int main(){
    float lower=0.0,upper=300.0,step=20.0,celcius=lower;
    int fahr;
    printf("Celcius to Farehiet Table\n");
    printf("Celcius \t Farehiet\n");
    while(celcius<=upper){
        fahr = (celcius *9.0)/5.0 + 32.0;
        printf("%3.2f \t %d \n",celcius,fahr);
        celcius=celcius+step;
    }
    return 0;
}