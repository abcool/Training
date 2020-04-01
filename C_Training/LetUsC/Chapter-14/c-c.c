/*
Program to obtain transpose of 4x4 matrix
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    14/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#define TRUE 1
#define FALSE 0
#include<stdbool.h>
#include<stdio.h>
bool main(){
  int ar[4][4],i,j,temp;
  puts("Enter array elements");
  for(i=0;i<4;i++){
    for(j=0;j<4;j++){
      scanf("%d",&ar[i][j]);
    }
  }
  int k=0;
  while(k<3){
    for(j=k+1;j<4;j++){
      temp=ar[k][j];
      ar[k][j]=ar[j][k];
      ar[j][k]=temp;
    }
    k++;
  }
  puts("Transpose is:");
  for(i=0;i<4;i++){
    for(j=0;j<4;j++){
      printf("%5d",ar[i][j]);
    }
    printf("\n");
  }
  return 0;
}
