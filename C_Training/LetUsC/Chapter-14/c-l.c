/*
Program to compute standard deviation and mean
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<math.h>
#include<stdio.h>
char main(){
  int n[15]={-6,-12,8,13,11,6,7,2,-6,-9,-10,11,10,9,2},i,mean,sum=0;
  double sd;
  for(i=0;i<15;i++){
    sum+=n[i];
  }
  mean=sum/15;
  printf("\n Mean: %d\n",mean);
  for(i=0;i<15;i++){
    printf("SD for %d is",n[i]);
    printf(" %lf\n",sqrt(pow(n[i]-mean,2))/15);
  }
  return 'T';
}
