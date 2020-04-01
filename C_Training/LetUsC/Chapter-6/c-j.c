/*
Program to print Ramanujam numbers....
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    04/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int i,j,k,l,f=1,rn;
  for(i=1;i<=40;i++){
    for(j=1;j<=40;j++){
      for(k=1;k<=40;k++){
        for(l=1;l<=40;l++){
          if(i!=j && i!=k && i!=l && j!=k && j!=l && k!=l){
            if(i*i*i+j*j*j==k*k*k+l*l*l){
              if(rn==i*i*i+j*j*j){
                continue;
              }else{
              rn=i*i*i+j*j*j;
              printf("%d Ramanujam number is %d\n",f,rn);
              f++;
            }
            }
          }
        }
      }
    }
  }
  return 0;
}
