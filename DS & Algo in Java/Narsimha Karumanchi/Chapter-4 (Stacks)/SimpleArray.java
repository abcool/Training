interface IStack{
	public void push(int input) throws StackFullException;
	public int pop() throws StackEmptyException;
	public int top() throws StackEmptyException;
	public int size();
	public boolean isEmpty();
	public boolean isFull();
}
class StackFullException extends Exception{
	public StackFullException(String message){
		super(message);
	}
}
class StackEmptyException extends Exception{
	public StackEmptyException(String message){
		super(message);
	}
}
public class SimpleArray implements IStack{
	private static int capacity,top=-1;
	private static int[] stack;
	public SimpleArray(int capacity){
		this.capacity=capacity;
		this.stack = new int[capacity];
	}
	public int size(){
		return top+1;
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public boolean isFull(){
		return size()==capacity;
	}
	public void push(int input) throws StackFullException{
		if(isFull())
			throw new StackFullException("Stack is full, can't push more elements.");
		else{
			this.stack[++top]=input;
		}
	}
	public int pop() throws StackEmptyException{
		int data;
		if(isEmpty())
			throw new StackEmptyException("Stack is empty, nothing to pop.");
		else{
			data = this.stack[top--];
		}
		return data;
	}
	public int top() throws StackEmptyException{
		if(isEmpty())
			throw new StackEmptyException("Stack is empty");
		else{
			return this.stack[top];
		}
	}
	public void printStack(){
		for(int i=top;i>-1;i--)
			System.out.print("|"+this.stack[i]+"|-");
		System.out.println();
	}
	public static void main(String[] args) throws StackEmptyException,StackFullException{
		SimpleArray stack = new SimpleArray(10);
		stack.push(5);
		stack.push(2);
		stack.push(9);
		stack.push(1);
		stack.push(7);
		System.out.println("Stack now contains: " + stack.size()+ " elements as below: ");
		stack.printStack();
		System.out.println("Popped: "+ stack.pop());
		System.out.println("Stack now contains: " + stack.size()+ " elements as below: ");
		stack.printStack();
		System.out.println("Top element on stack is "+ stack.top());
		System.out.println("Popped: "+ stack.pop());
		System.out.println("Popped: "+ stack.pop());
		System.out.println("Stack now contains: " + stack.size()+ " elements as below: ");
		stack.printStack();
	}
}