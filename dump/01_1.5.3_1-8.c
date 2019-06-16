/*
 ============================================================================
 Name        : 3_1-8.c
 Author      : Arvind Bakshi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

/*
 Modification History

Date		Version		Author				Description
----------	-----------	-------------------	----------------------------------------
01-01-2019   1.0		 Arvind Bakshi		Initial Version.
------------------------------------------------------------------------------
*/

// Program to calculate number of blanks, tabs and newlines in a string
#include <stdio.h>

int main(void) {
    int blanks,tabs,newlines;
    char string[30];
    blanks=0;
    tabs=0;
    newlines=0;
    setbuf(stdout,NULL);
    printf("Enter some text less than size 30:\t");
    //scanf("%s", &string);
    fgets(string, sizeof(string), stdin);
    for(int i=0; string[i]!=0; i++){
       if(string[i]==' ')
         blanks++;
       if(string[i]=='\t')
         tabs++;
       if(string[i]=='\n')
         newlines++;
    }
       printf("No of blanks: %d \n No of Tabs: %d \n No of Newlines: %d", blanks,tabs,newlines);
   return 0;
 }
