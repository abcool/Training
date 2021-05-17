/*
Program to Find whether triangle is isoceles,equilateral,scalene or right angled.
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
float s1,s2,s3;
puts("Enter sides of triangle:");
scanf("%f %f %f",&s1,&s2,&s3);
if(s1==s2 && s2==s3){
  puts("Equilateral Triangle.\n");
}else if((s1*s1)==(s2*s2)+(s3*s3)||(s2*s2)==(s1*s1)+(s3*s3)||(s3*s3)==(s2*s2)+(s1*s1)){
  puts("Right Angled Triangle.\n");
}else if((s1==s2) && (s2!=s3) || (s2==s3) && (s3!=s1) || (s1==s3)&&(s3!=s2)){
  puts("Isoceles Triangle.\n");
}
return 1;
}
