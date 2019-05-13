import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		LinkedList<Integer> intersection = new LinkedList<>(10);
		intersection = new LinkedList<Integer>(8, intersection);
		
		LinkedList<Integer> a = new LinkedList<>(7, intersection);
		a = new LinkedList<>(3, a);
		
		LinkedList<Integer> b = new LinkedList<>(1, intersection);
		b = new LinkedList<>(99, b);
		
		assertEquals(intersection.value, Problem.intersectionNode(a, b).value);
	}
	
	@Test
	void testNullInput()
	{
		LinkedList<Integer> a = new LinkedList<>(10);
		a = new LinkedList<>(8, a);
		a = new LinkedList<>(7, a);
		a = new LinkedList<>(3, a);
		
		assertEquals(null, Problem.intersectionNode(null, null));
		assertEquals(null, Problem.intersectionNode(null, a));
		assertEquals(null, Problem.intersectionNode(a, null));
	}
	
	@Test
	void testOneElementList()
	{
		LinkedList<Integer> b = new LinkedList<>(10);
		b = new LinkedList<>(8, b);
		b = new LinkedList<>(1, b);
		b = new LinkedList<>(99, b);
		
		LinkedList<Integer> a = new LinkedList<>(7);
		
		assertEquals(null, Problem.intersectionNode(a, b));
		assertEquals(null, Problem.intersectionNode(b, a));
	}
	
	@Test
	void testNoIntersection()
	{
		LinkedList<Integer> a = new LinkedList<>(10);
		a = new LinkedList<>(8, a);
		a = new LinkedList<>(7, a);
		a = new LinkedList<>(3, a);
		
		LinkedList<Integer> b = new LinkedList<>(1);
		b = new LinkedList<>(99, b);
		b = new LinkedList<>(2, b);
		b = new LinkedList<>(5, b);
		
		assertEquals(null, Problem.intersectionNode(a, b));
	}
	
	@Test
	void testDifferentSizeLists()
	{
		LinkedList<Integer> intersection = new LinkedList<>(10);
		intersection = new LinkedList<Integer>(8, intersection);
		
		LinkedList<Integer> a = new LinkedList<>(7, intersection);
		a = new LinkedList<>(3, a);
		a = new LinkedList<>(4, a);
		a = new LinkedList<>(8, a);
		
		LinkedList<Integer> b = new LinkedList<>(1, intersection);
		b = new LinkedList<>(99, b);
		
		assertEquals(intersection.value, Problem.intersectionNode(a, b).value);
		assertEquals(intersection.value, Problem.intersectionNode(b, a).value);
	}
}