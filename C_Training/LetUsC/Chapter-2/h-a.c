#include<stdio.h>
int main(){
  int num,sum=0,ans;
  printf("Enter a Number: ");
  scanf("%d",&num);
  while(num>0){
    ans=num%10;
    sum=sum+ans;
    num=num/10;
  }
  printf(" Sum of Digits: %d\n",sum);
  return 0;
}
