import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testFromExample()
	{
		String encodedMessage = "111";
		assertEquals(3, Problem.countPossibleMessages(encodedMessage));
	}
	
	@Test
	void testSomeTens()
	{
		String encodedMessage = "11031814";
		assertEquals(4, Problem.countPossibleMessages(encodedMessage));
	}
	
	@Test
	void testSomeTwenties()
	{
		String encodedMessage = "12032824";
		assertEquals(2, Problem.countPossibleMessages(encodedMessage));
	}
	
	@Test
	void testEmptyMessage()
	{
		String encodedMessage = "";
		assertEquals(1, Problem.countPossibleMessages(encodedMessage));
	}
	
	@Test
	void testNullMessage()
	{
		String encodedMessage = null;
		assertEquals(0, Problem.countPossibleMessages(encodedMessage));
	}
}