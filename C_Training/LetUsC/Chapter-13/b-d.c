/*
Program to display number of positive,negative,even,odd numbers
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    29/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int ar[25],i,pos=0,neg=0,even=0,odd=0;
  puts("Enter 25 numbers");
  for(i=0;i<25;i++){
    scanf("%d",&ar[i]);
  }
  for(i=0;i<25;i++){
    if(ar[i]>0){
      pos++;
    }else{
      neg++;
    }
    if(ar[i]%2==0){
      even++;
    }else{
      odd++;
    }
  }
  printf("No of +ve are %d, -ve are %d , even are %d , odd are %d",pos,neg,even,odd);
  return 0;
}
