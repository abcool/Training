/*
Program that interchanges odd and even elements of an array
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    29/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int ar[]={5,4,7,9,1};
  int i,temp;
  for(i=0;i<5;i++){
    printf("%d ,",ar[i]);
  }
  for(i=0;i<5;i=i+2){
    temp=ar[i];
    ar[i]=ar[i+1];
    ar[i+1]=temp;
  }
  puts("After Interchange\n");
  for(i=0;i<5;i++){
    printf("%d ,",ar[i]);
  }
  return 0;
}
