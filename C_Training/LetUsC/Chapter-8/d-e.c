/*
Function to print prime factors of a number
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    11/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void prime(int);
int main(){
  int number;
  puts("Enter a number: ");
  scanf("%d",&number);
  prime(number);
  return 0;
}
void prime(int n){
  int div=2;
  while(n>1){
    if(n%div==0){
      printf("%d,",div);
      n/=div;
    }else{
      div++;
    }
  }
  printf("1.\n");
}
