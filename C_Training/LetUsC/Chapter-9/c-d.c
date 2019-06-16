/*
Function to circularly shift values to the right
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void shift(int *, int *, int *);
int main(){
  int x,y,z;
  puts("Enter three numbers: ");
  scanf("%d %d %d", &x,&y,&z);
  shift(&x,&y,&z);
  printf("After Shifting \n %d \n %d \n %d\n",x,y,z);
  return 0;
}
void shift(int *a, int *b, int *c){
  int temp;
  temp=*b;
  *b=*a;
  *a=temp;
  temp=*c;
  *c=*a;
  *a=temp;
}
