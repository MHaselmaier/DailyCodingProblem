import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem1()
	{
		assertEquals(new Integer(3), Problem.car(Problem.cons(3, 4)));
	}
	
	@Test
	void testExampleFromProblem2()
	{
		assertEquals(new Integer(4), Problem.cdr(Problem.cons(3, 4)));
	}
}