#include<stdio.h>
#define IN 1
#define OUT 0
int main(){
    int c,state=OUT;
    while((c=getchar())!=EOF){
        if(c==' ' || c=='\t' || c=='\n'){
            if(state==IN){ //End the word
            printf("\n");
            }
            state=OUT;
        }else if(state==OUT){//Print first character of word and start the word
            state=IN;
            putchar(c);
        }else{
            putchar(c);//Print the word starting from 2nd position
        }
    }
    return 0;
}