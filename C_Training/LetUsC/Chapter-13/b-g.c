/*
Program to find smallest number in an array of integers
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    30/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void modify(int *,int);
void main(){
  int arr[10],i;
  puts("Enter 10 elements:");
  for(i=0;i<10;i++){
    scanf("%d",&arr[i]);
  }
  modify(arr,10);
  puts("New array is:");
  for(i=0;i<10;i++){
    printf("%d\n",arr[i]);
  }
}
void modify(int *n,int s){
  int j;
  for(j=0;j<s;j++){
    *(n+j)= *(n+j) * 3;
  }
}
