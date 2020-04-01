/*
Program to implement dequeue of characters using pointers
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    20/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<stdlib.h>
void initialize(char *, int);
void lInsert(char *, int, char);
void rInsert(char *, int, char);
void lRemove(char *, int, char);
void rRemove(char *, int, char);
int main(){
  int size,flag=1,option;
  char value;
  puts("Enter the size of queue");
  scanf("%d",&size);
  char *arr = (char *)malloc(size * sizeof(char));
  initialize(arr,size);
  while(flag){
    puts("Please select an option:");
    puts("1. Insert from left");
    puts("2. Insert from Right");
    puts("3. Retrieve element from left");
    puts("4. Retrieve element from Right");
    puts("5. Exit");
    scanf("%d",&option);
    switch(option){
      case 1:
            puts("Enter character to insert");
            scanf(" %c",&value);
            lInsert(arr,size,value);
            break;
      case 2:
            puts("Enter character to insert");
            scanf(" %c",&value);
            rInsert(arr,size,value);
            break;
      case 3:
            puts("Enter character to retrieve");
            scanf(" %c",&value);
            lRemove(arr,size,value);
            break;
      case 4:
            puts("Enter character to retrieve");
            scanf(" %c",&value);
            rRemove(arr,size,value);
            break;
      case 5:
            flag=0;
            break;
      default:
            puts("Please enter correct choice");
            break;
    }
  }
  return 0;
}
void initialize(char *ar, int s){
  int i=0;
  while(i<s){
    *(ar+i)='Z';
    i++;
  }
}
void lInsert(char *ar, int s, char val){
  int i=0;
  while(i<s){
    if(*(ar+i)=='Z'){
      *(ar+i)=val;
      break;
    }else{
      i++;
    }
  }
  if(i==s){
    puts("Sorry queue is full, no more insertions possible.");
  }
}
void rInsert(char *ar, int s, char val){
  while(s-1>0){
    if(*(ar+(s-1))=='Z'){
      *(ar+(s-1))=val;
      break;
    }else{
      s--;
    }
  }
  if((s-1)==0){
    puts("Sorry queue is full, no more insertions possible.");
  }
}
void lRemove(char *ar, int s, char val){
  int i=0;
  while(i<s){
    if(*(ar+i)==val){
      printf("%c character found at location %d\n",val,i+1);
      *(ar+i)='Z';
      break;
    }else{
      i++;
    }
  }
  if(i==s){
    printf("The character %c is not in queue\n",val);
  }
}
void rRemove(char *ar, int s, char val){
  while(s-1>0){
    if(*(ar+(s-1))==val){
      printf("%c character found at location %d\n",val,s);
      *(ar+(s-1))='Z';
      break;
    }else{
      s--;
    }
  }
  if((s-1)==0){
    printf("The character %c is not in queue\n",val);
  }
}
