import java.util.Scanner;
class stackData{
  private int maxSize; //maximum elements stack can hold
  private long[] stackarray; // declare stack
  private int top; // bottom marker of stack

  /**
  default constructor to initialize stack
  **/
  public stackData(int s){ //
    maxSize = s;
    stackarray = new long[maxSize]; // initialize stack
    top=-1;//set bottom marker
  }
  /**
  This method pushes elements onto the stack
  @author Arvind Bakshi
  @param j element to be pushed onto the stack
  **/
  public void push(long j){
    if(isFull()){
      System.out.print("Stack is full, please delete some elements");
    }else{
    stackarray[++top]=j;
  }
  }
  /**
  This method pops top most element from the stack
  and decrements bottom marker of the stack
  @author Arvind Bakshi
  @return top element of the stack
  **/
  public long pop(){
    if(isEmpty()){
    System.out.print("Stack is empty, please insert some elements");
    return 0;
  }else{
    return stackarray[top--];
  }
  }
  /**
  This method fetches top most element of the stack
  without removing it from the stack
  @author Arvind Bakshi
  @return top element of the stack
  **/
  public long peek(){
    if(isEmpty()){
      System.out.print("Stack is empty, please insert some elements");
      return 0;
    }else{
    return stackarray[top];
  }
  }
  /**
  @author Arvind Bakshi
  **/
  public void display(){
    if(isEmpty()){
    System.out.println("Stack is empty, please insert some elements");
  }else{
    System.out.println("Elements in stack are");
    for(int i=top;i>=0;i--){
      System.out.println("|"+ stackarray[i]+"|");
    }
   }
  }
  /**
  This method checks if the stack is empty
  @author Arvind Bakshi
  @return returns true if stack is empty, otherwise false
  **/
  public boolean isEmpty(){
      return(top==-1);
  }
  /**
  This method checks if the stack is full
  @author Arvind Bakshi
  @return  returns true if stack is full,otherwise false
  **/
  public boolean isFull(){
    return (top==maxSize-1);
  }
}
class stack{
  public static void main(String a[]){
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter number of elements in stack");
    int items = scan.nextInt();
    stackData theStack = new stackData(items);
    boolean flag = true;
    while(flag){
    System.out.println("***************Please choose an option*************\n");
    System.out.println("1. Push" + "\n" + "2. Pop" +"\n" + "3. Peek" + "\n" + "4. Display" + "\n" + "5. Exit");
    int option = scan.nextInt();
    switch(option){
      case 1:
            System.out.println("Enter the element");
            long element = scan.nextLong();
            theStack.push(element);
            System.out.println(element + " pushed onto the stack");
            break;
      case 2:
              long popped = theStack.pop();
              if(popped!=0)System.out.println("Element popped is " + popped);
              break;
      case 3:
            if(theStack.peek()!=0)System.out.println("Topmost element is " + theStack.peek());
            break;
      case 4:
            theStack.display();
            break;
      case 5:
            flag=false;
            break;
      default:
            System.out.println("Wrong choice entered, please try again");
            break;
    }
  }
  scan.close();
 }
}
