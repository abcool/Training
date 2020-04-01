/*
Program to shift elements of an array by two positions. Left shift elements in rows by 2 positions
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    16/04/2019  Arvind Bakshi    Initial Version
1.1    17/04/2019  Komal Soni       Fixed lShift boundary condition
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void lShift(int (*)[5],int , int);
int main(){
  int org[4][5],i,j;
  puts("Enter elements:");
  for(i=0;i<4;i++){
    for(j=0;j<5;j++){
      scanf("%d",&org[i][j]);
    }
  }
  lShift(org,4,5);
  puts("\n After shifting");
  for(i=0;i<4;i++){
    for(j=0;j<5;j++){
      printf("%d ",org[i][j]);
    }
    printf("\n");
  }
  return 0;
}
void lShift(int (*p)[5], int r, int c){
  int i,j,temp;
  for(i=0;i<r;i++){
    for(j=0;j<c;j++){
      if(j+2 < c)
      {
        temp = *(*(p+i)+j);
        *(*(p+i)+j)=*(*(p+i)+j+2);
        *(*(p+i)+j+2) = temp;
      }
      if(j+2 == c)
      {
        temp = *(*(p+i)+j);
        *(*(p+i)+j)=*(*(p+i)+j+1);
        *(*(p+i)+j+1)=temp;
      }
    }
  }
}
