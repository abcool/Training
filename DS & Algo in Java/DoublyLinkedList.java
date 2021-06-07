/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
	private int data;
	private Node next,prev;
	
	public Node(int data){
		this.data=data;
		this.prev=null;
		this.next=null;
	}
	
	public void setNext(Node next){
		this.next=next;
	}
	public Node getNext(){
		return next;
	}
	public void setData(int data){
		this.data=data;
	}
	public int getData(){
		return data;
	}
	public void setPrev(Node prev){
		this.prev=prev;
	}
	public Node getPrev(){
		return prev;
	}
}
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Node n=null;
		Scanner scan = new Scanner(System.in);
		boolean flag=true;
		int choice,val,pos;
		while(flag==true){
			System.out.println("Enter a choice: ");
			System.out.println("1. Insert at beginning ");
			System.out.println("2. Insert at end ");
			System.out.println("3. Delete at beginning ");
			System.out.println("4. Delete at end ");
			System.out.println("5. Delete a given value ");
			System.out.println("6. Insert at a given position ");
			System.out.println("7. Delete at a given position ");
			System.out.println("8. Get count of list ");
			System.out.println("9. Print the list ");
			System.out.println("10. Return the string representation of list ");
			System.out.println("11. Find the first position of value equal to a given value ");
			System.out.println("12. Exit ");
			choice = scan.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter a value");
					val = scan.nextInt();
					n=insertAtBegin(n,val);
					break;
				case 2:
					System.out.println("Enter a value");
					val = scan.nextInt();
					n = insertAtEnd(n,val);
					break;
				case 3:
					n = delAtBegin(n);
					break;
				case 4:
					n = delAtEnd(n);
					break;
				case 5:
					System.out.println("Enter value to be deleted");
					val = scan.nextInt();
					n = deleteValue(n,val);
					break;
				case 6:
					System.out.println("Enter a value");
					val = scan.nextInt();
					System.out.println("Enter the position");
					pos = scan.nextInt();
					n = insertAtPos(n,val,pos);
					break;
				case 7:
					System.out.println("Enter the position");
					pos = scan.nextInt();
					n = deleteAtPos(n,pos);
					break;
				case 8:
					System.out.println("List contains " + listCount(n) + " elements");
					break;
				case 9:
					printList(n);
					break;
				case 10:
					System.out.println("String representation of list ");
					listAsString(n);
					break;
				case 11:
					System.out.println("Enter a value");
					val = scan.nextInt();
					System.out.println("Element " + val + " found in list at position " + firstOccurence(n,val));
					break;
				case 12:
					flag = false;
					break;
				default:
					System.out.println("Invalid choice entered, please try again");
			}
		}
		
	}
	
	//Insert at beginning
	public static Node insertAtBegin(Node n, int val){
	    Node head = n;
	    Node newNode = new Node(val);
		newNode.setNext(head);
		if(head!=null)
		    head.setPrev(newNode);
		n=newNode;
		return n;
	}
	
	//Insert at end
	public static Node insertAtEnd(Node n, int val){
	    if(n==null){
	        n = insertAtBegin(n,val);
	        return n;
	    }
		Node newNode = new Node(val);
		Node p = n;
		while(p.getNext()!=null){
			p=p.getNext();
		}
		p.setNext(newNode);
		newNode.setPrev(p);
		return n;
	}
	
	//Delete at beginning
	public static Node delAtBegin(Node n){
		Node head = n;
		if(head.getNext()!=null){
		head = head.getNext();
		head.setPrev(null);
		n.setNext(null);
		}else{
		    head=null;
		}
		return head;
	}
	
	//Delete at end
	public static Node delAtEnd(Node n){
	    if(n.getNext()==null || n==null){
	        n = delAtBegin(n);
	        return n;
	    }
		Node p = n;
		while(p.getNext()!=null){
			p=p.getNext();
		}
		p.getPrev().setNext(null);
		p.setPrev(null);
		return n;
	}
	
	//Delete a given value
	public static Node deleteValue(Node n, int val){
		Node p = n;
		//boolean found = false;
		while(p!=null){
			if(p.getData()==val){
				if(p.getPrev()==null){
				    n = delAtBegin(n);
				    break;
				}else if(p.getNext()==null){
				    n = delAtEnd(n);
				    break;
				}else{
				    p.getPrev().setNext(p.getNext());
				    p.getNext().setPrev(p.getPrev());
				    p.setPrev(null);
				    p.setNext(null);
				    break;
				}
			}
			p = p.getNext();
		}
		return n;
	}
	
	//Insert at a given position
	public static Node insertAtPos(Node n, int val, int pos){
		Node p = n;
		for(int i=1;i<pos;i++){
			p=p.getNext();
		}
		if(p!=null){
		if(p.getPrev()==null){
			n=insertAtBegin(n,val);
			return n;
		}
		if(p.getNext()==null){
			n = insertAtEnd(n,val);
			return n;
		}
		Node newNode = new Node(val);
		newNode.setPrev(p.getPrev());
		p.getPrev().setNext(newNode);
		newNode.setNext(p);
		p.setPrev(newNode);
		return n;
		}else{
		    n = insertAtEnd(n,val);
			return n;
		}
	}
	
	//Delete value at a given position
	public static Node deleteAtPos(Node n, int pos){
		Node p = n;
		for(int i=1;i<pos;i++){
			p = p.getNext();
		}
		if(p.getPrev()==null){
			n = delAtBegin(n);
			return n;
		}
		if(p.getNext()==null){
			n = delAtEnd(n);
			return n;
		}
		p.getPrev().setNext(p.getNext());
		p.getNext().setPrev(p.getPrev());
		p.setNext(null);
		p.setPrev(null);
		return n;
	}
	
	//Count number of elements in the list
	public static int listCount(Node n){
		int c=0;
		while(n!=null){
			c++;
			n = n.getNext();
		}
		return c;
	}
	
	//Print the doubly linked list
	public static void printList(Node n){
		while(n!=null){
			System.out.print("| " + n.getData() + " |->");
			n= n.getNext();
		}
		System.out.println("NULL");
	}
	
	//Print linked list as string
	public static void listAsString(Node n){
		String str="";
		while(n!=null){
			str+="| ";
			str+=String.valueOf(n.getData());
			str+=" |->";
			n = n.getNext();
		}
		str+=" NULL";
		System.out.println(str);
	}
	
	//Find first occurence of value in the list
	public static int firstOccurence(Node n, int val){
		int pos = 0;
		boolean found = false;
		while(n!=null){
			if(n.getData()==val){
				pos++;
				found = true;
				break;
			}
			pos++;
			n= n.getNext();
		}
		if(found == true){
			return pos;
		}else{
			return 0;
		}
	}
	
}
