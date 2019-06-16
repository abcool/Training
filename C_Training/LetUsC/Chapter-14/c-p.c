/*
Program to compute distance between first and last point
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<math.h>
float distance(float, float ,float ,float);
int main(){
  float x[10],y[10],sum=0,dis;
  int i;
  puts("Enter coordinates of 10 points");
  for(i=0;i<10;i++){
    scanf("%f%f",&x[i],&y[i]);
  }
  for(i=0;i<10;i++){
    if(i+1<10){
    dis=distance(x[i],y[i],x[i+1],y[i+1]);
    sum+=dis;
    }
  }
  printf("\nDistance between first and last point is %f\n",sum);
  return 0;
}
float distance(float x1, float y1, float x2, float y2){
  return(sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
}
