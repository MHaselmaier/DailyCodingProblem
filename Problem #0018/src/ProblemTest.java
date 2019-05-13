import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		int[] input = {10, 5, 2, 7, 8, 7};
		assertArrayEquals(new int[] {10, 7, 8, 8}, Problem.computeMaximumOfSubarrays(input, 3));
	}
	
	@Test
	void testNullInput()
	{
		assertArrayEquals(new int[] {}, Problem.computeMaximumOfSubarrays(null, 3));
	}
	
	@Test
	void testEmptyInput()
	{
		int[] input = {};
		assertArrayEquals(new int[] {}, Problem.computeMaximumOfSubarrays(input, 0));
	}
	
	@Test
	void testZeroK()
	{
		int[] input = {10, 5, 2, 7, 8, 7};
		assertArrayEquals(new int[] {}, Problem.computeMaximumOfSubarrays(input, 0));
	}
	
	@Test
	void testNegativeK()
	{
		int[] input = {10, 5, 2, 7, 8, 7};
		assertArrayEquals(new int[] {}, Problem.computeMaximumOfSubarrays(input, -1));
	}
	
	@Test
	void testKGreaterInputLength()
	{
		int[] input = {10, 5, 2, 7, 8, 7};
		assertArrayEquals(new int[] {}, Problem.computeMaximumOfSubarrays(input, input.length + 1));
	}
	
	@Test
	void testKEqualsInputLength()
	{
		int[] input = {10, 5, 2, 7, 8, 7};
		assertArrayEquals(new int[] {10}, Problem.computeMaximumOfSubarrays(input, input.length));
	}
	
	@Test
	void testNegativeInputValues()
	{
		int[] input = {-10, -5, -2, 7, -8, 7};
		assertArrayEquals(new int[] {-2, 7, 7, 7}, Problem.computeMaximumOfSubarrays(input, 3));
	}
}