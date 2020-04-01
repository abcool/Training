/*
Program to check arr[0] = arr[n-1], arr[1] = arr[n-2] and so on
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    29/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<malloc.h>
#include<stdio.h>
int main(){
  int * arr,size,i,j;
  puts("enter no of elements:");
  scanf("%d",&size);
  arr=(int *)malloc(size * sizeof(int));
  puts("Enter elements");
  for(i=0;i<size;i++){
    scanf("%d",&arr[i]);
  }
  for(i=0,j=size-1;i<j;i++,j--){
    if(*(arr + i)==*(arr + j)){
      printf("\n%d th and %d th elements are equal\n",i+1,j+1);
    }
  }
  return 0;
}
