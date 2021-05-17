/*
Program to find grace marks of a student
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    10/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  int class,sub_failed,grace=0;
  puts("Enter class obtained. \n1. for First class. \n 2. for Second Class. \n3. for Third Class.\n");
  scanf("%d",&class);
  puts("Enter the number of subjects in which you failed: ");
  scanf("%d",&sub_failed);
  switch(class){
    case 1:
          switch(sub_failed){
            case 1:
                  grace+=5;
                  break;
            case 2:
                  grace+=10;
                  break;
            case 3:
                  grace+=15;
                  break;
          }
          break;
    case 2:
          switch(sub_failed){
            case 1:
                  grace+=4;
                  break;
            case 2:
                  grace+=8;
                  break;
          }
          break;
    case 3:
          switch(sub_failed){
            case 1:
                  grace+=5;
                  break;
          }
          break;
  }
  printf("\n Total grace marks obtained: %d\n",grace);
  return 0;
}
