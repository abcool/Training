#include<stdio.h>
int main(){
int c;
while((c=getchar())!=EOF){
putchar(c);
}
printf("\nc= %d\n",c);
return 0;
}
