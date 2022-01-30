/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

 class Node{
    private int data;
    private Node next;
    
    Node(int data){
        this.data=data;
        this.next=null;
    }
    
    public void setData(int data){
        this.data=data;
    }
    
    public int getData(){
        return data;
    }
    
    public void setNext(Node next){
        this.next=next;
    }
    
    public Node getNext(){
        return next;
    }
}

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    // Insert at beginning
    public static Node insertAtBegin(int val, Node n){
        Node head = n;
        Node newNode = new Node (val);
        newNode.setNext(head);
        n=newNode;
        return n;
    }
    
    //Insert at newNode
    public static Node insertAtEnd(int val, Node n){
        Node p1=n;
        Node newNode = new Node(val);
        while(p1.getNext()!=null){
            p1=p1.getNext();
        }
        p1.setNext(newNode);
        return n;
    }
    
    //Delete At beginning
    public static Node deleteAtBegin(Node n){
        Node h=n;
        n=n.getNext();
        h.setNext(null);
        h.setData(0);
        return n;
    }
    
    //Delete At end
    public static Node deleteAtEnd(Node n){
        Node p1,p2;
        p1=p2=n;
        while(p2.getNext()!=null){
			p1=p1.getNext();
			p2=p1.getNext();
		}
		p2=null;
		p1.setNext(null);
		return n;
    }
	//Delete first occurence of a value
	public static Node delelteValue(int val,Node n){
		Node p1,p2;
		p1=p2=n;
		boolean found = false;
		while(p2!=null){
			if(p2.getData()==val){
			    p1.setNext(p2.getNext());
				p2=null;
				found=true;
				break;
			}
			p1=p1.getNext();
			p2=p1.getNext();
		}
		if(found!=true)
			System.out.println(val + "not found in list");
		else
			System.out.println(val + "deleted from the list");
		return n;
	}
	
	//Insert value at a given position
	public static Node insertAtPos(int val,int pos,Node n){
		Node newNode = new Node(val);
		Node p1,p2;
		p1=p2=n;
		for(int i=1;i<pos-1;i++){
			p1=p1.getNext();
		}
			p2=p1.getNext();
			p1.setNext(newNode);
			newNode.setNext(p2);
			return n;
	}
	
	//Print the linked list
	public static void printList(Node n){
		while(n!=null){
			System.out.print("| " + n.getData() + " |->");
			n=n.getNext();
		}
		System.out.println("NULL");
	}
	
	//Count the number of elements in linked list
	public static int listCount(Node n){
		int count=0;
		while(n!=null){
			count++;
			n=n.getNext();
		}
		return count;
	}
	
	//Delete a node at a specified position
	public static Node deleteAtPos(int pos,Node n){
		Node p1,p2;
		p1=p2=n;
		for(int i=1;i<pos-1;i++){
			p1=p1.getNext();
		}
		p2=p1.getNext();
		p1.setNext(p2.getNext());
		p2=null;
		return n;
	}
	
	// Print list as string
	public static String listAsString(Node n){
		String str="";
		while(n!=null){
			str+=String.valueOf(n.getData());
			str+="->";
			n=n.getNext();
		}
		str+="NULL";
		return str;
	}
	
	// Position of first value equal to a given value
	public static int firstMatch(int val,Node n){
		int pos=0;
		boolean found=false;
		while(n!=null){
			if(n.getData()==val){
				found=true;
				pos++;
				break;
			}
			pos++;
			n=n.getNext();
		}
		if(found==true){
			return pos;
		}else{
			return 0;
		}
	}
    
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println("Linked List program");
		System.out.println("Coded by Arvind Bakshi");
		Node n=null;
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int choice,val,pos;
		while(flag==true){
			System.out.println("Enter choice");
			System.out.println("1. Insert at beginning");
			System.out.println("2. Insert at end");
			System.out.println("3. Delete at beginning");
			System.out.println("4. Delete from end");
			System.out.println("5. Delete a value in list");
			System.out.println("6. Insert at a position");
			System.out.println("7. Print the list");
			System.out.println("8. Get the count of the list");
			System.out.println("9. Delete value at a given position");
			System.out.println("10. Return string representation of the list");
			System.out.println("11. Find the positio of first matching value in list");
			System.out.println("12. Linked List program exit");
			choice = scan.nextInt();
			switch(choice){
				case 1:
					  System.out.println("Enter value");
					   val = scan.nextInt();
					  n = insertAtBegin(val,n);
					  break;
				case 2:
					  System.out.println("Enter a value");
					  val = scan.nextInt();
					  n = insertAtEnd(val,n);
					  break;
				case 3:
					  n=deleteAtBegin(n);
					  break;
				case 4:
					  n = deleteAtEnd(n);
					  break;
				case 5:
					  System.out.println("Enter the value to be deleted");
					  val = scan.nextInt();
					  n=delelteValue(val,n);
					  break;
				case 6:
					  System.out.println("Enter a value");
					  val = scan.nextInt();
					  System.out.println("Enter position to be inserted");
					  pos = scan.nextInt();
					  n = insertAtPos(val,pos,n);
					  break;
				case 7:
					   printList(n);
					   break;
				case 8:
					   System.out.println("List contains " + listCount(n) + " elements");
					   break;
				case 9:
					   System.out.println("Enter the position");
					   pos = scan.nextInt();
					   n = deleteAtPos(pos,n);
					   break;
				case 10:
						System.out.println("Linked List as string: "+ listAsString(n));
						break;
				case 11:
						System.out.println("Enter a value");
						val = scan.nextInt();
						int p=firstMatch(val,n);
						if(p>0)
						    System.out.println("Element " + val + " found at position "+p);
						else
						    System.out.println("Element not in list");
						break;
				case 12:
						flag = false;
						break;
				default:
						System.out.println("Wrong choice selected. Select from given list only. Try again!");
			}
		}
		scan.close();
		
	}
}
