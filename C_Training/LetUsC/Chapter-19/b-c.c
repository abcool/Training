/*
Program to read records from file and display them in sorted order by name
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    01/07/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<malloc.h>
struct student{
  char name[80];
  int age;
}*s=NULL;
void add(struct student *, int);
int main(){
  FILE *fp;
  int r,i=0;
  puts("Enter number of records to write");
  scanf("%d",&r);
  //struct student *s=NULL;
  add(s,r);
  fp = fopen("EMP.dat","wb");
  while(i<r){
    fwrite(&s[i],sizeof(s[i]),1,fp);
    i++;
  }
  free(s);
  fclose(fp);
  /*fp = fopen("EMP.dat","rb");
  i=0;
  FILE *fp2 = fp;
  while(fread())*/
  return 0;
}
void add(struct student *t, int n){
  t= (struct student *)malloc(n* sizeof(struct student));
  int i=0;
  while(i<n){
    printf("Enter student %d details\n",i+1);
    puts("Enter student's name");
    scanf("%[^\n]s",(t+i)->name);
    puts("Enter student's age");
    scanf("%d",&(t+i)->age);
    i++;
  }
}
