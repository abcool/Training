/*
Program to print names of employees whose tenure is greater than 3 years
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    25/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<time.h>
#include<string.h>
#include<malloc.h>
#include<stdlib.h>
struct date{
  int year,month,day;
};
struct employee{
  int empcode;
  char name[26];
  struct date doj;
};
int toInt(char *);
void initialize(struct employee *, int);
void display(struct employee *, int, struct date);
int main(){
  int n;
  puts("Enter number of employees:");
  scanf("%d",&n);
  struct employee *e = (struct employee *)malloc(n* sizeof(struct employee));
  initialize(e,n);
  time_t curr = time(NULL);
  struct tm local = *localtime(&curr);
  struct date d;
  d.year= local.tm_year+1900;
  d.month= local.tm_mon+1;
  d.day = local.tm_mday;
/*  printf("\n Year: %d Year + 1900: %d\n",local.tm_year, local.tm_year+1900);
  printf("\n Month: %d Month+1: %d\n",local.tm_mon, local.tm_mon+1);
  printf("\n Day: %d\n",local.tm_mday); */
  display(e,n,d);
  free(e);
  return 0;
}
void initialize(struct employee *e, int n){
  int i;
  char *tempdate="",*token;
  int temp[3],j;
  for(i=0;i<n;i++){
    puts("\n Enter employee name:");
    scanf(" %[^\n]s",e[i].name);
    puts("\n Enter employee code");
    scanf("%d",&e[i].empcode);
    puts("\n Enter date of joining (dd-mm-yyyy)");
    scanf(" %m[^\n]",&tempdate);
    //copy = (char *)malloc(strlen(date)*sizeof(char));
    //strcpy(copy,date);
    token = strtok(tempdate,"-");
    j=0;
    while(token != NULL){
     //printf("Token %s",token);
      int tmp =toInt(token);
      //printf("Tmp: %d",tmp);
      if(tmp==-1){
        exit(0);
      }else{
      temp[j] = tmp;
      j++;
      }
      token = strtok(NULL, "-");
    }
    e[i].doj.day=temp[0];
    e[i].doj.month=temp[1];
    e[i].doj.year=temp[2];
  }
}
void display(struct employee *e, int n, struct date d){ // Logic not working
  int i;
  for(i=0;i<n;i++){
    if((d.year-e[i].doj.year)>3){ // checking year
      printf("\n Name: %s",e[i].name);
    }
    if((d.year-e[i].doj.year)==3){
      if((d.month-e[i].doj.month)>0){ // checking month
        printf("\n Name: %s",e[i].name);
      }else{
          if((d.month-e[i].doj.month)==0 && (d.day-e[i].doj.day)>=0){ // checking date
            printf("\n Name: %s",e[i].name);
          }
      }
    }
  }
}
int toInt(char *s){
  int i=0,sum=0;
  while(i<strlen(s)){
    if(*(s+i)<48 || *(s+i)>57){
      puts("\n Invalid date entered\n");
      sum = -1;
      break;
    }else{
      sum=10*sum+ (*(s+i)-48);
      i++;
    }
  }
  return sum;
}
