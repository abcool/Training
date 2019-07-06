/*
Program that prints histogram of length of words in its input.
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    06/07/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#define OUT 0
#define IN 1
int main(){
  int c,len[5],state=OUT,i=0,l=0;
  puts("Enter a sentence of 5 words");
  while((c=getchar())!=EOF){
    if(c==' '|| c=='\t' || c=='\n'){
      if(state==IN){
          len[i]=l;
          i++;
          l=0;
          //printf("\n");
          state=OUT;
      }
    }else if(state==OUT){
      //putchar(c);
      l++;
      state=IN;
    }else{
      //putchar(c);
      l++;
    }
  }
//  puts("Lengths of words:");
//  for(i=0;i<5;i++){
//    printf("Len of %d word is %d\n",i+1,len[i]);
//  }
  puts("Horizontal historgam");
  for(i=0;i<5;i++){
    int j;
    j=len[i];
    printf("|");
    while(j>0){
      printf("-");
      j--;
    }
    printf("\n");
  }
  puts("Vertical Histogram");
  for(i=0;i<5;i++){
    int j;
    j=len[i];
    //printf("|");
    while(j>0){
      printf("|\n");
      j--;
    }
    printf("_");
    printf("\t");
  }
return 0;
}
