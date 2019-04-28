public class Problem
{
	public static int countUnivalSubtrees(Node<?> root)
	{
		// using an array with size 1 as output parameter
		int[] totalCount = new int[1];
		countUnivalSubtrees(root, totalCount);
		return totalCount[0];
	}
	
	private static boolean countUnivalSubtrees(Node<?> root, int[] totalCount)
	{
		if (null == root)
			return false;
		if (null == root.left && null == root.right)
		{
			++totalCount[0];
			return true;
		}
		
		boolean isUnival = true;
		if (countUnivalSubtrees(root.left, totalCount))
			if (root.value != root.left.value)
				isUnival = false;
		if (countUnivalSubtrees(root.right, totalCount))
			if (root.value != root.right.value)
				isUnival = false;
		
		if (isUnival)
		{
			++totalCount[0];
			return true;
		}
		return false;
	}
}