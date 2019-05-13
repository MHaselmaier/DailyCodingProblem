import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		boolean[][] field = {{false, false, false, false},
							 {true,  true,  false, true},
							 {false, false, false, false},
							 {false, false, false, false}};
		int[] start = {3, 0};
		int[] end = {0, 0};
		assertEquals(Optional.of(7), Problem.getMinimumSteps(field, start, end));
	}
	
	@Test
	void testNullInput()
	{
		boolean[][] field = {{false, false, false, false},
							 {true,  true,  false, true},
							 {false, false, false, false},
							 {false, false, false, false}};
		int[] start = {3, 0};
		int[] end = {0, 0};
		assertEquals(Optional.empty(), Problem.getMinimumSteps(null, start, end));
		assertEquals(Optional.empty(), Problem.getMinimumSteps(field, null, end));
		assertEquals(Optional.empty(), Problem.getMinimumSteps(field, start, null));
	}
	
	@Test
	void testTrivial()
	{
		boolean[][] field = {{false}};
		int[] start = {0, 0};
		int[] end = {0, 0};
		assertEquals(Optional.of(0), Problem.getMinimumSteps(field, start, end));
	}
	
	@Test
	void testImpossible()
	{
		boolean[][] field = {{false, false, false, false},
							 {true,  true,  true,  true },
							 {false, false, false, false},
							 {false, false, false, false}};
		int[] start = {3, 0};
		int[] end = {0, 0};
		assertEquals(Optional.empty(), Problem.getMinimumSteps(field, start, end));
	}
}