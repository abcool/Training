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
    //Check for null list
    public static boolean isNodeNull(Node n){
       // Node n = (Node) a;
       // System.out.println("isNodeNull= " +n);
        boolean flag = false;
        if( n==null || n.getNext()==null){
            flag = true;
        }
        return flag;
    }
    
    // Insert at beginning
    public static Node insertAtBegin(int val, Node n){
        Node head = n;
        Node newNode = new Node (val);
        if(isNodeNull(n)==true){
            newNode.setNext(newNode);
            return newNode;
        }else{
            newNode.setNext(n);
            while(n.getNext()!=head){
                n=n.getNext();
            }
            n.setNext(newNode);
            head=newNode;
        }
        return head;
    }
    
    //Insert at newNode
    public static Node insertAtEnd(int val, Node n){
        Node head=n;
        Node newNode = new Node(val);
       if(isNodeNull(n)==true){
           newNode.setNext(newNode);
           return newNode;
       }else{
           while(n.getNext()!=head){
               n=n.getNext();
           }
           n.setNext(newNode);
           newNode.setNext(head);
       }
       return head;
    }
    
    //Delete At beginning
    public static Node deleteAtBegin(Node n){
        if(isNodeNull(n)==true){
            return n;
        }
        Node head = n;
        
        while(n.getNext()!=head){
            n=n.getNext();
        }
        head = head.getNext();
        n.setNext(head);
        return head;
    }
    
    //Delete At end
    public static Node deleteAtEnd(Node n){
       // System.out.println(n);
        Node head = n; Node p=n;
        if(isNodeNull(n)==true || n.getNext()==n){
            //n= deleteAtBegin(n);
            n.setNext(null);
            n.setData(0);
            return n;
        }
        while(n.getNext()!=head){
            p=p.getNext();
            n=p.getNext();
        }
        n.setNext(null);
        p.setNext(head);
        return head;
    }
	//Delete first occurence of a value
	public static Node delelteValue(int val,Node n){
		Node head,p;
		head=p=n;
		if(n.getData()==val){
		    n= deleteAtBegin(n);
		    return n;
		}
		while((n=p.getNext())!=head){
		    if(n.getData()==val){
		        p.setNext(n.getNext());
		        n=null;
		        return head;
		    }
		        p=n;
		    
		}
		if(n.getData()==val && n.getNext()==head){
		    p.setNext(head);
		    n=null;
		    return head;
		}
		return head;
	}
	
	//Insert value at a given position
	public static Node insertAtPos(int val,int pos,Node n){
		Node head,p;
		head=p=n;
		Node newNode = new Node(val);
		if(pos==1){
		    n= insertAtBegin(val,n);
		    return n;
		}
		
		for(int i=1;i<pos-1;i++){
		    p = p.getNext();
		}
		n=p.getNext();
		p.setNext(newNode);
		newNode.setNext(n);
		return head;
	}
	
	//Print the linked list
	public static void printList(Node n){
	    Node head=n;
	    if(isNodeNull(n)==true){
	        System.out.println("NULL");
	        return;
	    }
	    while(n.getNext()!=head){
	        System.out.print("| "+n.getData()+" |->");
	        n=n.getNext();
	    }
	    if(n.getNext()==head)
	        System.out.print("| "+n.getData()+" |->");
	    
	    System.out.println("| head | " + head.getData() + "|");
	}
	
	//Count the number of elements in linked list
	public static int listCount(Node n){
		Node head=n;
		if(isNodeNull(n)==true){
		    return 0;
		}
		    int count=0;
		    while(n.getNext()!=head){
		        count++;
		        n=n.getNext();
		    }
		    if(n.getNext()==head)
		        count++;
		    return count;
	}
	
	//Delete a node at a specified position
	public static Node deleteAtPos(int pos,Node n){
	    if(pos==1){
	        n=deleteAtBegin(n);
	        return n;
	    }
	    if(pos==listCount(n)){
	        n = deleteAtEnd(n);
	        return n;
	    }
	    Node p,head;
	    p=head=n;
	    for(int i=1;i<pos-1;i++){
	        p=p.getNext();
	    }
	    n=p.getNext();
	    p.setNext(n.getNext());
	    return head;
	}
	
	// Print list as string
	public static String listAsString(Node n){
		String str="";
		Node head=n;
		if(isNodeNull(n)==true){
		    str+="NULL";
		}
		
		while(n.getNext()!=head){
		    str+=" |"+String.valueOf(n.getData())+" |->";
		    n=n.getNext();
		}
		if(n.getNext()==head)
		    str+="| "+String.valueOf(n.getData())+" |->";
		str+="| head |" + String.valueOf(head.getData()) + "|";
		return str;
	}
	
	// Position of first value equal to a given value
	public static int firstMatch(int val,Node n){
		Node head=n;
		boolean found = false;
		int pos=1;
		if(n.getData()==val && pos==1){
		    found = true;
		    return pos;
		}
		while(n.getNext()!=head){
		    if(n.getData()==val){
		        found=true;
		        return pos;
		    }
		    pos++;
		    n=n.getNext();
		}
		if(pos==listCount(n) && n.getData()==val){
		    found = true;
		    return pos;
		}
		if(found==false){
		    return 0;
		}
		return pos;
	}
    
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println("Circular Linked List program");
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
			System.out.println("11. Find the position of first matching value in list");
			System.out.println("12. Exit");
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
