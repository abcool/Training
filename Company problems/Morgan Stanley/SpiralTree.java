/*
Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 

-----------------------------------------------------------------------------------------------------------------

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
0 <= Data of a node <= 105
*/
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.
	/*
	This problem can be solved using two stacks. Assume the two stacks are current: currentlevel and nextlevel. 
	We would also need a variable to keep track of the current level order(whether it is left to right or right to left). 
	We pop from the currentlevel stack and print the nodes value. 
	Whenever the current level order is from left to right, push the nodes left child, then its right child to the stack nextlevel. 
	Since a stack is a LIFO(Last-In-First_out) structure, next time when nodes are popped off nextlevel, it will be in the reverse order. 
	On the other hand, when the current level order is from right to left, we would push the nodes right child first, then its left child. 
	Finally, do-not forget to swap those two stacks at the end of each level(i.e., when current level is empty) 
	*/
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> list = new ArrayList<>();
		// declare two stacks
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
		// push the root
        currentLevel.push(root);
		//Initially leftToRight is set to true
        boolean leftToRight = true;
		// check if stack is empty
        while(!currentLevel.isEmpty()){
			// pop out of stack
            Node temp= currentLevel.pop();
            if(temp!=null){
				// push data into list
                list.add(temp.data);
				// store data according to current
				// order.
                if(leftToRight){
                    if(temp.right!=null)
                        nextLevel.push(temp.right);
                     if(temp.left!=null)
                        nextLevel.push(temp.left);
                }else{
                    if(temp.left!=null)
                        nextLevel.push(temp.left);
                    if(temp.right!=null)
                        nextLevel.push(temp.right);
                }
            }
			//swap those two stacks at the end of each level
            if(currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                Stack<Node> tempStack = currentLevel;
                currentLevel=nextLevel;
                nextLevel=tempStack;
            }
        }
        return list;
    }
}

public class SpiralTree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Spiral g = new Spiral();
                ArrayList<Integer> result = g.findSpiral(root);
                for(int value : result)
                System.out.print(value + " ");
			    System.out.println();
    	        
	        }
	}
}

