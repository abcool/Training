#include<stdio.h>
int main(){
    int c,lastC=1;
    while((c=getchar())!=EOF){
        if(c!=' '|| lastC!=' '){
            putchar(c);
        }
        lastC=c;
    }
    return 0;
}