/*
Program to create structure student and print names using year and all details of particular one using roll no.
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    08/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<malloc.h>
#include<stdio.h>
#include<string.h>
struct student{
    int rollNo,yoj;
    char name[20],
        department[10],
        course[10];
};
void yearDisplay(struct student *,int);
void rollDisplay(struct student [],int,int);
int main(){
	int n,flag=1,choice,year,roll,i;
  char name[20],dn[10],cn[10];
	puts("Enter number of students");
	scanf("%d",&n);
  struct student * s = (struct student *)malloc(n *sizeof(struct student));
	//struct student s[n];
	puts("Enter details of students");
	for(i=0;i<n;i++){
	    puts("Enter Name:");
      scanf(" %[^\n]s",name); // error in this line instead of %[^\n]s %s works but it can't accept names with space
      //fgets(name,256,stdin);
      strcpy(s[i].name,name);
	    puts("Enter Roll No:");
	    scanf("%d",&s[i].rollNo);
	    puts("Enter department name:");
      scanf(" %[^\n]s",dn);
      strcpy(s[i].department,dn);
	    puts("Enter Course Name:");
      scanf(" %[^\n]s",cn);
      strcpy(s[i].course,cn);
	    puts("Enter Year of Joining");
	    scanf("%d",&s[i].yoj);
	}
	while(flag){
	    puts("Choose option");
	    puts("1. Print students joined in particular year");
	    puts("2. Print student's details specified by roll no.");
	    scanf("%d",&choice);
	    switch(choice){
	        case 1:
	                puts("Enter the year");
	                scanf("%d",&year);
	                yearDisplay(s,year);
	                break;
	        case 2:
	                puts("Enter roll no.");
	                scanf("%d",&roll);
	                rollDisplay(s,roll,n);
	                break;
	        default:
	                puts("Invalid choice.");
	    }
	    puts("Do you want to continue? \n Press 1. for yes \n 0. for no");
	    scanf("%d",&flag);
	}
	return 0;
}
void yearDisplay(struct student *dt, int y){
    int l=sizeof(dt),i;
    for(i=0;i<l;i++){
        if((dt+i)->yoj == y){
            printf("%s ",(dt+i)->name);
        }
    }
}
void rollDisplay(struct student dt[], int r, int l){
    int i;
    for(i=0;i<l;i++){
        if(dt[i].rollNo == r){
            printf("Name: %s ",dt[i].name);
            printf("Roll No: %d ",dt[i].rollNo);
            printf("Department: %s ",dt[i].department);
            printf("Course: %s ",dt[i].course);
            printf("Year of Joining: %d\n",dt[i].yoj);
        }
    }
}
