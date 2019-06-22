/*
Program to convert string number with decimals to float value
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    22/06/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
#include<malloc.h>
#include<math.h>
#include<string.h>
float parseFloat(char *);
char *getString();
int main(){
  char *s;
  float n;
  s=getString();
  //printf("String entered:%s\n",s);
  n=parseFloat(s);
  printf("Number entered is %f\n",n);
  free(s);
  return 0;
}
char *getString(){
  char ch,*temp;
  int n=0,i=0;
  puts("Enter a number");
  temp=(char *)malloc(n*sizeof(char));
  while((ch=getchar())!='\n'){
    n++;
    temp=realloc(temp,n*sizeof(char));
    *(temp+i)=ch;
    i++;
  }
  return temp;
}
float parseFloat(char *s){
  float n=0;
  int len,i=0,j;
  //printf("Len:%d\n",len);
  char *part[2],*token;
  token=strtok(s,".");
  j=0;
  while(token!=NULL){
    part[j]=token;
    j++;
    token=strtok(NULL,".");
  }
  len=strlen(part[0]);
  if(len==1){
    n+=*(part[0]+i)-48;
  }else{
  while(len>0){
    n+=((*(part[0]+i)-48)*(pow(10,len-1)));
    i++;
    len--;
  }
}
printf("Part 1:%s\n",part[1]);
len=strlen(part[1]);
printf("Len: %d\n",len);
i=0;
if(len==1){
  int t=*(part[1])-48;
  n=n+(t/10.0);
}else{
while(len>0){
  n+=((float)(*(part[1]+i)-48)/(float)(pow(10,i+1)));
  i++;
  len--;
}
}
  return n;
}
