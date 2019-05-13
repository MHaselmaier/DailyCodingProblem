import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Problem
{
	public static int[] computeMaximumOfSubarrays(int[] input, int k)
	{
		if (null == input) return new int[0];
		if (0 >= k || input.length < k) return new int[0];
		
		int[] result = new int[input.length - (k - 1)];
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		int i = 0;
		for (; k > i; ++i)
		{
			while (!q.isEmpty() && input[q.peekLast()] < input[i])
				q.pollLast();
			
			q.addLast(i);
		}
		for (; input.length > i; ++i)
		{
			result[i - k] = input[q.peekFirst()];
			
			while (!q.isEmpty() && q.peekFirst() <= i - k)
				q.poll();
			
			while (!q.isEmpty() && input[i] >= input[q.peekLast()])
				q.pollLast();
			
			q.addLast(i);
		}
		result[i - k] = input[q.peekFirst()];
		
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many numbers would you like to enter?");
		int[] input = new int[sc.nextInt()];
		
		for (int i = 0; input.length > i; ++i)
		{
			System.out.println("Please enter number #" + (i + 1) + ":");
			input[i] = sc.nextInt();
		}
		
		System.out.println("Please enter the length of subarrays:");
		int k = sc.nextInt();
		
		sc.close();
		
		System.out.println("The maximum values of all subarrays of length " + k + " are:");
		System.out.println(Arrays.toString(computeMaximumOfSubarrays(input, k)));
	}
}