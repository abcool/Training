/*
Program to implement 3D array and print first and last element
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    14/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#define FALSE 0
#define TRUE 1
#include<stdbool.h>
#include<stdio.h>
bool main(){
  int thread[3][2][3]={
    {
    1,2,4,
    3,5,1
    },
    {
    7,9,5,
    2,1,8
    },
    {
    0,1,7,
    6,3,11
    }
  };
  int first = thread[0][0][0],last=thread[2][1][2];
  printf("First element is: %d \n and last element is: %d \n",first,last);
  return TRUE;
}
