/* test */
#include<string.h>
#include<stdio.h>
int main(){
  char *s[]={
    "Hello",
    "Are u Ready",
    "To Rock",
    "And Roll"
  },*t;
  int i,j;
  for(i=0;i<4;i++){
    for(j=i+1;j<4;j++){
      printf("%d\n",strcmp(s[i],s[j]));
      if(strcmp(s[i],s[j])>0){
        t=s[i];
        s[i]=s[j];
        s[j]=t;
      }
    }
  }
  for(i=0;i<4;i++){
    printf("%s\n",s[i]);
  }
  return 0;
}
