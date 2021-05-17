/* Program to manipulate array of structure using pointers */
#include <stdio.h>
#include<string.h>
struct data{
    int a;
    char s[10];
};
void change(struct data *);
int main(void) {
	struct data d[3];
	change(d);
	int i;
	for(i=0;i<3;i++){
	    printf("%d %s \n",d[i].a,d[i].s);
	}
	return 0;
}
void change(struct data *dt){
    int j;
    char str[20];
    puts("Enter text");
    scanf("%[^\n]s",str);
    for(j=0;j<3;j++){
        (dt+j)->a=j;
        strcpy((dt+j)->s,str);
    }
}
