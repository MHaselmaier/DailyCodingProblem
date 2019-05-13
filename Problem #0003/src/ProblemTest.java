import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		Node root = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
		assertEquals("left.left", Problem.deserialize(Problem.serialize(root)).left.left.value);
	}
	
	@Test
	void testEmptyTree()
	{
		Node root = null;
		assertEquals(null, Problem.deserialize(Problem.serialize(root)));
	}
	
	@Test
	void testOneNodeTree()
	{
		Node root = new Node("root");
		assertEquals("root", Problem.deserialize(Problem.serialize(root)).value);
		assertEquals(null, Problem.deserialize(Problem.serialize(root)).left);
		assertEquals(null, Problem.deserialize(Problem.serialize(root)).right);
	}
	
	@Test
	void testUsageOfReservedSymbol()
	{
		assertThrows(RuntimeException.class, () -> new Node("root", new Node("1;1"), null));
	}
}