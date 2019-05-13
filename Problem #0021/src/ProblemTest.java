import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem()
	{
		int[][] timeIntervals = {{30, 75}, {0, 50}, {60, 150}};
		assertEquals(2, Problem.minimumNumberOfRoomsBruteForce(timeIntervals));
		assertEquals(2, Problem.minimumNumberOfRooms(timeIntervals));
	}
	
	@Test
	void testNullInput()
	{
		assertEquals(0, Problem.minimumNumberOfRoomsBruteForce(null));
		assertEquals(0, Problem.minimumNumberOfRooms(null));
	}
	
	@Test
	void testEmptyInput()
	{
		int[][] timeIntervals = {};
		assertEquals(0, Problem.minimumNumberOfRoomsBruteForce(timeIntervals));
		assertEquals(0, Problem.minimumNumberOfRooms(timeIntervals));
	}
	
	@Test
	void testSingleRoom()
	{
		int[][] timeIntervals = {{0, 50}};
		assertEquals(1, Problem.minimumNumberOfRoomsBruteForce(timeIntervals));
		assertEquals(1, Problem.minimumNumberOfRooms(timeIntervals));
	}
	
	@Test
	void testStartPointEqualToEndPoint()
	{
		int[][] timeIntervals = {{30, 75}, {0, 50}, {60, 150}, {20, 30}};
		assertEquals(2, Problem.minimumNumberOfRoomsBruteForce(timeIntervals));
		assertEquals(2, Problem.minimumNumberOfRooms(timeIntervals));
	}
	
	@Test
	void testIntervalWithSameStartAndEndPoint()
	{
		int[][] timeIntervals = {{30, 75}, {0, 50}, {60, 150}, {20, 30}, {40, 40}};
		assertEquals(2, Problem.minimumNumberOfRoomsBruteForce(timeIntervals));
		assertEquals(2, Problem.minimumNumberOfRooms(timeIntervals));
	}
}