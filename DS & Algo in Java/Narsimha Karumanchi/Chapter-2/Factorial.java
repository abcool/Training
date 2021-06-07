import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Factorial
{
    /**
     * @author Arvind Bakshi
     * @apiNote This function calculates factorial of a number using recursion
     * @param An integer number
     * @return factorial of the input number
     */
    public static int factorial(int n){
        if(n<=1)
            return 1;
        else
            return n*factorial(n-1);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		scan.close();
		System.out.printf("factorial of %d is %d", n,factorial(n));
		
	}
}