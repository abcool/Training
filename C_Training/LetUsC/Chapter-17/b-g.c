/*
Program to compare dates. If equal return 1 else return 0
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    30/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<string.h>
struct date{
  int day,month,year;
};
int parseInt(char *);
int main(){
  struct date d[2];
  int j;
  for(j=0;j<2;j++){
    char *s,*token;
    puts("Enter a date(dd-mm-yyyy)");
    scanf(" %m[^\n]",&s);
    token = strtok(s,"-");
    int i=0,temp[3];
    while(token!=NULL){
      int tmp=parseInt(token);
      temp[i]=tmp;
      i++;
      token = strtok(NULL,"-");
    }
    d[j].day=temp[0];
    d[j].month=temp[1];
    d[j].year=temp[2];
  }
  if(d[0].year==d[1].year && d[0].month == d[1].month && d[0].day == d[1].day){
    puts("Equal dates entered");
    return 1;
  }else{
    puts("Unequal dates entered");
    return 0;
  }
}
int parseInt(char *c){
  int i,sum=0;
  for(i=0;i<strlen(c);i++){
    if(*(c+i)<48 || *(c+i)>57){
      puts("Invalid date entered");
    }else{
      sum=sum+ (*(c+i)-48);
    }
  }
  return sum;
}
