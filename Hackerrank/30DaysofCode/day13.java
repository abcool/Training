/**
author: Arvind
Given a Book class and a Solution class, write a MyBook class that does the following:

    . Inherits from Book
    . Has a parameterized constructor taking these 3 parameters:
        1. title
        2. author
        3. price

    . Implements the Book class' abstract display() method so it prints these 3 lines:

        1. Title: , a space, and then the current instance's title.
        2. Author: , a space, and then the current instance's author.
        3. Price: , a space, and then the current instance's price.
  
Sample Input
The following input from stdin is handled by the locked stub code in your editor:

The Alchemist
Paulo Coelho
248

Sample Output
The following output is printed by your display() method:

Title: The Alchemist
Author: Paulo Coelho
Price: 248

*/

import java.util.*;

abstract class Book {
    String title;
    String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    abstract void display();
}

// Declare your class here. Do not use the 'public' access modifier.
    // Declare the price instance variable
class MyBook extends Book{
    int price;
    MyBook(String title, String author, int price){
        super(title,author);
        this.price=price;
    }
    public void display(){
        System.out.println("Title: " +title + "\n" + "Author: " + author +"\n" +"Price: "+ price);
    }
}  
    /**   
    *   Class Constructor
    *   
    *   @param title The book's title.
    *   @param author The book's author.
    *   @param price The book's price.
    **/
    // Write your constructor here
    
    /**   
    *   Method Name: display
    *   
    *   Print the title, author, and price in the specified format.
    **/
    // Write your method here
    
// End class

public class Solution {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}
