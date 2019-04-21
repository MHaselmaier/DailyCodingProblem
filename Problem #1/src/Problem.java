import java.util.HashSet;
import java.util.Set;

public class Problem
{
	public static boolean containsPairEqualToK(int[] numbers, int k)
	{
		for (int i = 0; numbers.length - 1 > i; ++i)
		{
			for (int j = i + 1; numbers.length > j; ++j)
			{
				if (numbers[i] + numbers[j] == k)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean containsPairEqualToKOnePass(int[] numbers, int k)
	{
		Set<Integer> remainders = new HashSet<>();
		for (int number: numbers)
		{
			if (remainders.contains(number))
				return true;
			remainders.add(k - number);
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		
	}
}