/*
Program that prints frequency of different characters in its input.
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/07/2019  Arvind Bakshi    Initial Version
1.1    18/07/2018  Arvind Bakshi    Optimized Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<ctype.h>
#define MAXCHAR 128
int main(){
  int freq[MAXCHAR],c,i;
  for(i=0;i<MAXCHAR;i++){
    freq[i]=0;
  }
  puts("Enter some characters");
  while((c=getchar())!=EOF){
  if(c<MAXCHAR)
        ++freq[c];
}
int j;
printf("Character | Frequency\n");
for(i=1;i<MAXCHAR;i++){
  if(freq[i]>0){
        printf("%9c | ",i);
        for(j=0;j<freq[i];j++){
          putchar('-');
        }
        putchar('\n');
  }
}
  return 0;
}
