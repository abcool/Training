/*
Recursive Function to print prime factors of a number
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    21/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void prime(int);
int main(){
  int in;
  puts("Enter a number: ");
  scanf("%d",&in);
  prime(in);
  return 0;
}
void prime(int n){
  static int div=2;
  if(div<=n){
    if(n%div==0){
      printf("%d,",div);
      n=n/div;
    }else{
      div++;
    }
    prime(n);
  }else{
    puts("1");
  }
}
