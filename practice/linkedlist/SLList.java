public class SLList {

	//never looks outwards -- private since user does not need to know about intnode
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}


	}	
	//The first item if it exists is at sentinel.next
	private IntNode sentinel;
	//cache the size on the fly
	private static int size = 0;

	//better constructor -- new lists are defined as:
	// SLLlist list = new IntNode(5);
	public SLList(int x) {
		sentinel = new IntNode(0, null);
		sentinel.next = new IntNode(x, null);
		size += 1;
	}

	//The empty list
	public SLList () {
		sentinel = new IntNode(0, null);
		size = 0;
	}
	/** adds x to the front of the list */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}

	public void addLast(int x) {
		size += 1;
		IntNode p = sentinel;
		while(p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		
		
	}

	/** returns first item in the list */
	public int getFirst() {
		return sentinel.next.item;
	}

	//This implementation of size is not efficient. We need to do better;
	// private static int size(IntNode p) {
	// 	if (p.next == null) {
	// 		return 1;
	// 	} else {
	// 		return 1 + size(p.next);
	
	// 	}
	// }

	// public int size() {
	// 	return size(first);
	// }

	// public int iterSize() {
	// 	IntNode p = first;
	// 	int count = 0;
	// 	while(p != null) {
	// 		count++;
	// 		p = p.next;
	// 	}
	// 	return count;
	// }

	public IntNode recusiveAddLast(IntNode p, int x) {
		if (p.next == null) {
			p.next = new IntNode(x, null);
			return p;
		} else {
			return recusiveAddLast(p.next, x);
		}
	}

	public void recAddLast(int x){
		size += 1;
		recusiveAddLast(sentinel, x);
	}
		

	public int get(IntNode p, int i) {
		if (i == 0) {
			return p.item;
		} else {
			return get(p.next, i-1);
		}
	}

	public int get(int i) {
		return get(sentinel.next, i);
	}

	public static void main(String[] args) {
		SLList l = new SLList(10);
		l.addFirst(5);
		l.addFirst(2);
		l.addFirst(399);

		l.addLast(1);
		l.recAddLast(4);
		// System.out.println(l.iterSize());
		// System.out.println(l.size());
		System.out.println(l.get(Integer.parseInt(args[0])));
		System.out.println(l.size);
	}
}