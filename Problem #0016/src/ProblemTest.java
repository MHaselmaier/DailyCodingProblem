import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testToSmallIndex()
	{
		Problem p = new Problem(5);
		p.record(1);
		assertThrows(IndexOutOfBoundsException.class, () -> p.get_last(0));
		assertThrows(IndexOutOfBoundsException.class, () -> p.get_last(-1));
	}
	
	@Test
	void testToLargeIndex()
	{
		Problem p = new Problem(5);
		p.record(1);
		p.record(2);
		p.record(3);
		p.record(4);
		p.record(5);
		assertThrows(IndexOutOfBoundsException.class, () -> p.get_last(6));
	}
	
	@Test
	void testIlleagelOrderId()
	{
		Problem p = new Problem(5);
		assertThrows(IllegalArgumentException.class, () -> p.record(0));
		assertThrows(IllegalArgumentException.class, () -> p.record(-1));
	}
	
	@Test
	void testReceiveIds()
	{
		Problem p = new Problem(5);
		for (int i = 1; 5 >= i; ++i)
			p.record(i);
		assertEquals(1, p.get_last(5));
		assertEquals(5, p.get_last(1));
	}
	
	@Test
	void testOverwrittenPlaces()
	{
		Problem p = new Problem(5);
		for (int i = 1; 7 >= i; ++i)
			p.record(i);
		assertEquals(3, p.get_last(5));
		assertEquals(7, p.get_last(1));
	}
}