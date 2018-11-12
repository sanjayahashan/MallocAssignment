
public class Node <T> {
	public int start;
	public int length;
	public char status = 'h';
	public Node<T> next = null;
	public Node<T> prev = null;
	
	Node(int size, char status)
	{
		this.length = size;
		this.status = status;
	}
	
//	public static void main(String srgs[])
//	{
//		Node n = new Node(23);
//		System.out.println(n.data);
//	}
}
