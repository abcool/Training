/*
Program to print all Pythagorean triplets with sides less than 30
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    04/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int i,j,k,l=1;
  for(i=1;i<=30;i++){
    for(j=1;j<=30;j++){
      for(k=1;k<=30;k++){
        if(i*i+j*j==k*k){
          printf("%d Pythagorean triplets are: %d %d %d.\n",l,i,j,k);
          l++;
        }
      }
    }
  }
return 0;
}
