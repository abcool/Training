/*
Program to print population at the end of each year in the last decade
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    04/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int counter=1,population=100000,increase;
  while(counter<=10){
    increase = (population*10.0)/100.0;
    population+=increase;
    printf("New population for %d year is %d\n",counter,population);
    counter++;
  }
  return 0;
}
