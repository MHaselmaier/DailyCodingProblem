public class Problem
{
	public static int largestNonAdjecentSum(int[] input)
	{
		if (null == input) return 0;
		
		return largestNonAdjecentSum(input, 0);
	}
	
	private static int largestNonAdjecentSum(int[] input, int index)
	{
		if (input.length <= index) return 0;
		
		int sum = 0;
		// Don't add element with index
		sum = Math.max(sum, largestNonAdjecentSum(input, index + 1));
		// Add element with index
		sum = Math.max(sum, input[index] + largestNonAdjecentSum(input, index + 2));
		
		return sum;
	}
	
	// Constraints: O(N) time and constant space
	public static int largestNonAdjecentSumOnePass(int[] input)
	{
		if (null == input) return 0;
		
		int currentSum = 0;
		int previousSum = 0;
		
		for (int i: input)
		{
			int tmp = currentSum;
			currentSum = Math.max(previousSum + i, currentSum);
			previousSum = tmp;
		}
		
		return currentSum;
	}
}