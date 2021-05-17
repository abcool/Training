/*
Function to convert year into roman equivalent
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    11/03/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
void roman(int);
int main(){
  int year;
  puts("Enter the year: ");
  scanf("%d",&year);
  roman(year);
  return 0;
}
void roman(int y){
  int out,org=y;
  out=y/1000;
  y=y%1000;
  while(out>=1){
    printf("m");
    out--;
  }
  out=y/100;
  y=y%100;
  if(out==5){
    printf("d");
  }else if(out>5){
    printf("d");
    while(out>5){
      printf("c");
      out--;
    }
  }else if(out<5){
    while(out>0){
    printf("c");
    out--;
    }
  }
    out=y/10;
    y=y%10;
    if(out==5){
      printf("l");
    }else if(out>5){
      printf("l");
      while(out>5){
        printf("x");
        out--;
      }
    }else if(out<5){
      while(out>0){
      printf("x");
      out--;
      }
    }
    out=y;
    if(out==5){
      printf("v");
    }else if(out>5){
      printf("v");
      while(out>5){
        printf("i");
        out--;
      }
    }else if(out<5){
      while(out>0){
        printf("i");
        out--;
      }
    }
}
