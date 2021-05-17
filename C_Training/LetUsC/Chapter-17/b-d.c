/*
Program to arrange records of cricketers in ascending order by runs
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    25/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
struct cricketer{
  int age,matches;
  float avg_runs;
  char name[20];
}c[20];
void initialize(struct cricketer *,int);
void sort(struct cricketer *, int);
int main(){
  int i;
  initialize(c,20);
  puts("Initial Order:");
  for(i=0;i<20;i++){
    printf("Name: %s",c[i].name);
    printf("\n Age: %d",c[i].age);
    printf("\n Matches: %d",c[i].matches);
    printf("\n Average Runs: %f",c[i].avg_runs);
    printf("\n Name: %s\n",c[i].name);
  }
  sort(c,20);
  puts("After sorting");
  for(i=0;i<20;i++){
    printf("Name: %s",c[i].name);
    printf("\n Age: %d",c[i].age);
    printf("\n Matches: %d",c[i].matches);
    printf("\n Average Runs: %f",c[i].avg_runs);
    printf("\n Name: %s\n",c[i].name);
  }
  return 0;
}
void initialize(struct cricketer *c, int n){
  int i;
  for(i=0;i<n;i++){
    puts("Enter Name:");
    scanf(" %[^\n]s",c[i].name);
    puts("Enter Age:");
    scanf("%d",&c[i].age);
    puts("Enter matches played");
    scanf("%d",&c[i].matches);
    puts("Enter average runs scored");
    scanf("%f",&c[i].avg_runs);
  }
}
void sort(struct cricketer *c, int n){
  int i,j;
  struct cricketer t;
  for(i=0;i<n;i++){
    for(j=i+1;j<n;j++){
      if(c[j].avg_runs < c[i].avg_runs){
        t=c[i];
        c[i]=c[j];
        c[j]=t;
      }
    }
  }
}
