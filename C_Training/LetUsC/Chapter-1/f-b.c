#include<stdio.h>
int main(){
float km,m,ft,in,cm;
printf("Enter Distance: ");
scanf("%f",&km);
m=km*1000;
cm=m*100;
ft=km*3280.8399;
in=km*39370.0787;
printf("Distance in \n M: %f \n CM: %f \n Foot: %f \n Inch: %f \n",m,cm,ft,in);
return 0;
}
