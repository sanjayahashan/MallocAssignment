public class Malloc {

	private static byte mArr[] = new byte[25000];
	LinkedList l = new LinkedList();
	
	public static int myMalloc(int size)
	{
		for(int i=0; i<mArr.length; i++)
		{
//			if(mArr[i]==)
			System.out.println(mArr[i]);
		}
		return 0;
	}
	
	public static void main (String args[])
	{
		myMalloc(35);
	}
}
