/* program to check whether Binary tree is BST or not */

import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    public Node(){}
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static boolean isSubTreeLesser(Node root, int data){
        if(root==null)
            return true;
        if(root.data<=data && isSubTreeLesser(root.left,data) && isSubTreeLesser(root.right,data))
            return true;
        else
            return false;
        
    }
    public static boolean isSubTreeGreater(Node root, int data){
        if(root==null)
            return true;
        if(root.data>=data && isSubTreeGreater(root.left,data) && isSubTreeGreater(root.right,data))
            return true;
        else
            return false;
    }
    public static boolean isBST(Node root){
        if(root==null)
            return true;
        if(isSubTreeLesser(root.left,root.data)
          &&isSubTreeGreater(root.right,root.data)
          &&isBST(root.left)
          &&isBST(root.right))
            return true;
        else
            return false;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Node n7 = new Node(7);
		Node n9 = new Node(9);
		Node n4 = new Node(4);
		n7.right=n9;
		n7.left=n4;
		Node n1 = new Node(1);
		Node n6 = new Node(6);
		n4.right=n6;
		n4.left=n1;
		if(isBST(n7))
		    System.out.println("BST");
		else
		    System.out.println("Not BST");
	}
}
