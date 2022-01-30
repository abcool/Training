/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* 
Tower of Hanoi Algorithm
Algo Tower(n,s,a,d){
    if(n==1){
        // means there is only 1 disc move it to destination
        print s-> d
        return
    }
    // Move top n-1 discs from source to auxillary using destination as an intermediate
    call Tower(n-1,s,d,a)
    // Move the single bottommost disk to destination
        print s-> d
    // Move top n-1 discs from auxillary to destination using source as an intermediate
    call Tower(n-1,a,s,d)
    return
}

Recursion tree for 3 discs

                       tower(3,s,a,d)
                    /                   \
       tower(2,s,d,a)       s-> d           tower(2,a,s,d)
       /             \                  /                   \
tower(1,s,a,d) s-> a  tower(1,d,s,a)  tower(1,a,d,s) a->d    tower(1,s,a,d)
      |                     |                 |                    |
     s->d                  d->a              a->s                s->d
   
   Video explanation : https://youtu.be/Ajy8XweC3L8
*/
class Codechef
{
    public static void TOH(int n,int source,int auxillary,int destination){
        if(n==1){
            System.out.printf("Move peg %d from %d to %d \n",n,source,destination);
            return;
        }
        TOH(n-1,source,destination,auxillary);
            System.out.printf("Move peg %d from %d to %d \n",n,source,destination);
        TOH(n-1,auxillary,source,destination);
            
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int pegs = scan.nextInt();
		System.out.println("Total number of pegs= " + pegs);
		System.out.println();
		TOH(pegs,1,2,3);
	}
}
