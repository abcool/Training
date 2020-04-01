/*
Program to implement insertion sort
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    30/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void sort(short *,short);
int main(){
  short arr[25],i;
  puts("Enter 25 elements");
  for(i=0;i<25;i++){
    scanf("%d",&arr[i]);
  if(i>0){
    sort(&arr[0],i);
  }
}
puts("Sorted inserted array");
for(i=0;i<25;i++){
  printf("%d",arr[i]);
}
return 0;
}
void sort(short *n, short j){
  int l,temp;
  for(l=0;l<j;j--){
    if(*(n+j)< *(n+l)){
      temp = *(n+j);
      *(n+j) = *(n+l);
      *(n+l) = temp;
    }
  }
}
