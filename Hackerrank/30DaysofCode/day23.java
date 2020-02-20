/**
@author: Arvind
Task
A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to right, top to bottom. 
You are given a pointer, root, pointing to the root of a binary search tree. 
Complete the levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree.

Sample Input
6
3
5
4
7
2
1

Sample Output
3 2 5 1 4 7 

*/
import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{
//Find height of the tree
static int height(Node root){
    return root==null?0:1+Math.max(height(root.left),height(root.right));
}
//print node and its left and right children
static void printTree(Node root, int l){
    if(root==null)
        return;
    if(l==1){
        System.out.print(root.data+ " ");
    }else if(l>1){
        printTree(root.left,l-1);
        printTree(root.right,l-1);
    }

}
//scan tree from left to right and top to bottom
static void levelOrder(Node root){
    int h=height(root);
    for(int level=1;level<=h;level++)
      printTree(root,level);
    }

public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}
