/*
Function to print average and percentage of marks obtained by student
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    17/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void result(float *, float *);
_Bool main(){
  float avg,per;
  result(&avg,&per);
  printf("Average marks: %f \n Percentage: %f \%\n",avg,per);
  return 1;
}
void result(float *av, float *per){
  float s1,s2,s3;
  puts("Enter marks of three subjects: ");
  scanf("%f %f %f",&s1,&s2,&s3);
  *per=*av = (s1+s2+s3)/3.0f;
}
