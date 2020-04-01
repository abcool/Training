#include<stdio.h>
int main(){
    int c;
    if((c=getchar())!=EOF){
    printf("Not end of file\n");
    }else{
    printf("%d",c);
    printf("End of file\n");
    }
    return 0;
}