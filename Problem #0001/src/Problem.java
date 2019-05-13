import java.util.HashSet;
import java.util.Scanner;
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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many numbers would you like to enter?");
		int[] numbers = new int[sc.nextInt()];
				
		for (int i = 0; numbers.length > i; ++i)
		{
			System.out.println("Please enter number #" + (i + 1) + ":");
			numbers[i] = sc.nextInt();
		}
		
		System.out.println("What is should the sum of two pairs be?");
		int k = sc.nextInt();
		
		sc.close();
		
		if (containsPairEqualToKOnePass(numbers, k))
		{
			System.out.println("The entered numbers contain a pair which adds up to " + k + ".");
		}
		else
		{
			System.out.println("The entered numbers don't contain a pair which adds up to " + k + ".");
		}
	}
}