import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem1()
	{
		int[] input = new int[] {1, 2, 3, 4, 5};
		int[] expectedOutput = new int[] {120, 60, 40, 30, 24};
		int[] actualOutput = Problem.getProductOfElementsExceptI(input);
		assertArrayEquals(expectedOutput, actualOutput);
		actualOutput = Problem.getProductOfElementsExceptIFast(input);
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testExampleFromProblem2()
	{
		int[] input = new int[] {3, 2, 1};
		int[] expectedOutput = new int[] {2, 3, 6};
		int[] actualOutput = Problem.getProductOfElementsExceptI(input);
		assertArrayEquals(expectedOutput, actualOutput);
		actualOutput = Problem.getProductOfElementsExceptIFast(input);
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testEmptyInput()
	{
		int[] input = new int[0];
		int[] expectedOutput = new int[0];
		int[] actualOutput = Problem.getProductOfElementsExceptI(input);
		assertArrayEquals(expectedOutput, actualOutput);
		actualOutput = Problem.getProductOfElementsExceptIFast(input);
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testZeroInInputArray()
	{
		int[] input = new int[] {0, 1, 2};
		int[] expectedOutput = new int[] {2, 0, 0};
		int[] actualOutput = Problem.getProductOfElementsExceptI(input);
		assertArrayEquals(expectedOutput, actualOutput);
		actualOutput = Problem.getProductOfElementsExceptIFast(input);
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testNegativeInInputArray()
	{
		int[] input = new int[] {-5, 1, 2};
		int[] expectedOutput = new int[] {2, -10, -5};
		int[] actualOutput = Problem.getProductOfElementsExceptI(input);
		assertArrayEquals(expectedOutput, actualOutput);
		actualOutput = Problem.getProductOfElementsExceptIFast(input);
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testLargeInputArray()
	{
		int[] input = new int[100_000];
		Arrays.fill(input, 1);
		input[10] = 10;
		input[20] = 20;
		int[] expectedOutput = new int[100_000];
		Arrays.fill(expectedOutput, 200);
		expectedOutput[10] = 20;
		expectedOutput[20] = 10;
		int[] actualOutput = Problem.getProductOfElementsExceptI(input);
		assertArrayEquals(expectedOutput, actualOutput);
		actualOutput = Problem.getProductOfElementsExceptIFast(input);
		assertArrayEquals(expectedOutput, actualOutput);
	}
}