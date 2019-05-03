import java.util.Hashtable;
import java.util.Scanner;

public class Problem
{
	// Brute Force
	public static int lengthOfLongestSubStringContainingKDistinctCharacters(String s, int k)
	{
		if (null == s || s.isEmpty()) return 0;
		
		int maxLength = 0;
		for (int start = 0; s.length() > start; ++start)
		{
			int currentCharCount = 0;
			for (int end = start; s.length() > end; ++end)
			{
				for (int previous = start; end > previous; ++previous)
				{
					if (s.charAt(previous) == s.charAt(end))
					{
						--currentCharCount;
						break;
					}
				}
				if (k < ++currentCharCount)
				{
					break;
				}
				
				maxLength = Math.max(maxLength, end - start + 1);
			}
		}
		
		return maxLength;
	}
	
	// O(n) time and space
	public static int lengthOfLongestSubStringContainingKDistinctCharactersLinearTime(String s, int k)
	{
		if (null == s || s.isEmpty()) return 0;
		
		Hashtable<Character, Integer> amtPerCharacter = new Hashtable<>();
		int start = 0;
		int maxLength = 0;
		
		for (int end = 0; s.length() > end; ++end)
		{
			if (null != amtPerCharacter.computeIfPresent(s.charAt(end), (c, count) -> count + 1))
			{
				maxLength = Math.max(maxLength, end - start + 1);
			}
			else if (k >= 1 + amtPerCharacter.size())
			{
				maxLength = Math.max(maxLength, end - start + 1);
				amtPerCharacter.put(s.charAt(end), 1);
			}
			else
			{
				amtPerCharacter.put(s.charAt(end), 1);
				
				amtPerCharacter.compute(s.charAt(start), (c, count) -> 1 == count ? null : count - 1);
				++start;
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the string in that the length of the longest substring "
				+ "with k distinct characters is wanted:");
		String s = sc.nextLine();
		
		System.out.println("Please ente the amount of distinct characters:");
		int k = sc.nextInt();
		
		sc.close();
		
		int length = lengthOfLongestSubStringContainingKDistinctCharactersLinearTime(s, k);
		System.out.println("The longest substring with " + k + " distinct characters has a length of " + length + ".");
	}
}