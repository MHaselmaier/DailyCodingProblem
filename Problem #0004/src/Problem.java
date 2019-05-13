import java.util.Scanner;

public class Problem
{
	// Constraint: linear time and constant space
	public static int findFirstMissingPositiveInteger(int[] input)
	{
		if (null == input) return 1;
		
		int newLength = input.length;
		for (int i = 0; newLength > i; ++i)
		{
			if (0 >= input[i] || input.length < input[i])
			{
				int tmp;
				do
				{
					tmp = input[--newLength];
				} while ((0 >= tmp || input.length < tmp) && i < newLength);
				
				input[newLength] = input[i];
				input[i] = tmp;
			}
		}
		
		for (int i = 0; newLength > i; ++i)
		{
			if (0 < input[Math.abs(input[i]) - 1])
			{
				input[Math.abs(input[i]) - 1] *= -1;
			}
		}
		
		for (int i = 0; newLength > i; ++i)
		{
			if (0 < input[i])
				return i + 1;
		}
		
		return newLength + 1;
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
		
		sc.close();
		
		int missing = findFirstMissingPositiveInteger(numbers);
		System.out.println("The first missing positive integer is " + missing + ".");
	}
}