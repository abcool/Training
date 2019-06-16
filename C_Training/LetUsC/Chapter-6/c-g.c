/*
Program to print sum of first seven terms of natural logarithm of a number
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    04/03/2019  Arvind Bakshi    Initial Version
1.1    04/03/2019  Arvind Bakshi    Replaced value 1 by 1.0 and p by i
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<math.h>
#include<stdio.h>
int main(){
  int x,i;
  float ans,sum=0;
  printf("Enter a number: ");
  scanf("%d",&x);
  for(i=1;i<=7;i++){
    if(i==1){
      ans=(x-1.0)/x;
    }else{
      ans=pow((x-1.0)/x,i)/2;
    }
    sum+=ans;
  }
  printf("Natural Log of %d is %f: \n",x,sum);
  return 0;
}
