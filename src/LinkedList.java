
public class LinkedList <T>{
	
	Node head = null;
	int size = 0;
	
	public void add(T data)
	{
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		size += 1;
	}
	
	public void add(T data, Node n)
	{
		Node temp = new Node(data);
		temp.next = n.next;
		temp.prev = n;
		n.next.prev = temp;
		n.next = temp;
		size +=1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		
//		System.out.println(l.head);
//		System.out.println(l.head.data);
		
		l.add(50);
		
		System.out.println(l.head);
		System.out.println(l.head.data);
		System.out.println(l.head.next);
	}

}
