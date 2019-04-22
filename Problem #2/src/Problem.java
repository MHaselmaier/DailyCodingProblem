import java.util.Arrays;
import java.util.Scanner;

public class Problem
{
	// This has a time complexity of O(n²)
	public static int[] getProductOfElementsExceptI(int[] array)
	{
		int[] output = new int[array.length];

		for (int i = 0; output.length > i; ++i)
		{
			output[i] = 1;
			for (int j = 0; array.length > j; ++j)
			{
				if (i == j) continue;
				output[i] *= array[j];
			}
		}
		
		return output;
	}
	
	// This has a time complexity of O(3n)
	public static int[] getProductOfElementsExceptIFast(int[] array)
	{
		if (0 == array.length) return new int[0];
		
		int[] rightProducts = calculateRightProducts(array);
		int[] leftProducts = calculateLeftProducts(array);
		
		int[] output = new int[array.length];
		output[0] = rightProducts[1];
		for (int i = 1; output.length - 1 > i; ++i)
		{
			output[i] = rightProducts[i + 1] * leftProducts[i - 1];
		}
		output[output.length - 1] = leftProducts[output.length - 2];
		
		return output;
	}
	
	private static int[] calculateRightProducts(int[] array)
	{
		int[] rightProducts = new int[array.length];
		
		int product = 1;
		for (int i = array.length - 1; 0 <= i; --i)
		{
			product *= array[i];
			rightProducts[i] = product;
		}
		
		return rightProducts;
	}
	
	private static int[] calculateLeftProducts(int[] array)
	{
		int[] leftProducts = new int[array.length];
		
		int product = 1;
		for (int i = 0; array.length > i; ++i)
		{
			product *= array[i];
			leftProducts[i] = product;
		}
		
		return leftProducts;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many numbers would you like to enter?");
		int[] numbers = new int[sc.nextInt()];
				
		for (int i = 0; numbers.length > i; ++i)
		{
			System.out.println("Please enter number #" + (i + 1) + ":");
			numbers[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println("The products of all elements except the i-th element are:");
		System.out.println(Arrays.toString(getProductOfElementsExceptIFast(numbers)));
	}
}