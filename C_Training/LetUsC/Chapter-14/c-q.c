/*
Program to implement dequeue of characters
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    18/04/2019  Arvind Bakshi    Initial Version
1.2    20/04/2019  Arvind Bakshi    Fixed code
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
int main(){
  char ar[10]={'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},value;
  int i=0,j=9,flag=1,option;
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
            while(i<10){
              if(ar[i]!='Z'){
                i++;
              }else{
                puts("Enter a character");
                scanf(" %c",&ar[i]);
                break;
              }
            }
            if(i==10){
              puts("Sorry queue is full, no more insertions possible");
            }
            break;
       case 2:
            while(j>0){
              if(ar[j]!='Z'){
                j--;
              }else{
                puts("Enter a character");
                scanf(" %c",&ar[j]);
                break;
              }
            }
            if(j==0){
              puts("Sorry queue is full, no more insertions possible");
            }
            break;
       case 3:
            i=0;
            puts("Enter a character to retrieve");
            scanf(" %c",&value);
            while(i<10){
              if(ar[i]==value){
                printf("%c character found at loc %d\n",value,i+1);
                ar[i]='Z';
                break;
              }else{
                i++;
              }
            }
            if(i==10){
              puts("Sorry character not in queue");
            }
            break;
      case 4:
            j=9;
            puts("Enter a character to retrieve");
            scanf(" %c",&value);
            while(j>0){
              if(ar[j]==value){
                printf("%c character found at loc %d\n",value,j+1);
                ar[j]='Z';
                break;
              }else{
                j--;
              }
            }
            if(j==0){
              puts("Sorry, character not in queue");
            }
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
