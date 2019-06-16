#include<stdio.h>
int main(){
int s1,s2,s3,s4,s5,agg;
float per_marks;
printf("Enter Student's Marks in 5 subjects: ");
scanf("%d %d %d %d %d", &s1, &s2, &s3, &s4, &s5);
agg = s1+s2+s3+s4+s5;
per_marks=(float)(agg*100)/500;
printf("Aggregate Marks: %d \n Percentage: %f \n", agg,per_marks);
return 0;
}
