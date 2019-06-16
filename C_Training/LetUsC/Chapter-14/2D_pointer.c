/* passing 2d array using pointers */
#include<stdio.h>
void addElement(int (*)[4], int , int);
int main(){
int arr[4][4]={
1,2,3,4,
5,6,7,8,
9,10,11,12,
13,14,15,16
}, i,j;
addElement(arr,4,4);
puts("After adding 1 to each element new matrix:");
for(i=0;i<4;i++){
for(j=0;j<4;j++){
printf("%d",arr[i][j]);
}
printf("\n");
}
return 1;
}
void addElement(int (*a)[4], int row, int col){
  int i,j;
  for(i=0;i<row;i++){
    for(j=0;j<col;j++){
      *(*(a+i)+j)= *(*(a+i)+j)+1;
    }
  }
}
