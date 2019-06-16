/*
Program to find range of a set of numbers
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    01/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int ans=1,n,small,large,flag=0;
  while(ans){
    puts("Enter a Number.");
    scanf("%d",&n);
    if(flag==0){
    small=large=n;
    flag=1;
  }
    if(n>large){
      large=n;
    }
    if(n<small){
      small=n;
    }
    puts("Do you want to continue? Press 1. for Yes or 0. for No.");
    scanf("%d",&ans);
  }
  printf("\nRange is %d\n",large-small);
  return 1;
}
