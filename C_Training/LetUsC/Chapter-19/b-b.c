/*
Program to append contents of one file at the end of another
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
  FILE *fp1,*fp2;
  char ch;
  fp1=fopen("demo.txt","r");//Source file
  fp2=fopen("Demo2.txt","a");//Destination file
  if(fp1==NULL){
    puts("Input file empty");
    exit(1);
  }
  while(1){
    ch=fgetc(fp1);
    if(ch==EOF){
      break;
    }else{
      fputc(ch,fp2);
    }
  }
  fclose(fp1);
  fclose(fp2);
  return 0;
}
