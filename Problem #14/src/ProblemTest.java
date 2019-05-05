import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		// Since solution is probabilistic test many times!
		for (int i = 0; 1_000 > i; ++i)
		{
			assertEquals(3141, (int)(Problem.estimatePi() * 1000));
		}
	}
}