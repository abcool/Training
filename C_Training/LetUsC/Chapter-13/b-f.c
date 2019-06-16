/*
Program to find smallest number in an array of integers
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    29/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int ar[5],i,*j,small;
  puts("Enter elements");
  for(i=0;i<5;i++){
    scanf("%d",&ar[i]);
  }
  j=&ar[0];
  small = ar[0];
  i=0;
  while(i<5){
    if(*j<small){
      small = *j;
    }
    j++;
    i++;
  }
  printf("Smallest = %d\n",small);
  return 0;
}
