#include<stdio.h>
int main(){
  int num,sum=0,ans,pow=10000;
  printf("Enter a NUmber: ");
  scanf("%d",&num);
  while(num>0){
    ans=num%10;
    sum+=ans*pow;
    num/=10;
    pow/=10;
  }
  printf("Reversed Number: %d\n",sum);
  return 0;
}
