/*
Program to compute correlation coefficient
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
  float x[11]={34.22,39.87,41.85,43.23,40.06,53.29,53.29,54.14,49.12,40.71,55.15},
  y[]={102.43,100.93,97.43,97.81,98.32,98.32,100.07,97.08,91.59,94.85,94.65},xy=0,a=0,b=0;
  double r,xsq,ysq;
  int i;
  for(i=0;i<11;i++){
    xy+=x[i]*y[i];
    a+=x[i];
    b+=y[i];
    xsq+=(xsq*xsq);
    ysq+=(ysq*ysq);
  }
  r=(xy-(a*b))/(sqrt(((11*xsq)-(a*a))*((11*ysq)-(b*b))));
  printf("Correlation coefficient is %lf\n",r);
  return 0;
}
