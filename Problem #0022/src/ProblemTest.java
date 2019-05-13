import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem1()
	{
		Set<String> words = new HashSet<String>();
		words.add("quick");
		words.add("brown");
		words.add("the");
		words.add("fox");
		
		List<String> expected = new ArrayList<>();
		expected.add("the");
		expected.add("quick");
		expected.add("brown");
		expected.add("fox");
		
		assertEquals(expected, Problem.getOriginalSentence("thequickbrownfox", words));
	}
	
	@Test
	void testExampleFromProblem2()
	{
		Set<String> words = new HashSet<String>();
		words.add("bed");
		words.add("bath");
		words.add("bedbath");
		words.add("and");
		words.add("beyond");
		
		List<String> expected1 = new ArrayList<>();
		expected1.add("bed");
		expected1.add("bath");
		expected1.add("and");
		expected1.add("beyond");
		
		List<String> expected2 = new ArrayList<>();
		expected2.add("bedbath");
		expected2.add("and");
		expected2.add("beyond");
		
		assertTrue(expected1.equals(Problem.getOriginalSentence("bedbathandbeyond", words)) ||
				expected2.equals(Problem.getOriginalSentence("bedbathandbeyond", words)));
	}
	
	@Test
	void testNullInput()
	{
		Set<String> words = new HashSet<String>();
		words.add("bed");
		words.add("bath");
		words.add("bedbath");
		words.add("and");
		words.add("beyond");
		
		assertNull(Problem.getOriginalSentence(null, words));
		assertNull(Problem.getOriginalSentence("", null));
	}
	
	@Test
	void testEmptyInput()
	{
		Set<String> words = new HashSet<String>();
		words.add("bed");
		words.add("bath");
		words.add("bedbath");
		words.add("and");
		words.add("beyond");
		
		assertEquals(new ArrayList<>(), Problem.getOriginalSentence("", words));
		assertEquals(new ArrayList<>(), Problem.getOriginalSentence("", new HashSet<>()));
	}
	
	@Test
	void testNoReconstructionPossible()
	{
		Set<String> words = new HashSet<String>();
		words.add("quick");
		words.add("brown");
		words.add("the");
		words.add("fox");
		
		assertEquals(null, Problem.getOriginalSentence("thequickbrownfo", words));
	}
}