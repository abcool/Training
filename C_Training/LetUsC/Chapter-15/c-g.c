/*
Program for checking valid credit card number
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    23/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int validCC(char *);
int main(){
  char cc[17];
  puts("Enter a credit card number");
  scanf("%s",cc);
  if(validCC(cc)){
    puts("Valid credit card number");
  }else{
    puts("Invalid Credit card number");
  }
  return 0;
}
int validCC(char *s){
  int i,sum_even=0,sum_odd=0;
  for(i=15;i>=0;i--){
    int temp;
    temp=*(s+i)-48;
    if(i%2==0){
      temp=2*temp;
      if(temp>=10){
        temp=temp-9;
      }
      sum_even+=temp;
    }else{
      sum_odd+=temp;
    }
  }
  if((sum_odd+sum_even)%10==0){
    return 1;
  }else{
    return 0;
  }
}
