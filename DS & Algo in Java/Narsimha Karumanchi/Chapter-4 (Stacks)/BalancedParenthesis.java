import java.util.Scanner;
import java.util.Stack;
public class BalancedParenthesis{
	public static boolean checkBalanced(String s){
		boolean isBalanced=false;
		if(s==null || s.length()==0)
			return true;
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			switch(ch){
				case '}':
					  if(!stack.isEmpty()&& stack.peek()=='{')
						  stack.pop();
					  break;
				case ']':
					  if(!stack.isEmpty()&& stack.peek()=='[')
						  stack.pop();
					  break;
				case ')':
					if(!stack.isEmpty()&& stack.peek()=='(')
						  stack.pop();
					  break;
				case '|':
					if(!stack.isEmpty() && stack.peek()=='|'){
						stack.pop();
					}else
						stack.push(ch);
					break;
				case '{':
				case '(':
				case '[':
					stack.push(ch);
					break;
			}
		}
		if(stack.isEmpty())
			isBalanced=true;
		return isBalanced;
	}
	public static void main(String[] a){
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		if(checkBalanced(input))
			System.out.println("Balanced");
		else
			System.out.println("Not Balanced");
	}
}