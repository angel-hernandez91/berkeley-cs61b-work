public class ArrayDeque<Item> {
	private Item[] iArray;
	private int size;
	private int nextFirst;
	private int nextLast;
	private int origFirst = 4;
	private int origLast = 5;
	private int modFirst;
	private int modLast;
	private int firstPointer;
	private int lastPointer;
	private int endF = 0;
	private int endL = 7;
	private int defaultLength = 8;
	private double UFACTOR = 0.25;
	private static int RFACTOR = 2;

	public ArrayDeque(){
		iArray = (Item[]) new Object[defaultLength];
		nextFirst = origFirst;
		nextLast = origLast;
		size = 0;
	}

	private void resize(int capacity) {
		Item[] tempArray = (Item[]) new Object[capacity];
		System.arraycopy(iArray, 0, tempArray, 0, size);
		iArray = tempArray;
		if (currentUsage() != 0.25){
			endF = size;
			endL = endL + size
			nextFirst = origFirst + size;
			nextLast = nextFirst + 1;
			modFirst = nextFirst;
			modLast = nextLast;
		} else {
			endF = capacity;
			endL = endL - capacity;
			if (capacity/2==4){
				nextFirst = origFirst;
				nextLast = origLast;
			}else{
				nextFirst = modFirst - capacity/2;
				nextLast = nextFirst + 1;
			}
		}
	}

	private double currentUsage() {
		return (double)size/iArray.length;
	}

	public void addFirst(Item x) {
		
		if (size == iArray.length) {
			resize(size * RFACTOR);

		}
		iArray[nextFirst] = x;
		System.out.println(nextFirst + " " + iArray[nextFirst]);
		size += 1;
		firstPointer = nextFirst;
		nextFirst -= 1;
		if (nextFirst < endF){

			nextFirst = endL;
		}

	}

	public void addLast(Item x) {
		if (size == iArray.length) {
			resize(size* RFACTOR);
		}
		iArray[nextLast] = x;
		System.out.println(nextLast + " " + iArray[nextLast]);
		size += 1;
		lastPointer = nextLast;
		nextLast += 1;
		if (nextLast > endL) {
			nextLast = endF;
		}
	}

	public boolean isEmpty(){
		Item[] emptyArray = (Item[]) new Object[iArray.length];
		for (int i=0; i < iArray.length; i ++){
			if(iArray[i] != emptyArray[i]) {
				return false;
			}
		}
		return true;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		if (this.isEmpty()){
			return;
		}
		for (int i=0; i < iArray.length; i++){
			if (iArray[i]==null){
				continue;
			}
			else {
				System.out.print(iArray[i] + " ");
			}
		}
		System.out.println();
	}

	public Item removeFirst() {
		if (this.isEmpty()){
			return null;
		}

		Item first = iArray[firstPointer];
		iArray[firstPointer] = null;
		size -= 1;
		firstPointer += 1;
		if (currentUsage() == UFACTOR) {
			resize(iArray.length/2);
		}
		return first;
	}

	public Item removeLast() {
		if (this.isEmpty()) {
			return null;
		}
		Item last = iArray[lastPointer];
		iArray[lastPointer] = null;
		size -=1;
		lastPointer -=1;
		if (currentUsage() == UFACTOR) {
			resize(iArray.length/2);
		}
		return last;
	}

	public Item get(int index) {
		return iArray[index];
	}

	public static void main(String[] args) {
		ArrayDeque<Integer> a = new ArrayDeque<>();
		a.addFirst(0);
		a.addLast(1);
		a.addFirst(2);
		a.addLast(3);
		a.addFirst(4);
		a.addLast(5);
		a.addFirst(6);
		a.addLast(7);
		a.addFirst(8);
		a.addLast(9);
		a.addFirst(10);
		a.addFirst(0);
		a.addLast(1);
		a.addFirst(2);
		a.addLast(3);
		a.addFirst(4);
		a.addLast(5);
		a.addFirst(6);
		a.addLast(7);
		a.addFirst(8);
		a.addLast(9);
		a.addFirst(10);
		a.printDeque();
	}

}
