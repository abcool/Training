/*
Program to create structure parts and retrieve info on parts with serial no b/w BB1 and CC6
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    16/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<string.h>
struct part{
  char serial[4],material[10];
  int yom,qty;
};
void retrieve(struct part *, char *, char *);
int main(){
  struct part p[6]={
    {"BB0","fiber",2013,5},
    {"BB1","metal",2014,3},
    {"BC5","liquid",2010,6},
    {"CA2","glass",2018,2},
    {"CZ3","alloy",2017,11},
    {"CC6","mix",2019,26}
  };
  retrieve(p,"BB1","CC6");
  return 0;
}
void retrieve(struct part *p, char *s, char *e){
  int i;
  for(i=0;i<6;i++){
    if(strcmp(((p+i)->serial),s)>=0 && strcmp(((p+i)->serial),e)<=0){
      printf("Serial No: %s\n",p[i].serial);
      printf("Material: %s\n",p[i].material);
      printf("Manufacturing Year :%d\n",p[i].yom);
      printf("Stock Available: %d\n",p[i].qty);
    }
  }
}
