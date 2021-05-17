/*
Program to pick largest number from 5x5 matrix
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    14/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdbool.h>
#include<stdio.h>
bool main(){
  int ar[5][5]={
    1,2,3,4,5,
    6,7,8,9,10,
    87,11,12,13,14,
    66,16,15,17,18,
    22,21,19,20,23
  };
  int i,j,largest = ar[0][0];
  for(i=0;i<5;i++){
    for(j=0;j<5;j++){
      if(ar[i][j]>largest){
        largest=ar[i][j];
      }
    }
  }
  printf("Largest=%d\n",largest);
  return 1;
}
