#include<stdio.h>
int main(){
int c,nb=0,nt=0,nl=0;
while((c=getchar())!=EOF){
	if(c==' '){
	   nb++;
	}
	if(c=='\t'){
	   nt++;
	}
	if(c=='\n'){
	   nl++;
	}
}
printf("No of blanks: %d \n No of tabs: %d \n No of newlines: %d\n",nb,nt,nl);
return 0;
}
