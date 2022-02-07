/* 
We are given total possible page numbers that can be referred. We are also given cache (or memory) size (Number of page frames that cache can hold at a time). 
The LRU caching scheme is to remove the least recently used frame when the cache is full and a new page is referenced which is not there in cache.

When a page is referenced, the required page may be in the memory. If it is in the memory, we need to detach the node of the list and bring it to the front of the queue. 
If the required page is not in memory, we bring that in memory. 
In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. 
If the queue is full, i.e. all the frames are full, we remove a node from the rear of the queue, and add the new node to the front of the queue.

The idea is to use a LinkedHashSet that maintains insertion order of elements. This way implementation becomes short and easy.
*/
public class LRUCache2{
    Set<Integer> cache;
    int capacity;
 
    public LRUCache2(int capacity)
    {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }
 
    // This function returns false if value is not
    // present in cache. Else it moves the value to
    // front by first removing it and then adding
    // it, and returns true.
    public boolean isPresentInCache(int key){
        // if value not in cache
        if (!cache.contains(key))
            return false;
        //if value is there in cache, remove it and re-add it to move it to the front
        cache.remove(key);
        cache.add(key);
        return true;
    }
    // add value into the cache
     public void addToCache(int key){
      // if cache is full   
      if (cache.size() == capacity) {
            // remove least recently used value in cache
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        // add value to the cache
        cache.add(key);
    }
    /* Search for value in cache */
    public void inCache(int key)
    {       
        if (isPresentInCache(key) == false)
           addToCache(key);
    }
 
    // displays contents of cache in Reverse Order
    public void display()
    {
      LinkedList<Integer> list = new LinkedList<>(cache);
       
      // The descendingIterator() method of java.util.LinkedList
      // class is used to return an iterator over the elements
      // in this LinkedList in reverse sequential order
      Iterator<Integer> itr = list.descendingIterator();
       
      while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }  
   
     
    public static void main(String[] args)
    {
        LRUCache2 ca = new LRUCache2(4);
        ca.inCache(1);
        ca.inCache(2);
        ca.inCache(3);
        ca.inCache(1);
        ca.inCache(4);
        ca.inCache(5);
        ca.display();
    }
}
