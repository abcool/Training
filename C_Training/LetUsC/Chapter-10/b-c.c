/*
Recursive Function to print fibonacci series upto 25 numbers
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    21/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void fibb(int,int);
int main(){
  int x1=1;
  puts("Fibonacci series is: ");
  printf("1\n");
  fibb(x1,x1);
  return 0;
}
void fibb(int x,int y){
  static int counter=1;
  if(counter<25){
    printf("%d\n",y);
    counter++;
    fibb(y,x+y);
  }
}
