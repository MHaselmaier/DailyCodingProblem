import java.util.Scanner;

public class Problem
{
	public static int countUniqueWaysUpTheStaircase(int amtSteps)
	{
		if (0 > amtSteps) return 0;
		if (0 == amtSteps) return 1;
		
		int totalWays = 0;
		totalWays += countUniqueWaysUpTheStaircase(amtSteps - 1);
		totalWays += countUniqueWaysUpTheStaircase(amtSteps - 2);
		
		return totalWays;
	}
	
	public static int countUniqueWaysUpTheStaircaseCustomStepSize(int amtSteps, int[] stepSizes)
	{
		if (0 > amtSteps || null == stepSizes || 0 == stepSizes.length) return 0;
		if (0 == amtSteps) return 1;
		
		int totalWays = 0;
		for (int stepSize: stepSizes)
			totalWays += countUniqueWaysUpTheStaircaseCustomStepSize(amtSteps - stepSize, stepSizes);
		
		return totalWays;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the amount of steps of the staircase:");
		int amtSteps = sc.nextInt();
		
		System.out.println("How many different step sizes are allowed?");
		int[] stepSizes = new int[sc.nextInt()];
		for (int i = 0; stepSizes.length > i; ++i)
		{
			System.out.println("Please enter step size #" + (i + 1) + ":");
			stepSizes[i] = sc.nextInt();
		}
		
		sc.close();
		
		int uniqueWays = countUniqueWaysUpTheStaircaseCustomStepSize(amtSteps, stepSizes);
		System.out.println("There are " + uniqueWays + " to climb the staircase.");
	}
}