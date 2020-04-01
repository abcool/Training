/*
Program to read a file and display it's contents along with line numbers before each line
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    01/07/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<stdlib.h>
int main(){
  FILE *fp;
  char ch;
  int l_no=0;
  fp=fopen("demo.txt","r");
  if(fp==NULL){
    puts("Empty File");
    exit(1);
  }
  while(1){
    l_no++;
    ch=fgetc(fp);
    if(ch==EOF){
      break;
    }else{
      printf("%d \t",l_no);
      while(ch!='\n'){
        printf("%c",ch);
        ch=fgetc(fp);
      }
      printf("\n");
    }
  }
  fclose(fp);
  return 0;
}
