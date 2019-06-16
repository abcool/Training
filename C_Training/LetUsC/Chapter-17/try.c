#include<stdio.h>
#include<malloc.h>
char * scanner();
int main(){
char *s;
puts("Enter a string");
s=scanner();
printf("Entered string: %s",s);
return 0;
}
char * scanner(){
char *c;
int n=0,ch;
c=(char *) malloc(n*sizeof(char));
while((ch=getchar())!='\n'){
   n++;
   c=(char *)realloc(c,n*sizeof(char));
   c[n-1]=ch;
 }
n++;
c=(char *)realloc(c,n*sizeof(char));
c[n-1]='\0';
return c;
}
