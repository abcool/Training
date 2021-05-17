/*
Program to obtain bigger of two numbers using macros
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define BIGGER(n1,n2)(n1>n2?n1:n2)
int main(){
int in1,in2;
puts("Enter two numbers: ");
scanf("%d %d",&in1,&in2);
printf("Bigger of %d and %d is %d\n",in1,in2,BIGGER(in1,in2));
return 0;
}
