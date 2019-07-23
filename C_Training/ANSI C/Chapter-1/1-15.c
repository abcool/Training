/*
Program to convert Fahrenheit temperatures to Celsius using function
--------------------------------------------------------------------
Version   Date       Author          Changelog
--------------------------------------------------------------------
1.0    01/07/2019  Arvind Bakshi    Initial Version
--------------------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define UPPER 300
#define LOWER 0
#define STEP 20
float toCelsius(int);
int main(){
  int fahr;
  //float celsius;
  for(fahr=LOWER;fahr<=UPPER;fahr=fahr+STEP){
    //celsius=toCelsius(fahr);
    printf("Fahr: %d \t Celsius: %f\n",fahr,toCelsius(fahr));
  }
  return 0;
}
float toCelsius(int fahr){
  return (5.0/9.0)*(fahr-32);
}
