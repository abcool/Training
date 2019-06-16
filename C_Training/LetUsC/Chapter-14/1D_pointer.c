/* 1-D pointer array in c */
#include<stdbool.h>
#include<stdio.h>
void incr(int *, int);
bool main(){
int a[5]={2,7,9,3,1},i;
puts("Original Array");
for(i=0;i<5;i++){
  printf("%d",a[i]);
}
incr(a,5);
puts("\nNew array after increment:");
for(i=0;i<5;i++){
  printf("%d",a[i]);
}
return 1;
}
void incr(int *p, int r){
  int i;
  for(i=0;i<5;i++){
    *(p+i) = *(p+i)+1;
  }
}
