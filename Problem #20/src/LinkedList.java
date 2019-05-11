public class LinkedList<T>
{
	public T value;
	public LinkedList<T> next;
	
	public LinkedList(T value)
	{
		this(value, null);
	}
	
	public LinkedList(T value, LinkedList<T> next)
	{
		this.value = value;
		this.next = next;
	}
}