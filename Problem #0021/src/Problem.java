import java.util.Arrays;
import java.util.Scanner;

public class Problem
{
	// O(n²)
	public static int minimumNumberOfRoomsBruteForce(int[][] timeIntervals)
	{
		if (null == timeIntervals) return 0;
		if (0 == timeIntervals.length) return 0;		
		
		int minimumRooms = 1;
		for (int i = 0; timeIntervals.length > i; ++i)
		{
			if (timeIntervals[i][0] == timeIntervals[i][1]) continue;
			
			int currentMinimumRooms = 0;
			for (int j = 0; timeIntervals.length > j; ++j)
			{
				if (i == j) continue;
				if (timeIntervals[j][0] == timeIntervals[j][1]) continue;
				
				if ((timeIntervals[i][0] <= timeIntervals[j][0] && timeIntervals[i][1] > timeIntervals[j][0]) ||
					(timeIntervals[i][0] < timeIntervals[j][1] && timeIntervals[i][1] >= timeIntervals[j][1]))
				{
					++currentMinimumRooms;
				}
			}
			minimumRooms = Math.max(minimumRooms, currentMinimumRooms);
		}
		
		return minimumRooms;
	}
	
	// O(nlog(n))
	public static int minimumNumberOfRooms(int[][] timeIntervals)
	{
		if (null == timeIntervals) return 0;
		
		int[] sortedStartTimes = Arrays.stream(timeIntervals).mapToInt(interval -> interval[0]).sorted().toArray();
		int[] sortedEndTimes = Arrays.stream(timeIntervals).mapToInt(interval -> interval[1]).sorted().toArray();
		int currentStartTime = 0;
		int currentEndTime = 0;
		
		int maximumUsedRooms = 0;
		int currentlyUsedRooms = 0;
		while (currentStartTime < timeIntervals.length && currentEndTime < timeIntervals.length)
		{
			if (sortedStartTimes[currentStartTime] < sortedEndTimes[currentEndTime])
			{
				++currentlyUsedRooms;
				++currentStartTime;
			}
			else
			{
				--currentlyUsedRooms;
				++currentEndTime;
			}
			
			maximumUsedRooms = Math.max(maximumUsedRooms, currentlyUsedRooms);
		}
		
		return maximumUsedRooms;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many time intervals would you like to enter?");
		int[][] timeIntervals = new int[sc.nextInt()][2];
		
		for (int i = 0; timeIntervals.length > i; ++i)
		{
			System.out.println("Please enter the start time of the " + (i + 1) + "th interval:");
			timeIntervals[i][0] = sc.nextInt();
			System.out.println("Please enter the end time of the " + (i + 1) + "th interval:");
			timeIntervals[i][1] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println("At least " + minimumNumberOfRooms(timeIntervals) + " rooms are needed.");
	}
}