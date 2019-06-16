/*
Program that removes all occurences of the word the from a sentences
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    27/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<string.h>
#include <stdio.h>
void theRemove(char *);
void gets(char *);
int main(void) {
	char str[100];
	puts("Enter a sentence");
	gets(str);
	theRemove(str);
	puts("New Sentence");
	puts(str);
	return 0;
}
void theRemove(char *s){
    int l,i,j;
    l=strlen(s);
    i=0;
    while(*(s+i)!='\0'){
        if(i+5<=l){
            while((*(s+i)=='t' || *(s+i)=='T') && (*(s+i+1)=='h' || *(s+i+1)=='H') && (*(s+i+2)=='e' || *(s+i+2)=='E')){
                for(j=i;j<=l;j++){
                *(s+j)=*(s+j+3);
                *(s+j+1)=*(s+j+4);
                *(s+j+2)=*(s+j+5);
                }
            }
        }
        i++;
    }
}
