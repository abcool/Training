/**
@author: Arvind Bakshi
Remove all duplicates in a linked list
*/
import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution
{

    public static Node removeDuplicates(Node head) {
      //Write your code here
      // -|previous ptr=head|---->|currPtr|-->null
      // -|head|-->|node 1|->|previousPtr/Node 2|->|currPtr/Node 3|-->null
        Node previousPtr = head;
        Node currPtr = previousPtr.next;
        List<Integer> list = new ArrayList<Integer>();
        list.add(head.data);
        while(currPtr!=null){
            if(list.contains(currPtr.data)){
                if(currPtr.next==null){
                    previousPtr.next=null;
                    break;
                }else{
                    previousPtr.next=currPtr.next;
                    currPtr=previousPtr.next;
                    continue;
                }
            }else{
                list.add(currPtr.data);               
            }
            previousPtr = previousPtr.next;
            currPtr=previousPtr.next;
        }
        return head;
    }

	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }
