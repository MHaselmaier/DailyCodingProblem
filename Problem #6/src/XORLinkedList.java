public class XORLinkedList<T>
{
	private Element head;
	
	@SuppressWarnings("unchecked")
	public void add(T value)
	{
		if (null == this.head)
		{
			this.head = new Element(value);
			return;
		}
		
		int previousPointer = 0;
		int nextPointer;
		Element current = this.head;
		while (null != current)
		{
			nextPointer = current.link ^ previousPointer;
			previousPointer = Problem.get_pointer(current);
			current = (Element)Problem.dereference_pointer(nextPointer);
		}
		
		current = (Element)Problem.dereference_pointer(previousPointer);
		current.link ^= Problem.get_pointer(new Element(value, previousPointer));
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index)
	{
		if (0 > index)
			throw new IndexOutOfBoundsException();
		
		int previousPointer = 0;
		int nextPointer;
		Element current = this.head;
		for (int i = 0; index > i; ++i)
		{
			nextPointer = current.link ^ previousPointer;
			previousPointer = Problem.get_pointer(current);
			current = (Element)Problem.dereference_pointer(nextPointer);
			if (null == current)
				throw new IndexOutOfBoundsException();
		}
		
		if (null == current)
			throw new IndexOutOfBoundsException();
		
		return current.value;
	}
	
	private class Element
	{
		public T value;
		public int link;
		
		public Element(T value)
		{
			this.value = value;
			Problem.get_pointer(this);
		}
		
		public Element(T value, int previous)
		{
			this(value);
			this.link = previous;
		}
	}
}