/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
  /*
  * * * * 
  * * * * 
  * * * * 
  * * * * 
  * * * * 
  */
    private static void rectanglePattern(int rows, int cols){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                System.out.print("* ");
            System.out.println();
        }
    }
  
  /*
  ****
  *  *
  *  *
  *  *
  ****
  */
    private static void hollowRectanglePattern(int rows, int cols){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || i==(rows-1) || j==0 || j==(cols-1)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
  /*
    *****
    ****
    ***
    **
    *
  */
    private static void invertedHalfPyramid(int n){
        for(int i=n;i>0;i--){
            for(int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
  
  /*
      *
     **
    ***
   ****
  *****

  */
    private static void halfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j<=n-i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
 
  /*
  1
  22
  333
  4444
  55555
  */
    private static void halfPyramidNumber(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
  
  /*
  1 
  2 3 
  4 5 6 
  7 8 9 10 
  11 12 13 14 15
  */
    private static void floydTriangle(int n){
        int count=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }
  
  /*
  
  *      *
  **    **
  ***  ***
  ********
  ********
  ***  ***
  **    **
  *      *

  */
    private static void butterfly(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            int spaces = 2*n-2*i;
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            int spaces = 2*n-2*i;
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		/*int rows = 5, cols=4;
		hollowRectanglePattern(rows,cols);*/
		int n=5;
		//invertedHalfPyramid(n);
		//halfPyramid(n);
		//halfPyramidNumber(n);
		//floydTriangle(n);
		butterfly(4);
	}
}
