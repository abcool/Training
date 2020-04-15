#include<stdio.h>
#define IN 1
#define OUT 0
int main(){
int c,len[5],k=0,state;
//Initialize length array to zero
for(int i=0;i<5;i++){
    len[i]=0;
}
state=OUT;
puts("Please enter a sentence with 5 words");
while((c=getchar())!=EOF){
    if(c==' ' || c=='\n' || c=='\t'){
            if(state==IN){
                k++;
            }
        state=OUT;
    }else if(state==IN){
        ++len[k];
    }else{
        state=IN;
        ++len[k];
    }
}
puts("\n Horizontal bars histogram");
    for(int i=0; i<5;i++){
        for(int j=0;j<len[i];j++){
            printf("*");
        }
        printf("\n");
        //printf("Len of %d = %d \n",i, len[i]);
    }

int maxlen=len[0];

//Find maximum length word
for(int i=0;i<5;i++){
    if(len[i]>maxlen){
        maxlen=len[i];
    }
}
//printf("Maxlength= %d",maxlen);
printf("\n Vertical Bar Histogram\n");
//Print vertical histogram
for(int i=maxlen;i>0;i--){//For moving rowise
    for(int j=0;j<5;j++){//For moving columnwise
        if(len[j]<i){
            printf(" \t");
        }else{
            printf("*\t");
            --len[j];
        }
    }
    printf("\n");
}
return 0;
}
