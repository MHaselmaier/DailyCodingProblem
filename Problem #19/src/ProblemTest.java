import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testNullInput()
	{
		assertEquals(0, Problem.minCostRecursive(null));
		assertEquals(0, Problem.minCostDynamicProgramming(null));
	}
	
	@Test
	void testEmptyInput()
	{
		float[][] costs = new float[0][0];
		assertEquals(0, Problem.minCostRecursive(costs));
		assertEquals(0, Problem.minCostDynamicProgramming(costs));
	}
	
	@Test
	void testTrivialExample()
	{
		float[][] costs = {{1}};
		assertEquals(1, Problem.minCostRecursive(costs));
		assertEquals(1, Problem.minCostDynamicProgramming(costs));
	}
	
	@Test
	void testImposibleExample()
	{
		float[][] costs = {{1},
						   {1}};
		assertEquals(Float.MAX_VALUE, Problem.minCostRecursive(costs));
		assertEquals(Float.MAX_VALUE, Problem.minCostDynamicProgramming(costs));
	}
	
	@Test
	void testRandomExample()
	{
		float[][] costs = {{1, 2, 3, 4},
						   {1, 2, 1, 0},
						   {6, 1, 1, 5},
						   {2, 3, 5, 5}};
		assertEquals(4, Problem.minCostRecursive(costs));
		assertEquals(4, Problem.minCostDynamicProgramming(costs));
	}
}