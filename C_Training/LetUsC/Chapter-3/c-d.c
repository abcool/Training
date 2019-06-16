/* According to Gregorian Calendar, it was Monday on the date 01/01/01.
Program to Find Day on 1st January of year entered by the user
-----------------------------------------------------------
Version     Author          Changelog
-----------------------------------------------------------
1.0      Arvind Bakshi    Initial Version
-----------------------------------------------------------
Copyright @AbCool Codings....
*/
_Bool main(){
  int leapdays,firstday,year;
  long int normaldays, totaldays;
  puts("Enter a year:");
  scanf("%d",&year);
  normaldays = (year-1)*365L;
  leapdays = (year-1)/4-(year-1)/100+(year-1)/400;
  totaldays = normaldays+leapdays;
  firstday=totaldays%7;
  if(firstday==0){
    puts("Monday\n");
  }else if(firstday==1){
    puts("Tuesday\n");
  }else if(firstday==2){
    puts("Wednesday\n");
  }else if(firstday==3){
    puts("Thursday\n");
  }else if(firstday==4){
    puts("Friday\n");
  }else if(firstday==5){
    puts("Saturday\n");
  }else if(firstday==6){
    puts("Sunday\n");
  }
  return 1;
}
