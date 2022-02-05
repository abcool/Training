/*
Given a binary tree, find the Postorder Traversal of it.

Input:
        19
     /     \
    10      8
  /    \
 11    13
 
Output: 11 13 10 8 19


Input:
          11
         /
       15
      /
     7
Output: 7 15 11

*/
import java.util.*;
class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class BinaryTree
{
    // Root of Binary Tree
    Node root;
 
    // Constructors
    BinaryTree(int data)
    {
        root = new Node(data);
    }
 
    BinaryTree()
    {
        root = null;
    }

}
public class PostOrderTraversalBinaryTree{
	
	private static ArrayList<Integer> traversal = new ArrayList<>();
    //Function to return a list containing the postorder traversal of the tree.
    private static ArrayList<Integer> postOrder(Node root)
    {
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            traversal.add(root.data);
        }
        return traversal;
    }
	
	public static void main(String[] kk){
		BinaryTree tree = new BinaryTree();
		/*
					19
				 /     \
				10      8
			  /    \
			 11    13
		*/
		tree.root = new Node(19);
		tree.root.left = new Node(10);
		tree.root.right = new Node(8);
		tree.root.left.left = new Node(11);
		tree.root.left.right = new Node(13);
		System.out.println("Postorder traversal of BT 1 is ");
		postOrder(tree.root).forEach(x->System.out.print(x + " "));
	}
}