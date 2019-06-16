/*
Program to display number of times a number appears in an array
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    29/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int ar[25],i,count=0,j;
  puts("Enter elements:");
  for(i=0;i<25;i++){
    scanf("%d",&ar[i]);
  }
  puts("Enter number to search:");
  scanf("%d",&i);
  for(j=0;j<25;j++){
    if(ar[j]==i){
      count++;
    }
  }
  if(count>0){
    printf("%d appears %d times",i,count);
  }
  return 0;
}
