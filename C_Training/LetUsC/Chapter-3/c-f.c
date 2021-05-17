/*
Program to Find whether reversed and original number are same or not
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
#include<stdio.h>
_Bool main(){
  int ram,shyam,ajay;
  puts("Enter the ages of ram,shyam, & ajay: ");
  scanf("%d %d %d",&ram,&shyam,&ajay);
  if((ram>shyam)&&(ram>ajay)){
    puts("Ram is the eldest.\n");
  }
  if((shyam>ram)&&(shyam>ajay)){
    puts("Shyam is the Eldest.\n");
  }
  if((ajay>ram)&&(ajay>shyam)){
    puts("Ajay is the Eldest.\n");
  }
  return 1;
}
