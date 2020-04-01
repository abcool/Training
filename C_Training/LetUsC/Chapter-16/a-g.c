/*
Program to replace set of names with their initials e.g. Rohit Sharma = R S
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    29/04/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<string.h>
void abbrevate(char *);
int main(){
    char *s[]={
        "Sahil Verma",
        "Abhi Dikshit",
        "Vrinda Verma",
        "Rohit Sharma",
        "Dinesh Mistri"
    };
    int i;
    puts("Original Set");
    for(i=0;i<5;i++){
        printf("%s\n",s[i]);
    }
    for(i=0;i<5;i++){
        abbrevate(s[i]);
    }
    puts("Abbrevated set");
    for(i=0;i<5;i++){
        printf("%s\n",s[i]);
    }
    return 0;
}
void abbrevate(char *s){
    int i,len;
    len=strlen(s);
    i=0;
    while(*(s+i)!=' '){
        i++;
    }
	//Problem in code from here
    *(s+1)=' ';
    *(s+2)=*(s+i+1); // First character of last name
    for(i=3;i<len;i++){
        *(s+i)='\0';
    }
}
