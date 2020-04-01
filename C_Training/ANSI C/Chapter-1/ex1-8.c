#include<stdio.h>
int main(){
    int c,blank=0,tab=0,nl=0;
    while((c=getchar())!=EOF){
        if(c==' ')
            blank++;
        if(c=='\t')
            tab++;
        if(c=='\n')
            nl++;
    }
    printf("Blanks= %d \t Tabs= %d \t Newlines= %d\n",blank,tab,nl);
    return 0;
}