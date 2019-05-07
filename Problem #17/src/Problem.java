import java.util.Stack;

public class Problem
{
	public static int getLongestAbsolutPathToFile(String fileSystem)
	{
		if (null == fileSystem) return 0;
		
		int longestPath = 0;
		int dirLength = 0;
		Stack<String> dirStack = new Stack<>();
		
		for (String file: fileSystem.split("\n"))
		{
			if (file.contains("."))
			{
				longestPath = Math.max(longestPath, dirLength + file.trim().length());
			}
			else if (dirStack.size() < file.split("\t").length)
			{
				dirLength += dirStack.push(file.trim()).length() + 1;
			}
			else
			{
				for (int i = dirStack.size() - file.split("\t").length - 1; 0 <= i; --i)
				{
					dirLength -= dirStack.pop().length() + 1;
				}
			}
		}
		
		return longestPath;
	}
}