import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		Node<Integer> root = new Node<>(0, new Node<>(1),
				new Node<>(0, new Node<>(1, new Node<>(1), new Node<>(1)), new Node<>(0)));
		
		assertEquals(5, Problem.countUnivalSubtrees(root));
	}
	
	@Test
	void testNullTree()
	{
		assertEquals(0, Problem.countUnivalSubtrees(null));
	}
	
	@Test
	void testTreeWithOneNode()
	{
		Node<Integer> root = new Node<>(0);
		assertEquals(1, Problem.countUnivalSubtrees(root));
	}
	
	@Test
	void testTreeWithNoUnivalSubtreesExceptLeafs()
	{
		Node<Integer> root = new Node<>(0, new Node<>(1, new Node<>(2), new Node<>(3)), new Node<>(4));
		assertEquals(3, Problem.countUnivalSubtrees(root));
	}
	
	@Test
	void testTreeWithOnlyOneValue()
	{
		Node<Integer> root = new Node<>(1, new Node<>(1, new Node<>(1), new Node<>(1)), new Node<>(1));	
		assertEquals(5, Problem.countUnivalSubtrees(root));
	}
	
	@Test
	void testNodesWithOnlyOneChild()
	{
		Node<Integer> root = new Node<>(1, null, new Node<>(1, new Node<>(1), null));	
		assertEquals(3, Problem.countUnivalSubtrees(root));
	}
}