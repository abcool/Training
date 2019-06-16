/*
Program for matchstick game
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    28/02/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int matchstick=21,user;
  while(matchstick>1){
    printf("\nPick 1 or 2 or 3 or 4 matchstick: ");
    scanf("%d",&user);
    if(user>4||user<1){
      printf("\nPlease enter correct matchstick: ");
      scanf("%d",&user);
    }
    matchstick=matchstick-user;
    printf("\nNo of matchsticks left: %d",matchstick);
    printf("\nComputer picked %d matchsticks",5-user);
    matchstick=matchstick-(5-user);
  }
  printf("\nNo of matchsticks left:%d",matchstick);
  printf("\nSorry! You Lost\n");
  return 1;
}
