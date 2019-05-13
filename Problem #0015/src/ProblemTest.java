import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.IntSummaryStatistics;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	private static int randomIntBetween0And100()
	{
		return ThreadLocalRandom.current().nextInt(100);
	}
	
	@Test
	void testExampleFromProblem()
	{
		final int runs = 1_000_000;
		int[] selectedElementCounts = new int[100];
		for (int i = 0; runs > i; ++i)
		{
			Stream<Integer> stream = Stream.iterate(randomIntBetween0And100(), (s) -> randomIntBetween0And100())
				 				 .limit(1_000);
			++selectedElementCounts[Problem.pickRandomElement(stream)];
		}
		
		IntSummaryStatistics statistics = new IntSummaryStatistics();
		for (int i: selectedElementCounts)
			statistics.accept(i);
		
		assertEquals(runs / 100, statistics.getAverage(), 1e-5);
	}
}