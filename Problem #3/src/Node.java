public class Node
{
	public static final String SEPERATOR = ";";
	
	public String value;
	public Node left;
	public Node right;
	
	public Node(String value)
	{
		if (value.contains(SEPERATOR))
			throw new RuntimeException("';' is a reserved symbol and may not be used as node value!");
		this.value = value;
	}
	
	public Node(String value, Node left, Node right)
	{
		this(value);
		this.left = left;
		this.right = right;
	}
}