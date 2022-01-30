import java.util.*;
public class PostfixToInfix{
	public static String toInfix(String postfix){
		Stack<String> stack = new Stack<>();
		for(int i=0;i<postfix.length();i++){
			char ch = postfix.charAt(i);
			if(Character.isLetter(ch))
				stack.push(Character.toString(ch));
			else{
				String b= stack.pop();
				String a = stack.pop();
				stack.push("("+a+ch+b+")");
			}	
		}
		return stack.pop();
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String expression = scan.nextLine();
		scan.close();
		String infix = toInfix(expression);
		System.out.println("Infix expression of "+ expression+ " is " + infix);
	}
}