/*
Program for checking correct ISBN
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    23/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int checkISBN(char *);
int main(){
  char no[11];
  puts("Enter ISBN number");
  scanf("%s",no);
  if(checkISBN(no)){
    puts("Valid ISBN");
  }else{
    puts("Invalid ISBN");
  }
  return 0;
}
int checkISBN(char *c){
  int i,sum=0,j;
  // Convert x to 10
  if(*(c+9)=='X' || *(c+9)=='x'){ // d_1 = *(c+9) from right
    *(c+9)=10;
  }
  // Calculate 2d_2 + 3d_3 +............................10d_10 from right to left
  for(i=8,j=2;i>=0;i--,j++){
      if(*(c+i)>=48 && *(c+i)<=57){
        sum=sum+(j*(*(c+i)-48));
      }else if(*(c+i)=='X' || *(c+i)=='x'){
        sum=sum+(j*10);
      }
    }
  // Finding that i or d_1 which when added to sum makes final sum multiple of 11
    for(i=0;i<=9;i++){
      if((sum+i)%11==0){
        break;
      }
    }
    if(i==(*(c+9)-48)){
      return 1;
    }else{
      return 0;
    }
}
