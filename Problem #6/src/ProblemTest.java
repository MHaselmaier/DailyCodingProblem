import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testGetOnEmptyList()
	{
		XORLinkedList<Integer> list = new XORLinkedList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
	}
	
	@Test
	void testAddAndGetValue()
	{
		XORLinkedList<Integer> list = new XORLinkedList<>();
		list.add(1);
		assertEquals(new Integer(1), list.get(0));
	}
	
	@Test
	void testGetIndexGreaterThanSize()
	{
		XORLinkedList<Integer> list = new XORLinkedList<>();
		list.add(1);
		list.add(2);
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
	}
	
	@Test
	void testGetNegativeIndex()
	{
		XORLinkedList<Integer> list = new XORLinkedList<>();
		list.add(1);
		list.add(2);
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
	}
	
	@Test
	void testRandomAccess()
	{
		XORLinkedList<Integer> list = new XORLinkedList<>();
		for (int i = 0; 10 > i; ++i)
			list.add(i);
		assertEquals(new Integer(2), list.get(2));
		assertEquals(new Integer(6), list.get(6));
		assertEquals(new Integer(4), list.get(4));
	}
}