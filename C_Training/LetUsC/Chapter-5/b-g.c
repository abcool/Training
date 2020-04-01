/*
Program to count the number of positives,negatives and zeros entered
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    28/02/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
int ans=1;
int number,positive=0,negative=0,zeros=0;
while(ans){
  printf("\nEnter a Number: ");
  scanf("%d",&number);
  if(number>0){
    positive++;
  }else if(number<0){
    negative++;
  }else{
    zeros++;
  }
  printf("\nDo you want to Continue....Enter 1 -> yes or 0 -> No:");
  scanf("%d",&ans);
}
printf("No of positives= %d \n No of negatives= %d \n No of zeros= %d\n",positive,negative,zeros);
return 0;
}
