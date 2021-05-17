/*
Program that prints one word per line
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    05/07/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define OUT 0
#define IN 1
int main(){
  int c,state=OUT;
  while((c=getchar())!=EOF){
    if(c==' '|| c=='\n' || c=='\t'){
      if(state==IN){
        printf("\n");
        state=OUT;
      }
    }else if(state==OUT){
      putchar(c);
      state=IN;
    }else{
      putchar(c);
    }
  }
  return 0;
}
