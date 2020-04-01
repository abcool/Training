//Program to print table fahr to celcius in reverse order
#include<stdio.h>
int main(){
    int fahr;
    printf("Farenhiet to Celcius table in reverse \n");
    printf("Farenhiet \t Celcius\n");
    for(fahr=300;fahr>=0;fahr=fahr-20){
        printf("%d \t %4.2f\n",fahr,(5.0/9.0)*(fahr-32.0));
    }
    return 0;
}