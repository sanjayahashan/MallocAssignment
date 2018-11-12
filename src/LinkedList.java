
public class LinkedList <T>{
	
	Node head = null;
	public int size = 0;
	
	public void add(int data_size, char status)
	{
		Node temp = new Node(data_size, status);
		temp.start = 0;
		head = temp;
		size += 1;
	}
	
	public Boolean isEmpty()
	{
		return size==0;
	}
	
	public void add(int data_size, Node n, char status)
	{
		Node temp = new Node(data_size, status);
		temp.next = n.next;
		temp.prev = n;
		n.next.prev = temp;
		
		/* set starting address of next node of n */
//		n.next.start = temp;
		
		/*calculate the current starting address*/
		temp.start = n.start + n.length;
		
		n.next = temp;
		
		size +=1;
	}
	
	public Node<T> find(int size)
	{
		Node best = new Node(Integer.MAX_VALUE,'h');
		Node pointer = head;
		while(pointer!=null)
		{
			int len = pointer.length;
			if(pointer.status=='h' && size<=len && len<best.length)
			{
				best = pointer;
//				System.out.println("pointer changed");
				System.out.println("Best fit length : " + best.length);
			}
			pointer = pointer.next;
		}
		System.out.println("Best Fit memory hole address :" + best.start);
		return best;
	}
	
	public Node allocate(int data_size, Node n)
	{
		if(data_size==n.length) {
			n.status = 'p';
			return n;
		}
		else {
			//Create a new node containing process for the given size
			Node temp = new Node(data_size, 'p');
			
			//Set starting address of the temp node
			temp.start = n.start;
			
			//Set starting address of the current node(n)
			n.start = temp.start + temp.length;
			
			//calculate and set the length of the current node(n)
			n.length = n.length - data_size;
			
			//Set next and prev of the temp and current node 
			temp.next = n;
			if(n.prev!=null) {
				temp.prev = n.prev;
				n.prev.next = temp;
			}
			
			if(n==head) head=temp;
			n.prev = temp;
			
			return temp;
		}
	}
	
	public void printList()
	{
		Node pointer = this.head;
		while(pointer!=null)
		{
			System.out.printf("Starting address : %d\nLength : %d:\nStatus : %c\n\n", pointer.start, pointer.length, pointer.status);
			pointer = pointer.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		
//		System.out.println(l.head);
//		System.out.println(l.head.data);
		
		l.add(50,'p');
		l.add(12, 'p');
		
//		System.out.println(l.head);
//		System.out.println(l.head.start);
//		System.out.println(l.head.next);
		
		l.printList();
	}

}
