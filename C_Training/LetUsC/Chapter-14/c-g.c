/*
Program to find if a square matrix is symmetric
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    14/04/2019  Arvind Bakshi    Initial Version
1.2    15/04/2019  Arvind Bakshi    Fixed syntax errors
1.3    16/04/2019  Komal Soni       Fixed function symmetric
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdbool.h>
#include<stdio.h>
void transpose(int (*)[4], int, int);
int symmetric(int [][4], int [][4], int,int);
bool main(){
  int org[4][4],trans[4][4],i,j;
  puts("Enter matrix elements");
  for(i=0;i<4;i++){
    for(j=0;j<4;j++){
      scanf("%d",&org[i][j]);
      trans[i][j]=org[i][j];
    }
  }
  transpose(trans,4,4);
  if(symmetric(org,trans, 4,4)){
    puts("Symmetric matrix");
  }else{
    puts("Non-symmetric matrix");
  }
  return 1;
}
void transpose(int (*sy)[4],int row,int col){
  int i,j,temp;
  int k=0;
  while(k<row-1){
    for(j=k+1;j<col;j++){
      temp= *(*(sy+k)+j);
      *(*(sy+k)+j)=*(*(sy+j)+k);
      *(*(sy+j)+k)=temp;
    }
    k++;
  }
}
int symmetric(int or[][4], int ts[][4], int row, int col){
  int i,j;
  for(i=0;i<row;i++){
    for(j=0;j<col;j++){
      if(or[i][j]!=ts[i][j]){
        return 0;
      }
    }
  }
  return 1;
}
