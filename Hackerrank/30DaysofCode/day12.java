/**
@author: Arvind

Sample Input

Heraldo Memelli 8135627
2
100 80

Sample Output

 Name: Memelli, Heraldo
 ID: 8135627
 Grade: O

Explanation

This student had 2scores to average: 100 and 80. The student's average grade is (100+80)/2. 
An average grade of 90 corresponds to the letter grade O, so our calculate() method should return the character'O'.
*/

import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
	private int[] testScores;
    int scores[],len; 
    //= new int[super.numScores];
    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
    Student(String firstName, String lastName, int id, int[] scores){
        super(firstName,lastName,id);
        //super.firstName=firstName;
        //super.lastName=lastName;
        //super.idNumber=id;
        this.len=scores.length;
        this.scores=new int[len];
        this.scores=scores;
    }
    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here
    public char calculate(){
        int sum=0,avg;
        char ch='I';
        for(int i=0;i<len;i++){
            sum+=scores[i];
        }
        avg=sum/len;
        if(avg>=90 && avg<=100)
        ch = 'O';
        if(avg>=80 && avg<90)
        ch = 'E';
        if(avg>=70 && avg<80)
        ch = 'A';
        if(avg>=55 && avg<70)
        ch = 'P';
        if(avg>=40 && avg<55)
        ch = 'D';
        if(avg<40)
        ch = 'T';
        return ch;
    }
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}
