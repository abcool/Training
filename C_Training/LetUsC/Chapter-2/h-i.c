#include<stdio.h>
int main(){
  int amount,n=0;
  printf("Enter amount:");
  scanf("%d",&amount);
  while(amount>0){
    int clc;
    if(amount>=100){
      clc=amount/100;
      n+=clc;
      clc=0;
      amount%=100;
    }else if(amount>=50 && amount<100){
      clc=amount/50;
      n+=clc;
      clc=0;
      amount%=50;
    }else if(amount>=10 && amount<50){
      clc=amount/10;
      n+=clc;
      clc=0;
      amount%=10;
    }else if(amount>=5 && amount<10){
      clc=amount/5;
      n+=clc;
      clc=0;
      amount%=5;
    }else if(amount>=2 && amount<5){
      clc=amount/2;
      n+=clc;
      clc=0;
      amount%=2;
    }else if(amount>=1 && amount<2){
      clc=amount/1;
      n+=clc;
      clc=0;
      amount%=1;
    }
  }
printf("Total notes: %d\n",n);  
}
