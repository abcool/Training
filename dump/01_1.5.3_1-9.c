/*
 ============================================================================
 Name        : 3_1-9.c
 Author      : Arvind Bakshi
 Version     :
 Copyright   : AbcoolCoding
 Description : Program to Replace a string of one or more blanks with a single blank
 ============================================================================
 */
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	setbuf(stdout,NULL);
	char string[30],out[30];
	int i,c;
	puts("Enter a String of size < 30");
	scanf(" %[^\n]%*s", string);
	for(i=0; string[i]; i++){
		if(string[i]==' '){
		    if(string[i+1]!=' '){
		        out[i]=string[i];
		    }
		}
			
	}
	printf("%s",out);
	//puts(out);
	return EXIT_SUCCESS;
}
