#include<stdio.h>
int main(){
    int c;
    int lastC='a';
    while((c=getchar())!=EOF){
        if(c!=' ')
            printf("%c",c);
        
        if(c==' ')
            if(lastC!=' ')
                putchar(c);
        
        lastC = c;
    }
    return 0;
}

/* 
Shorter version
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
*/