#include<stdio.h>
_Bool main(){
  int n1,n2,temp;
  printf("Enter 2 no's: ");
  scanf("%d %d",&n1,&n2);
  temp=n1;
  n1=n2;
  n2=temp;
  printf("Now no's are: %d %d\n",n1,n2);
  return 1;
}
