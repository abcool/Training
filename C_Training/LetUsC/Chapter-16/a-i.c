/*
Program to convert amount in numbers to amount in words
-----------------------------------------------------------
Version   Date       Author          Changelog
-----------------------------------------------------------
1.0    01/05/2019  Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
char *unit[]={
              "","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
              "Twelve","Thirteen","Forteen","Fifteen","Sixteen","Seventeen","Eighteen","Ninteen"
            },
     *tens[]={
              "","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"
             };
void convert(long,char[]);
int main(){
  int n;
  puts("Enter a number upto 9 digits in length: ");
  scanf("%d",&n);
  if(n<0){
    puts("Please enter positive number");
  }else if(n==0){
    puts("Zero");
  }else{
    convert((n/10000000),"Crore");
    convert((n/100000)%100,"Lakh");
    convert((n/1000)%100,"Thousand");
    convert((n/100)%10,"Hundred");
    convert((n%100),"");
  }
  return 0;
}
void convert(long n, char s[]){
  if(n>19){
    printf("%s %s ",tens[n/10],unit[n%10]);
  }else{
    printf("%s ",unit[n]);
  }
  if(n){
    printf("%s ",s);
  }
}
