/*  
We are given total possible page numbers that can be referred. We are also given cache (or memory) size (Number of page frames that cache can hold at a time). 
The LRU caching scheme is to remove the least recently used frame when the cache is full and a new page is referenced which is not there in cache.

We use two data structures to implement an LRU Cache.  

Queue which is implemented using a doubly linked list. The maximum size of the queue will be equal to the total number of frames available (cache size). 
The most recently used pages will be near front end and least recently pages(values) will be near the rear end.
A Hash with page number as key and address of the corresponding queue node as value.

When a page is referenced, the required page may be in the memory. If it is in the memory, we need to detach the node of the list and bring it to the front of the queue. 
If the required page is not in memory, we bring that in memory. 
In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. 
If the queue is full, i.e. all the frames are full, we remove a node from the rear of the queue, and add the new node to the front of the queue.

*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class LRUCache1
{
    // store the actual values in the cache
    private Deque<Integer> doublyQueue;
    // store references of the values in cache, used to check if value is there in cache
    private HashSet<Integer> set;
    //cache size
    private final int CACHE_SIZE;
    
    public Codechef(int capacity){
        doublyQueue = new LinkedList<>();
        set = new HashSet<>();
        CACHE_SIZE = capacity;
    }
    // find value in cache
    public void inCache(int value){
        // if value not in cache
        if(!set.contains(value)){
            //if cache is full
            if(doublyQueue.size()==CACHE_SIZE){
                //remove actual value from last of the deque and assign it to variable last
                int last = doublyQueue.removeLast();
                //remove the reference of value from set
                set.remove(last);
            }
        }
        // if value already exists in cache, remove it as it needs to be moved to front
        else{
            doublyQueue.remove(value);
        }
        // add value to the front of deque irrespective of whether it is there in cache or not
        doublyQueue.push(value);
        // add its reference in set
        set.add(value);
    }
  // display contents of the cache
    public void display(){
        Iterator<Integer> itr = doublyQueue.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		LRUCache1 cache = new LRUCache1(4);
		cache.inCache(1);
		cache.inCache(2);
		cache.inCache(3);
		cache.inCache(4);
		cache.display();
		cache.inCache(0);
		cache.inCache(5);
		cache.display();
	}
}
