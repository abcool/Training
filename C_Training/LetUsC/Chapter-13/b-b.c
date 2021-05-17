/*
Program that copies the contents of one array into another in reverse order
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    29/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int a[5],b[5]={9,7,3,1,8};
  int i,j;
  puts("First array:");
  for(i=0;i<5;i++){
    printf("%d",b[i]);
  }
  for(i=0,j=4;j>=0;i++,j--){
    a[i]=b[j];
  }
  puts("\nsecond array:");
  for(i=0;i<5;i++){
    printf("%d",a[i]);
  }
  return 0;
}
