/*
Recursive Function to obtain sum of first 25 natural numbers
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    21/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  static int n=1,sum=0;
  if(n>25){
    printf("Sum of first 25 natural numbers is %d\n",sum);
    return 0;
  }else{
    sum+=n;
    n++;
    main();
  }
}
