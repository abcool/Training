/*
Program to print pattern
           1
        2     3
    4      5      6
 7      8     9      10
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    05/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int i,j,k,l,sp;
  sp=6;
  for(i=1,k=1;i<5;i++){ //Loop for new lines
    for(l=1;l<=sp;l++) //Loop for left spaces
      printf(" ");
    sp-=2;
    for(j=1;j<=i;j++,k++) //Loop for printing numbers
      printf(" %d ",k);
    printf("\n");
  }
  return 1;
}
