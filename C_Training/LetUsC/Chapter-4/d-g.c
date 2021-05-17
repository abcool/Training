/*
Program to find BMI of a person
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float weight,height,bmi;
  puts("Enter weight and height of a person");
  scanf("%f %f",&weight,&height);
  bmi=weight/(height*height);
  if(bmi<15){
    puts("Starvation.\n");
  }else if(bmi>15 && bmi<=17.5){
    puts("Anorexic.\n");
  }else if(bmi>=17.6 && bmi<=18.5){
    puts("Underweight.\n");
  }else if(bmi>=18.6 && bmi<=24.9){
    puts("Ideal.\n");
  }else if(bmi>=25 && bmi<=25.9){
    puts("Overweight");
  }else if(bmi>=30 && bmi<=30.9){
    puts("Obese.\n");
  }else if(bmi>=40){
    puts("Morbidly Obese.\n");
  }
  return 1;
}
