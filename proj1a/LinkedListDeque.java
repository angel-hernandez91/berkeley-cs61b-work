public class LinkedListDeque<Item> {
	
	private class Node<Item> {
		private Node prev;
		private Item item;
		private Node next;

		public Node(Node p, Item i, Node n){
			prev = p;
			item = i;
			next = n;
		}
	}

	private Node sentinel;
	private static int size = 0;

	public LinkedListDeque(Item x) {
		sentinel = new Node(null, x, null);
		sentinel.next = new Node(sentinel, x, sentinel);
		sentinel.prev = sentinel.next;

		size += 1;
	}

	public LinkedListDeque() {
		sentinel = new Node(null, null, null);
		size = 0;
	}

	public void addFirst(Item x){
		size += 1;
		sentinel.next = new Node(sentinel, x, sentinel.next);

		if (!this.isEmpty()) {
			sentinel.prev = sentinel.next;
		} else {
			sentinel.next.next.prev = sentinel.next;
		}
	 }

	public void addLast(Item x) {
		if (this.isEmpty()) {
			this.addFirst(x);
		} else {
			sentinel.prev.next = new Node(sentinel.prev, x, sentinel);
			sentinel.prev = sentinel.prev.next;
			size += 1;
		}
	}

	public boolean isEmpty(){
		return sentinel.next == null && sentinel.prev==null;
	}

	public int size() {
		return size;
	}

	public Item get(int index){
		if (this.isEmpty()) {
			return null;
		}
		Node<Item> p = sentinel.next;
		int j = 0;
		while(j < index){
			p = p.next;
			j++;
		}
		return p.item;
	}

	public void printDeque() {
		if (this.isEmpty()){
			return;
		}
		Node<Item> p = sentinel.next;
		int j = 0;
		while(j < size) {
			System.out.print(p.item + " ");
			p = p.next;
			j++;
		}
		System.out.println("");
	}

	public Item removeFirst() {
		if (this.isEmpty()) {
			return null;
		}	
		Node<Item> returnFirst = sentinel.next;
		sentinel.next.prev = null;
		sentinel.next = sentinel.next.next;
		try {
			sentinel.next.prev = sentinel;
		} catch (NullPointerException e) {
			sentinel.next = null;
			sentinel.prev = null;
		}
		returnFirst.next = null;
		size -=1;
		return returnFirst.item;
	}

	public Item removeLast() {
		if (this.isEmpty()) {
			return null;
		}
		Node<Item> returnLast = sentinel.prev;
		sentinel.prev.next = null;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;

		returnLast.prev = null;
		size -=1;
		if (this.size() == 0){
			sentinel.prev = null;
			sentinel.next = null;
		}
		return returnLast.item;
	}

	public Item recursiveGet(Node<Item> p, int index) {
		if (index == 0) {
			return p.item;
		} else {
			p = p.next;
			return recursiveGet(p, index - 1);
		}
	}

	public Item recursiveGet(int index){
		if (this.isEmpty()){
			return null;
		}
		Node<Item> p = sentinel.next;
		return recursiveGet(p, index);
	}

	public static void main(String[] args){
	 	LinkedListDeque<Integer> l = new LinkedListDeque<>();
	 }
}