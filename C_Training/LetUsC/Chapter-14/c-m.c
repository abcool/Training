/*
Program to compute areas of six triangle and also greatest triangle
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<math.h>
#include<stdio.h>
int main(){
  double a[6]={137.4,155.2,149.3,160.0,155.6,149.7},
  b[6]={80.9,92.62,97.93,100.25,68.95,120.0},
  angle[6]={0.78,0.89,1.35,9.00,1.25,1.75,},
  ar[6],large;
  int i,plot;
  for(i=0;i<6;i++){
    ar[i] = 0.5*(a[i]*b[i])*sin(angle[i]);
    printf("\nArea of plot %d is %lf\n",i+1,ar[i]);
  }
  large=ar[0];
  plot=1;
  for(i=0;i<6;i++){
    if(ar[i]>large){
      large=ar[i];
      plot = i+1;
    }
  }
  printf("Largest area is of plot %d  equal to %lf\n",plot,large);
  return 0;
}
