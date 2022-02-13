/* 
Given a Binary Tree, convert it into its mirror.
      Original                           Mirror
		|1|                               |1|
	   /   \                             /   \
	 |3|   |2|                         |2|   |3|
	       / \                        /  \     
		 |5| |4|                    |4|  |5|
*/
class Node{
	int data;
	Node left,right;
	Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
public class MirrorTree{
	private static void mirror(Node node) {
        if(node!=null){
            Node temp=node.left;
            node.left=node.right;
            node.right=temp;
            mirror(node.left);
            mirror(node.right);
        }
    }
	private static void printTree(Node root)
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
		System.out.println();
    }
	/* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    private static int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
	/* Print nodes at the current level */
    private static void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
			System.out.println();
            printCurrentLevel(root.left, level - 1);
			//System.out.print("\t");
            printCurrentLevel(root.right, level - 1);
			//System.out.println();
        }
    }
	public static void main(String[] abc){
		Node root = new Node(1);
		Node three = new Node(3);
		Node two = new Node(2);
		Node five = new Node(5);
		Node four = new Node(4);
		root.left=three;
		root.right=two;
		two.left=five;
		two.right=four;
		printTree(root);
		mirror(root);
		printTree(root);
	}
}