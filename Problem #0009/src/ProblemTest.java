import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem1()
	{
		int[] input = {2, 4, 6, 2, 5};
		assertEquals(13, Problem.largestNonAdjecentSumOnePass(input));
		assertEquals(13, Problem.largestNonAdjecentSum(input));
	}
	
	@Test
	void testExampleFromProblem2()
	{
		int[] input = {5, 1, 1, 5};
		assertEquals(10, Problem.largestNonAdjecentSumOnePass(input));
		assertEquals(10, Problem.largestNonAdjecentSum(input));
	}
	
	@Test
	void testDecreasing()
	{
		int[] input = {5, 4, 3, 2, 1};
		assertEquals(9, Problem.largestNonAdjecentSumOnePass(input));
		assertEquals(9, Problem.largestNonAdjecentSum(input));
	}
	
	@Test
	void testNegativesOnly()
	{
		int[] input = {0, -1, -2, -3, -4, -5};
		assertEquals(0, Problem.largestNonAdjecentSumOnePass(input));
		assertEquals(0, Problem.largestNonAdjecentSum(input));
	}
	
	@Test
	void testPositivesAndNegatives()
	{
		int[] input = {2, -4, -6, 2, -5};
		assertEquals(4, Problem.largestNonAdjecentSumOnePass(input));
		assertEquals(4, Problem.largestNonAdjecentSum(input));
	}
	
	@Test
	void testEmptyInput()
	{
		int[] input = {};
		assertEquals(0, Problem.largestNonAdjecentSumOnePass(input));
		assertEquals(0, Problem.largestNonAdjecentSum(input));
	}
	
	@Test
	void testNullInput()
	{
		assertEquals(0, Problem.largestNonAdjecentSumOnePass(null));
		assertEquals(0, Problem.largestNonAdjecentSum(null));
	}
}