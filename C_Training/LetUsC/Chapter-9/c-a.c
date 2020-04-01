/*
Function to print sum, average and standard deviation using pointers
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    17/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<math.h>
void opr(int *, int *,int *, int *, int *, int *, float *, float *);
int main(){
  int n1,n2,n3,n4,n5,sum;
  float avg,sd;
  puts("Enter 5 numbers: ");
  scanf("%d %d %d %d %d", &n1,&n2,&n3,&n4,&n5);
  opr(&n1,&n2,&n3,&n4,&n5,&sum,&avg,&sd);
  printf("Sum is %d \n Average is %f \n Standard Deviation is %f \n",sum,avg,sd);
  return 0;
}
void opr(int *n1, int *n2,int *n3, int *n4, int *n5, int *s, float *a, float *sd){
    *s= *n1 + *n2 + *n3 + *n4 + *n5;
    *a = (float)*s/5;
    int t,sum=0,i;
      t=pow((*n1 - *a),2);
      sum+=t;
      t=pow((*n2 - *a),2);
      sum+=t;
      t=pow((*n3 - *a),2);
      sum+=t;
      t=pow((*n4 - *a),2);
      sum+=t;
      t=pow((*n5 - *a),2);
      sum+=t;
    sum/=5;
    *sd = sqrt(sum);
}
