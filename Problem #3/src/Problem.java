import java.util.ArrayList;
import java.util.List;

public class Problem
{
	public static String serialize(Node root)
	{
		if (null == root) return Node.SEPERATOR;
		
		String serialized = root.value + Node.SEPERATOR;
		serialized += serialize(root.left);
		serialized += serialize(root.right);
		
		return serialized;
	}
	
	public static Node deserialize(String serialized)
	{
		List<String> values = new ArrayList<>();
		for (String value: serialized.split(Node.SEPERATOR, -1))
			values.add(value);
		
		return deserialize(values);
	}
	
	private static Node deserialize(List<String> values)
	{
		String value = values.remove(0);
		
		if (value.isEmpty()) return null;
		
		Node node = new Node(value);
		node.left = deserialize(values);
		node.right = deserialize(values);
		
		return node;
	}
}