import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		int[] numbers = new int[] {10, 15, 3, 7};
		int k = 17;
		assertTrue(Problem.containsPairEqualToK(numbers, k));
		assertTrue(Problem.containsPairEqualToKOnePass(numbers, k));
	}
	
	@Test
	void testNoCorrectAnswers()
	{
		int[] numbers = new int[] {10, 15, 3, 7};
		int k = 16;
		assertFalse(Problem.containsPairEqualToK(numbers, k));
		assertFalse(Problem.containsPairEqualToKOnePass(numbers, k));
	}
	
	@Test
	void testMultipleCorrectAnswers()
	{
		int[] numbers = new int[] {2, 10, 15, 3, 7};
		int k = 17;
		assertTrue(Problem.containsPairEqualToK(numbers, k));
		assertTrue(Problem.containsPairEqualToKOnePass(numbers, k));
	}
	
	@Test
	void testNegativeSum()
	{
		int[] numbers = new int[] {2, -10, 15, -3, -6};
		int k = -4;
		assertTrue(Problem.containsPairEqualToK(numbers, k));
		assertTrue(Problem.containsPairEqualToKOnePass(numbers, k));
	}
	
	@Test
	void testZeroSum()
	{
		int[] numbers = new int[] {3, -10, 15, -3, -6};
		int k = 0;
		assertTrue(Problem.containsPairEqualToK(numbers, k));
		assertTrue(Problem.containsPairEqualToKOnePass(numbers, k));
	}
	
	@Test
	void testLargeArray()
	{
		int[] numbers = new int[1_000_000];
		numbers = Arrays.stream(numbers)
			  .parallel()
			  .map((i) -> (int)(Integer.MAX_VALUE * ((Math.random() * 2) - 1)))
			  .toArray();
		int k = numbers[10] + numbers[103];
		assertTrue(Problem.containsPairEqualToK(numbers, k));
		assertTrue(Problem.containsPairEqualToKOnePass(numbers, k));
	}
}