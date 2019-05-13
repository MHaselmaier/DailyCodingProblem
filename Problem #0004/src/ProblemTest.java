import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem1()
	{
		int[] input = {3, 4, -1, 1};
		assertEquals(2, Problem.findFirstMissingPositiveInteger(input));
	}
	
	@Test
	void testExampleFromProblem2()
	{
		int[] input = {1, 2, 0};
		assertEquals(3, Problem.findFirstMissingPositiveInteger(input));
	}
	
	@Test
	void testNullArray()
	{
		assertEquals(1, Problem.findFirstMissingPositiveInteger(null));
	}
	
	@Test
	void testEmptyArray()
	{
		assertEquals(1, Problem.findFirstMissingPositiveInteger(new int[0]));
	}
	
	@Test
	void testStartingWithZero()
	{
		int[] input = {0, 3, 4, 2, 1};
		assertEquals(5, Problem.findFirstMissingPositiveInteger(input));
	}
	
	@Test
	void testStartingWithNegative()
	{
		int[] input = {-4, 3, 4, 2, 1};
		assertEquals(5, Problem.findFirstMissingPositiveInteger(input));
	}
	
	@Test
	void testLargeValues()
	{
		int[] input = {1_000_000, 999_999, 1, 2, 3};
		assertEquals(4, Problem.findFirstMissingPositiveInteger(input));
	}

	@Test
	void testRisingSequence()
	{
		assertEquals(11, Problem.findFirstMissingPositiveInteger(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
	}
	
	@Test
	void testFallingSequnce()
	{
		assertEquals(11, Problem.findFirstMissingPositiveInteger(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
	}
	
	@Test
	void testScrammbledStartingLow()
	{
		assertEquals(11, Problem.findFirstMissingPositiveInteger(new int[] {1, 10, 2, 9, 3, 8, 4, 7, 5, 6}));
	}
	
	@Test
	void testScrambledStartingHigh()
	{
		assertEquals(11, Problem.findFirstMissingPositiveInteger(new int[] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5}));
	}
	
	@Test
	void testSwappingNegativeWithAnotherNegative()
	{
		int[] input = {-3, 4, 2, -1};
		assertEquals(1, Problem.findFirstMissingPositiveInteger(input));
	}
}