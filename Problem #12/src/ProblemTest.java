import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		assertEquals(5, Problem.countUniqueWaysUpTheStaircase(4));
	}
	
	@Test
	void testExampleFromProblemCustomStepSize()
	{
		int[] stepSizes = {1, 3, 5};
		assertEquals(3, Problem.countUniqueWaysUpTheStaircaseCustomStepSize(4, stepSizes));
	}
	
	@Test
	void testZeroSteps()
	{
		int[] stepSizes = {1, 2};
		assertEquals(1, Problem.countUniqueWaysUpTheStaircase(0));
		assertEquals(1, Problem.countUniqueWaysUpTheStaircaseCustomStepSize(0, stepSizes));
	}
	
	@Test
	void testNullStepSizes()
	{
		assertEquals(0, Problem.countUniqueWaysUpTheStaircaseCustomStepSize(0, null));
	}
	
	@Test
	void testEmptyStepSizes()
	{
		int[] stepSizes = {};
		assertEquals(0, Problem.countUniqueWaysUpTheStaircaseCustomStepSize(0, stepSizes));
	}
	
	@Test
	void testOneStepSizeGreaterThanSteps()
	{
		int[] stepSizes = {5};
		assertEquals(0, Problem.countUniqueWaysUpTheStaircaseCustomStepSize(2, stepSizes));
	}
}