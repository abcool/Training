#include<stdio.h>
int main(){
    float lower=0.0, upper=300.0,step=20.0,fahr,celcius;
    fahr=lower;
    printf("Farenhiet to Celcius Table\n");
    printf("Farehiet \t Celcius\n");
    while(fahr<=upper){
        celcius=(5.0/9.0) * (fahr-32.0);
        printf("%3.0f\t %3.2f\n",fahr,celcius);
        fahr+=step;
    }
    return 0;
}