/*
Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.

Example 1:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Explanation: In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end os 8. 

Example 2:

Input:
N = 5
LinkedList: 10->5->100->5
Output: -1
Explanation: In the second example, there
are 4 nodes in the linked list and we
need to find 5th from the end. Since 'n'
is more than the number of nodes in the
linked list, the output is -1.

----------------------------------------------------------------------------------------------------------------------------------------

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= L <= 106
1 <= N <= 106
*/
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) 
    {
        data = d; 
        next = null;
    }
}
	
class Solution
{
    int getSize(Node head){
        Node temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        //System.out.println("size "+size);
        return size;
    }
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
        /*int size=getSize(head);
        if(n>size)
            return -1;
    	for(int i=0;i<size-n;i++){
    	    head=head.next;
    	}
    	return head.data;*/
    	int count=0;
    	Node slowPtr,fastPtr;
    	slowPtr=fastPtr=head;
    	while(count<n){
    	    if(head==null || fastPtr==null)
    	        return -1;
    	    else{
    	        fastPtr=fastPtr.next;
    	        count++;
    	    }
    	}
    	while(fastPtr!=null){
    	    slowPtr=slowPtr.next;
    	    fastPtr=fastPtr.next;
    	}
    	return slowPtr.data;
    }
}
	
public class NthNodeFromEndOfLinkedList
{
    Node head;  
	Node tail;
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	  
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			int k = sc.nextInt();
			NthNodeFromEndOfLinkedList llist = new NthNodeFromEndOfLinkedList();
			
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
        
        Solution g = new Solution();
		System.out.println(g.getNthFromLast(llist.head,k));
		
			t--;
		}
	}
}
