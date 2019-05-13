import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		assertEquals(3, Problem.lengthOfLongestSubStringContainingKDistinctCharacters("abcba", 2));
		assertEquals(3, Problem.lengthOfLongestSubStringContainingKDistinctCharactersLinearTime("abcba", 2));
	}
	
	@Test
	void testFullStringIsLongest()
	{
		assertEquals(5, Problem.lengthOfLongestSubStringContainingKDistinctCharacters("abcba", 3));
		assertEquals(5, Problem.lengthOfLongestSubStringContainingKDistinctCharactersLinearTime("abcba", 3));
	}
	
	@Test
	void testKZero()
	{
		assertEquals(0, Problem.lengthOfLongestSubStringContainingKDistinctCharacters("abcba", 0));
		assertEquals(0, Problem.lengthOfLongestSubStringContainingKDistinctCharactersLinearTime("abcba", 0));
	}
	
	@Test
	void testKOne()
	{
		assertEquals(1, Problem.lengthOfLongestSubStringContainingKDistinctCharacters("abcba", 1));
		assertEquals(1, Problem.lengthOfLongestSubStringContainingKDistinctCharactersLinearTime("abcba", 1));
	}
	
	@Test
	void testKNegative()
	{
		assertEquals(0, Problem.lengthOfLongestSubStringContainingKDistinctCharacters("abcba", -1));
		assertEquals(0, Problem.lengthOfLongestSubStringContainingKDistinctCharactersLinearTime("abcba", -1));
	}
	
	@Test
	void testNullString()
	{
		assertEquals(0, Problem.lengthOfLongestSubStringContainingKDistinctCharacters(null, 3));
		assertEquals(0, Problem.lengthOfLongestSubStringContainingKDistinctCharactersLinearTime(null, 3));
	}
	
	@Test
	void testEmptyString()
	{
		assertEquals(0, Problem.lengthOfLongestSubStringContainingKDistinctCharacters("", 3));
		assertEquals(0, Problem.lengthOfLongestSubStringContainingKDistinctCharactersLinearTime("", 3));
	}
}