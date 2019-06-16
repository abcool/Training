/*
Function to evaluate Sin(x) upto 10 terms
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    17/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<math.h>
void sine(int *, double *);
int fact(int);
int main(){
  int n;
  double out;
  puts("Enter a number: ");
  scanf("%d",&n);
  sine(&n,&out);
  printf("Sin of %d is %lf\n",n,out);
  return 0;
}
void sine(int *a,double *b){
  double t,sum=0;
  int i,j;
  for(i=1,j=1;i<=10;i++,j+=2){
    t=pow(*a,j)/(fact(j)*0.1);
    if(i%2==0){
      sum-=t;
    }else{
      sum+=t;
    }
  }
  /* t=pow(*a,3)/(fact(3)*0.1);
  sum = *a-t;
  t=pow(*a,5)/(fact(5)*0.1);
  sum +=t;
  t=pow(*a,7)/(fact(7)*0.1);
  sum -=t;
  t=pow(*a,9)/(fact(9)*0.1);
  sum +=t;
  t=pow(*a,11)/(fact(11)*0.1);
  sum -=t;
  t=pow(*a,13)/(fact(13)*0.1);
  sum +=t;
  t=pow(*a,15)/(fact(15)*0.1);
  sum -=t;
  t=pow(*a,17)/(fact(17)*0.1);
  sum +=t;
  t=pow(*a,19)/(fact(19)*0.1);
  sum -=t;
  t=pow(*a,21)/(fact(21)*0.1);
  sum +=t;*/
  *b=sum;
}
int fact(int n){
  int f=1;
  while(n>1){
    f*=n;
    n--;
  }
  return f;
}
