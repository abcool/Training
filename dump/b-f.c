/*
Program to implement library information system
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<malloc.h>
#include<string.h>
struct book{
  int accession_no;
  char *title,*author,issued[1];
  float price;
}*b;
void addBook(struct book *,int *);
void displayBookInfo(struct book *, int,char *,char *);
void displayByAuthor(struct book *, char *,int);
void displayTitle(struct book *,int, char *,int);
void displayAccessionOrder(struct book *,int);
void countNotIssuedBooks(struct book *, int);
int main(){
  int n=0,flag=1,choice,q,accessionNo=0;
  char *bt,*an;
  b = (struct book *)malloc(n * sizeof(struct book));
  while(flag){
  puts("Choose an option from below menu:");
  puts("1. Add book information");
  puts("2. Display book information");
  puts("3. List all the books of an author");
  puts("4. List the title of specified book");
  puts("5. List count of books in library");
  puts("6. List book ordered by accession number");
  puts("7. Exit");
  scanf("%d",&choice);
  switch(choice){
    case 1:
          addBook(b,&n);
          break;
    case 2:
          //int q,accessionNo;
          printf("\n Search by: \n 1. Accession Number \n 2. Book Title \n 3.Author Name \n");
          scanf("%d",&q);
          switch(q){
            case 1:
                  puts("Enter accession no:");
                  scanf("%d",&accessionNo);
                  break;
            case 2:
                  puts("Enter Title of book");
                  scanf(" %m[^\n]",&bt);
                  break;
            case 3:
                  puts("Enter Author Name");
                  scanf(" %m[^\n]",&an);
                  break;
            default:
                  puts("Wrong choice entered, please try again");
          }
          displayBookInfo(b,accessionNo,bt,an);
          break;
    case 3:
          //char *an;
          puts("Enter author's name");
          scanf(" %m[^\n]",&an);
          displayByAuthor(b,an,n);
          break;
    case 4:
          //char *an;
          printf("\n Search by: \n 1. Accession Number \n 2.Author Name \n");
          scanf("%d",&q);
          switch(q){
              case 1:
                    puts("Enter accession no:");
                    scanf("%d",&accessionNo);
                    break;
              case 2:
                    puts("Enter Author Name");
                    scanf(" %m[^\n]",&an);
                    break;
             default:
                    puts("Wrong choice entered, please try again");
          }
          displayTitle(b,accessionNo,an,n);
          break;
    case 5:
          countNotIssuedBooks(b,n);
          break;
    case 6:
          displayAccessionOrder(b,n);
          break;
    case 7:
          flag=0;
          free(b);
          break;
  }
}
return 0;
}
void addBook(struct book *b,int *n){
  *n=*n+1;
  b = (struct book *)realloc(b,*n * sizeof(struct book));
  puts("Enter accession number");
  scanf(" %d",&b[*n-1].accession_no);
  puts("Enter Title of the book");
  scanf(" %m[^\n]",&b[*n-1].title);
  puts("Enter Book Author"); // Code breaks from here
  scanf(" %m[^\n]",&b[*n-1].author);
  puts("Enter price of the book");
  scanf(" %f",&b[*n-1].price);
  *b[*n-1].issued = 'N';
}
void displayBookInfo(struct book *b, int accessionNo,char *bt,char *an){
  //Write Code here for Display book information
  int len=sizeof(*b)/sizeof(b[0]),i;
    for(i=0;i<len;i++){
      if(accessionNo!=0 && b[i].accession_no == accessionNo){
        printf("\nTitle: %s\n",b[i].title);
        printf("Author: %s\n",b[i].author);
        printf("Price: %f\n",b[i].price);
        printf("Issued: %c",*b[i].issued);
      }else if(bt!=NULL && strcmp(b[i].title,bt)){
        printf("\nTitle: %s\n",b[i].title);
        printf("Author: %s\n",b[i].author);
        printf("Price: %f\n",b[i].price);
        printf("Issued: %c",*b[i].issued);
      }else if(an!=NULL && strcmp(b[i].author,an)){
        printf("\nTitle: %s\n",b[i].title);
        printf("Author: %s\n",b[i].author);
        printf("Price: %f\n",b[i].price);
        printf("Issued: %c",*b[i].issued);
      }else{
        puts("No records found");
      }
    }
}
void displayByAuthor(struct book *b, char *an,int n){
  //List all the books of an author
}
void displayTitle(struct book *b,int accessionNo, char *an,int n){
  //List the title of specified book
}
void displayAccessionOrder(struct book *b,int n){
  //List book ordered by accession number
}
void countNotIssuedBooks(struct book *b, int n){
  //List count of books in library
}
