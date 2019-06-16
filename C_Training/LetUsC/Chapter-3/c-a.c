/*Program to Find Profit or Loss
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  float cp,sp;
  puts("Enter Cost Price & Selling Price:");
  scanf("%f %f",&cp,&sp);
  if(sp-cp>0){
    printf("Profit is %0.2f\n",sp-cp);
  }else if(sp-cp<0){
    printf("Loss is %0.2f\n",cp-sp);
  }else{
    puts("No Profit or Loss\n");
  }
  return 1;
}
