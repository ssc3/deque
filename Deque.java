import java.util.*;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
        Node prev;
    }
    
    private Node first;
    private Node last;
    
    public Deque() {                     // construct an empty deque
        first = null;
        last = null;
    }
        
    public boolean isEmpty() {           // is the deque empty?
        return first == null;
    }
    
    public int size() {                  // return the number of items on the deque
        int count = 1;
        
        if (first == null) {
            return 0;
        }
        
        Node temp_node = first;
       /* while (temp_node.next != null) {
            count++;
            temp_node = temp_node.next;
        }*/
        
        ListIterator iter = new ListIterator();
        
        while (iter.hasNext()) {
            count++;

        }
        return count;
    }
            
    public void addFirst(Item item) {    // insert the item at the front
        if (item == null) {
            throw new java.lang.NullPointerException("NULL Object in addFirst");
        }
        
        if (size() == 0) {
            first = new Node();
            first.item = item;
            first.next = null;
            first.prev = null;
            
            last = first;
        }
        else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            first.prev = null;
            oldfirst.prev = first;
        }
    }
                
    public void addLast(Item item) {     // insert the item at the end
        if (item == null) {
            throw new java.lang.NullPointerException("NULL object in addLast");
        }
        
         if (size() == 0) {
            last = new Node();
            last.item = item;
            first.next = null;
            first.prev = null;
            
            first = last;
        }
         else {
             Node oldlast = last;
             last.item = item;
             last.next = null;
             last.prev = oldlast;
             oldlast.next = last;
         }
    }
        
    public Item removeFirst() {          // delete and return the item at the front
        if (isEmpty()) {
            throw new java.lang.UnsupportedOperationException("Removing empty first");
        }
        
        if (size() == 1)
            return first.item;
        
        Node oldfirst = first;
        first = oldfirst.next;
        first.prev = null;
        
        oldfirst.next = null;
        return oldfirst.item;
    }
        
        
        
    public Item removeLast() {          // delete and return the item at the end
        if(isEmpty()) {
            throw new java.lang.UnsupportedOperationException("Removing empty last");
        }
        
        if (size() == 1) {
            return first.item;
        }
        
        Node oldlast = last;
        last = oldlast.prev;
        last.next = null;
        
        oldlast.prev = null;
        return oldlast.item;
    }
    
    public Iterator<Item> iterator() {   // return an iterator over items in order from front to end
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            
            current = current.next;
            return current != null;
            
        }
        
        public void remove() {
            /* Not supported*/
        }
        
        public Item next() {
            if (current == null) {
                throw new java.util.NoSuchElementException("Next is null");
            }
            
            Item item = current.item;
            
            current = current.next;
            return item;
        }
    }
}
