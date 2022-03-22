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
	/*
		1 2 3 4 5 
		1 2 3 4 
		1 2 3 
		1 2 
		1 
	*/
	private static void invertedPattern(int n){
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=(n-i)+1;j++){
			System.out.print(j+" ");
		    }
		    System.out.println();
		}
    	}
	
	/*
		1 
		0 1 
		1 0 1 
		0 1 0 1 
		1 0 1 0 1 
	*/
	private static void zeroOnePattern(int n){
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=i;j++){
			if((i+j)%2==0)
			    System.out.print("1 ");
			else
			    System.out.print("0 ");
		    }
		    System.out.println();
		}
    	}
	
	/*
		    * * * * * 
		   * * * * * 
		  * * * * * 
		 * * * * * 
		* * * * * 
	*/
	private static void rhombusPattern(int n){
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=n-i;j++)
			System.out.print(" ");
		    for(int j=1;j<=n;j++){
			System.out.print("* ");
		    }
		    System.out.println();
		}
    	}
	
	/*
	    1 
	   1 2 
	  1 2 3 
	 1 2 3 4 
	1 2 3 4 5 
	
	*/
	private static void numberPattern(int n){
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=n-i;j++)
			System.out.print(" ");
		    for(int j=1;j<=i;j++)
			System.out.print(j + " ");
		    System.out.println();
		}
    	}
	
	/*
	        1 
	      2 1 2 
	    3 2 1 2 3 
	  4 3 2 1 2 3 4 
	5 4 3 2 1 2 3 4 5 

	*/
	private static void palindromicPattern(int n){
		/*for(int i=1;i<=n;i++){
		    for(int j=1;j<=n-i;j++)
			System.out.print(" ");

		    for(int j=i;j>=1;j--)
			System.out.print(j);

		    for(int j=2;j<=i;j++){
			System.out.print(j);
		    }

		    System.out.println();
		}*/
		for(int i=1;i<=n;i++){
		    int j;
		    for(j=1;j<=n-i;j++){
			System.out.print("  ");
		    }
		    int k=i;
		    for(;j<=n;j++){
			System.out.print(k--);
			System.out.print(" ");
		    }
		    k=2;
		    for(;j<=n+i-1;j++){
			System.out.print(k++);
			System.out.print(" ");
		    }
		    System.out.println();
		}
    	}
	
	/*
	   *
	  ***
	 *****
	*******
	*******
	 *****
	  ***
	   *

	*/
	private static void starPattern(int n){
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=n-i;j++)
			System.out.print(" ");
		    for(int j=1;j<=(2*i)-1;j++)
			System.out.print("*");
		    System.out.println();
		}
		for(int i=n;i>=1;i--){
		    for(int j=1;j<=n-i;j++)
			System.out.print(" ");
		    for(int j=1;j<=(2*i)-1;j++)
			System.out.print("*");
		    System.out.println();
		}
    	}
	
	/*
		    *       *       *     
		  *   *   *   *   *   *   
		*       *       *       * 
	*/
	private static void zigZagPattern(int n){
		for(int i=1;i<=3;i++){
		    for(int j=1;j<=n;j++){
			if((i+j)%4==0 || (i==2 && j%4==0))
			    System.out.print("* ");
			else
			    System.out.print("  ");
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
		//butterfly(4);
		//invertedPattern(5);
		//zeroOnePattern(5);
		//rhombusPattern(5);
		//numberPattern(5);
		//palindromicPattern(5);
		//starPattern(4);
		zigZagPattern(13);
	}
}
