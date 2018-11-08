
public class Node <T> {
	public T data;
	public Node<T> next = null;
	public Node<T> prev = null;
	
	Node(T data)
	{
		this.data = data;
	}
	
//	public static void main(String srgs[])
//	{
//		Node n = new Node(23);
//		System.out.println(n.data);
//	}
}
