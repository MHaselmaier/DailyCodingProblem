import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Problem
{
	public static double estimatePi()
	{
		int pointsPerRound = 100_000_000;
		long pointsInCircle = 0;
		long totalPoints = 0;
		double currentEstimate = 0;
		boolean firstThreeDecimalsChanged = true;
		do
		{
			totalPoints += pointsPerRound;
			pointsInCircle += IntStream.range(0, pointsPerRound)
					 				.parallel()
					 				.map((i) -> 
					 				{
					 					double xSquard = Math.pow(ThreadLocalRandom.current().nextDouble(), 2);
					 					double ySquard = Math.pow(ThreadLocalRandom.current().nextDouble(), 2); 
					 					return 1.0 > xSquard + ySquard ? 1 : 0;
					 				})
					 				.sum();
			double newEstimate = (double)pointsInCircle / totalPoints;
			firstThreeDecimalsChanged = (int)(currentEstimate * 40000) != (int)(newEstimate * 40000);
			currentEstimate = newEstimate;
		} while (firstThreeDecimalsChanged);
		
		return currentEstimate * 4;
	}
	
	public static void main(String[] args)
	{
		System.out.println("The estimation of Pi to 3 decimal places is " + estimatePi() + ".");
	}
}