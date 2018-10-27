public class AList<Item> {
 		private Item[] items;
 		private int size;
 		private static int RFACTOR = 2;
    /** Creates an empty list. */
    public AList() {
    	items = (Item[]) new Object[100];
    	size = 0;
    	    }

   	public void resize(int capacity) {
   		Item[] a = (Item[]) new Object[capacity];
   		System.arraycopy(items, 0, a, 0, size);
   		items = a;
   	}



    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
    	if (size == items.length) {
    		resize(size * RFACTOR);
    	}
    	items[size] = x;
    	size += 1;
    }

    /** Returns the items from the back of the list. */
    public Item getLast() {
   		return items[size -1];             
    }
    /** Gets the ith items in the list (0 is the front). */
    public Item get(int i) {
        return items[i];        
    }

    /** Returns the number of itemss in the list. */
    public int size() {
        return size;        
    }

    /** Deletes items from back of the list and
      * returns deleted items. */
    public Item removeLast() {  	
    	Item last = getLast();
    	size -= 1;
        return last;
    }
} 


// generic arrays are not possible, well yes, but synatix is different
// item = (Item []) new Object[8]
// null after destroying -- especially for objects
// resize depending on usage

