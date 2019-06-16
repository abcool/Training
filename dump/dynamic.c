#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
int main()
{
  char *str, c;
  int i = 0, j = 1;

  str = (char*)malloc(sizeof(char));

  printf("Enter String : ");

  while (c != '\n') {
    // read the input from keyboard standard input
    c = getchar();

    // re-allocate (resize) memory for character read to be stored
    str = (char*)realloc(str, j * sizeof(char));

    // store read character by making pointer point to c
    str[i] = c;

    i++;
    j++;
  }

  str[i] = '\0'; // at the end append null character to mark end of string

  printf("\nThe entered string is : %s", str);

  free(str); // important step the pointer declared must be made free
  return 0;
}
