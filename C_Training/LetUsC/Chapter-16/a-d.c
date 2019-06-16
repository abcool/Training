/*
Program to reverse string stored in array of pointers to string
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void reverse(char *);
int main(){
  char *s[]={
    "abc",
    "lmn",
    "pqr",
    "vxs"
  };
  int i;
  puts("Orignal :");
  for(i=0;i<4;i++){
    printf("%s\n",s[i]);
  }
  for(i=0;i<4;i++){
    reverse(s[i]); // eg. reverse abc to cba
  }
  puts("Reversed :");
  for(i=0;i<4;i++){
    printf("%s\n",s[i]);
  }
  return 0;
}
void reverse(char *s){
  char *t,temp;
  int len,i,j;
  len=0;
  while(*(s+len)!='\0'){
    len++;
  }
  printf("%d\n",len);
  t=s;
  for(i=0,j=len-1;i<=(len-1)/2;i++,j--){  // error in this loop.
     temp=*(s+i);
     *(s+i)=*(t+j);
     *(t+j)=temp;
  }
}
