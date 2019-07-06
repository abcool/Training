#include <stdio.h>

int main(void) {
int c;
while((c=getchar())!=EOF){
    if(c==' '){
        if((c=getchar())==' '){
            putchar(' ');
        }else{
            putchar(' ');
            putchar(c);
            //putchar(' ');
        }
    }else{
        putchar(c);
    }
    
}

return 0;
}
