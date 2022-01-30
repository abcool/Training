import java.util.*;
public class InfixToPostfix{
	//
	public static int getPrecedence(char ch){
		if(ch=='+'|| ch=='-')
			return 1;
		if(ch=='*'|| ch=='/'|| ch=='%')
			return 2;
		return 0;
	}
	public static String toPostfix(String s){
		String out = "";
		Stack<Character> stack = new Stack<>();
		//Scan the infix notation from left to right one character at a time.
		for(int i=0;i<s.length();++i){
			char ch = s.charAt(i);
			//If the next symbol scanned as an operand, append it to the postfix string.
			if(Character.isLetter(ch))
				out+=ch;
			//If a left parenthesis is scanned, push it into the stack.
			else if(ch=='(')
				stack.push(ch);
			//If a right parenthesis is scanned, all operators down to the most recently scanned left parenthesis must be popped 
			//and appended to the postfix string. 
			//Furthermore, the pair of parentheses must be discarded.
			else if(ch==')'){
				while(stack.peek()!='(')
					out+=stack.pop();
				stack.pop();
			}
			//If the next symbol scanned as an operator
			else{
				//Pop and append to the postfix string every operator on the stack that
				//Is above the most recently scanned left parenthesis, and
				//Has precedence higher than or is a right-associative operator of equal precedence to that of the new operator symbol.
				while(!stack.empty() && stack.peek()!='(' && getPrecedence(ch)<=getPrecedence(stack.peek()))
					out+=stack.pop();
				//Push the new operator onto the stack
				stack.push(ch);
			}
		}
		//When the infix string is fully scanned, the stack may still contain some operators. 
		//All the remaining operators should be popped and appended to the postfix string.
		while(!stack.empty())
			out+=stack.pop();
		return out;
	}
	
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	String expression = scan.nextLine();
	scan.close();
	String postfix = toPostfix(expression);
	System.out.println("Postfix expression of "+ expression+ " is " + postfix);
	}
}