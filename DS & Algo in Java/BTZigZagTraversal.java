/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node left,right;
    Node(){}
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void zigzagTraversal(Node root){
        
        if(root==null)
            return;
            
        Stack<Node> currentLevel = new Stack<Node>();
        Stack<Node> nextLevel = new Stack<Node>();;
        
        currentLevel.push(root);
        
        boolean leftOrRightChild = true;
        
        while(!currentLevel.empty()){
            Node temp = currentLevel.pop();
            if(temp!=null){
                System.out.print(temp.data +" ");
                if(leftOrRightChild){
                    if(temp.left!=null)
                        nextLevel.push(temp.left);
                   
                    if(temp.right!=null)
                        nextLevel.push(temp.right);
                   
                }else{
                    if(temp.right!=null)
                        nextLevel.push(temp.right);
                    if(temp.left!=null)
                        nextLevel.push(temp.left);
                }
            }
            if(currentLevel.empty()){
                leftOrRightChild = !leftOrRightChild;
                Stack<Node> t = currentLevel;
                currentLevel=nextLevel;
                nextLevel=t;
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n6 = new Node(6);
		n1.left=n2;n1.right=n3;
		n2.left=n4;
		n3.right=n6;
		zigzagTraversal(n1);
	}
}
