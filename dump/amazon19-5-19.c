/* Program to print first occurence of word(in reverse) in the string ended with $ that has its reverse present in the string. 
If no such word print $
*/
/* Author: Arvind Bakshi */
#include <stdio.h>
#include<string.h>
#include<malloc.h>
#include<stdlib.h>
void reverse(char *);
int main(void) {
	char *input,*copy,*token;
	puts("Enter a String");
    scanf("%m[^\n]", &input); // Scan dynamic input string
    input[strlen(input)]='\0'; // add \0 to the end
    copy = (char *)malloc(strlen(input)*sizeof(char));
    strcpy(copy,input); // copy input string to new variable
    token = strtok(copy, " "); // extract words from input string using space as tokenizer
    while(token!=NULL){ // loop on extracted words
        reverse(token); // reverse the token word
        if (strstr(input,token)!=NULL){ // check whether reversed word is present in string
            puts(token); // if yes print reversed word
            free(input); // free memory
	    free(copy); // free memory
            return 0; // exit program
        }
        token = strtok(NULL, " "); // go to next word
    }
    free(input); // free memory
    free(copy); // free memory
    puts("$"); // if not matching reversed word found print $
    return 0; // exit program
}
void reverse(char *s){
    int len= strlen(s),i,j;
    char t[len];
    for(i=len-1,j=0;i>=0,j<len;i--,j++){
        *(t+j)=*(s+i);
    }
    strcpy(s,t);
}
