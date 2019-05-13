import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testFromExample()
	{
		TreeDictionary dict = new TreeDictionary();
		dict.enterWord("dog", "deer", "deal");
		
		Set<String> expected = new TreeSet<>();
		expected.add("deer");
		expected.add("deal");
		
		assertEquals(expected, dict.completeWord("de"));
	}
	
	@Test
	void testEmptyDictionary()
	{
		TreeDictionary dict = new TreeDictionary();
		
		Set<String> expected = new TreeSet<>();
		
		assertEquals(expected, dict.completeWord("test"));
	}
	
	@Test
	void testNullWord()
	{
		TreeDictionary dict = new TreeDictionary();
		
		Set<String> expected = new TreeSet<>();
		
		assertEquals(expected, dict.completeWord(null));
	}
	
	@Test
	void testEmptyWord()
	{
		TreeDictionary dict = new TreeDictionary();
		dict.enterWord("dog", "deer", "deal");
		
		Set<String> expected = new TreeSet<>();
		expected.add("dog");
		expected.add("deer");
		expected.add("deal");
		
		assertEquals(expected, dict.completeWord(""));
	}
	
	@Test
	void testWordNotInDictionary()
	{
		TreeDictionary dict = new TreeDictionary();
		dict.enterWord("dog", "deer", "deal");
		
		Set<String> expected = new TreeSet<>();
		expected.add("dog");
		expected.add("deer");
		expected.add("deal");
		
		assertEquals(expected, dict.completeWord(""));
	}
}