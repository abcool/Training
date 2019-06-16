/*
Program to print prime numbers from 1 to 300
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    03/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int i,j;
  printf("%d\n",1);
  for(j=1;j<=300;j++){
    i=2;
    while(i<j){
      if(j%i==0){
        break;
      }else{
        i++;
      }
    }
   if(i==j)
    printf("%d\n",j);
  }
  return 0;
}
