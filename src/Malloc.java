import java.util.Arrays;

public class Malloc {
	
	private final char process = 'p';
	private final char hole = 'h';
	
	private int memSize = 25000;
	private byte mArr[] = new byte[memSize];
	private int used = 0;
	LinkedList l = new LinkedList();
	
	Malloc()
	{
		/* Initialize the whole memory block as a hole */
		l.add(memSize, hole);
//		System.out.println(Arrays.toString(mArr));
	}
	
	public Node myMalloc(int size)
	{
		Node mem = null;
		if(used<memSize)
		{
			Node bestFit = l.find(size);
//			System.out.printf("Best available memory hole address = %d\n", bestFit.start);
			
			for(int i=bestFit.start; i<size; i++)
			{
				mArr[i]=1;
				
			}
			
			mem = l.allocate(size, bestFit);
			
//			System.out.println(Arrays.toString(mArr));
//			System.out.println(bestFit.length);
		}
		else {
			System.out.println("Memory array Full");
		}
		used+=size;
		return mem;
	}
	
	public void myFree(Node ps)
	{
		if(ps.next!=null && ps.next.status==hole && ps.prev!=null && ps.prev.status==hole) {
			mergeNext(ps);
			mergePrev(ps);
		}
		else if(ps.next!=null && ps.next.status==hole)
			mergeNext(ps);
		else if(ps.prev!=null && ps.prev.status==hole)
			mergePrev(ps);
		else
			ps.status=hole;
		
//		System.out.println(Arrays.toString(mArr));
//		System.out.println(ps.start +" "+ ps.length);
	}
	
	public void mergeNext(Node ps)
	{
//		System.out.println("MergeNext called");
		if(ps.next!=null && ps.next.status==hole)
		{
			Node next = ps.next;
			
			next.start = ps.start;
			next.length = next.length + ps.length;
			if(ps.prev!=null) {
				next.prev=ps.prev ;
				ps.prev.next = next;
				ps.prev = null;
			}
			ps.next = null;
			if(ps==l.head) l.head = next;
		}
		
		
	}
	
	public void mergePrev(Node ps)
	{
//		System.out.println("MergePrev called");
		if(ps.prev!=null && ps.prev.status==hole)
		{
			Node prev = ps.prev;
			
			prev.length = prev.length + ps.length;
			if(ps.next!=null) {
				prev.next=ps.next;
				ps.next.prev = prev;
			}
			
			ps.next = null;
			ps.prev = null;
		}
		
		for(int i=ps.start; i<ps.length; i++)
		{
			mArr[i] = 0;
		}
	}
	
	public void printMemory()
	{
		l.printList();
	}
	
	public static void main (String args[])
	{
		Malloc m = new Malloc();
		m.printMemory();
		
		m.myMalloc(25000);
//		
		m.printMemory();
		
		m.myMalloc(25);
	}
}
