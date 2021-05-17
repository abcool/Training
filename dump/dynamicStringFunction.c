#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
char* scanner();
int main(){
char *s;
puts("Enter a string");
s=scanner();
printf("Entered string: %s",s);
//free(s);
return 0;
}
char* scanner(){
char *c;
int n=0,ch;
c=(char *) malloc(n*sizeof(char));
while(ch!='\n'){
   ch=getchar();
   n++;
   c=(char *)realloc(c,n*sizeof(char));
   c[n-1]=ch;
 }
c=(char *)realloc(c,(n+1)*sizeof(char));
c[n]='\0';
return c;
}
