interface IStack{
	public void push(int input);
	public int pop() throws StackEmptyException;
	public int top() throws StackEmptyException;
	public int size();
	public boolean isEmpty();
	public boolean isFull();
}
class StackEmptyException extends Exception{
	public StackEmptyException(String message){
		super(message);
	}
}
public class DynamicArrayStack implements IStack{
	private static int capacity=1,top=-1;
	private static int[] stack, tempStack;
	public DynamicArrayStack(){
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
	public void expandStack(){
		tempStack = new int[capacity*2];
		System.arraycopy(stack,0,tempStack,0,capacity);
		this.stack=tempStack;
		this.capacity*=2;
	}
	public void shrinkStack(){
		tempStack = new int[capacity/2];
		if(top<Math.ceil(capacity/4)){
			System.arraycopy(stack,0,tempStack,0,top+1);
			this.stack=tempStack;
			this.capacity/=2;
		}
	}
	public void push(int input){
		if(isFull())
			expandStack();
		this.stack[++top]=input;
	}
	public int pop() throws StackEmptyException{
		int data;
		if(isEmpty())
			throw new StackEmptyException("Stack is empty, nothing to pop.");
		else
			data = this.stack[top--];
		shrinkStack();
		return data;
	}
	public int top() throws StackEmptyException{
		if(isEmpty())
			throw new StackEmptyException("Stack is empty");
		else
			return this.stack[top];
	}
	public void printStack(){
		for(int i=top;i>-1;i--)
			System.out.print("|"+this.stack[i]+"|-");
		System.out.println();
	}
	public static void main(String[] args) throws StackEmptyException{
		DynamicArrayStack stack = new DynamicArrayStack();
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