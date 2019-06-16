/*
Program to add 2 6x6 matrices
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    16/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int n1[6][6],n2[6][6],i,j;
  puts("Enter first matrix elements:");
  for(i=0;i<6;i++){
    for(j=0;j<6;j++){
      scanf("%d",&n1[i][j]);
    }
  }
  puts("\nEnter second matrix elements:");
  for(i=0;i<6;i++){
    for(j=0;j<6;j++){
      scanf("%d",&n2[i][j]);
    }
  }
  puts("\nAdded matrix:");
  for(i=0;i<6;i++){
    for(j=0;j<6;j++){
      printf("%3d",n1[i][j]+n2[i][j]);
    }
    printf("\n");
  }
  return 0;
}
