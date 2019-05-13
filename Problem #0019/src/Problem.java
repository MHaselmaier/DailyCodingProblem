public class Problem
{
	public static float minCostRecursive(float[][] costs)
	{
		if (null == costs) return 0;
		if (0 == costs.length || 0 == costs[0].length) return 0;
		
		return minCost(costs, new int[costs.length], 0);
	}
	
	private static float minCost(float[][] costs, int[] colors, int currentHouse)
	{
		if (costs.length <= currentHouse)
		{
			float totalCost = 0;
			for (int i = 0; costs.length > i; ++i)
			{
				totalCost += costs[i][colors[i]];
			}
			return totalCost;
		}
		
		float minCost = Float.MAX_VALUE;
		for (int i = 0; costs[currentHouse].length > i; ++i)
		{
			if (0 <= currentHouse - 1 && colors[currentHouse - 1] == i) continue;
			
			colors[currentHouse] = i;
			minCost = Math.min(minCost, minCost(costs, colors, currentHouse + 1));
		}
		
		return minCost;
	}
	
	public static float minCostDynamicProgramming(float[][] costs)
	{
		if (null == costs) return 0;
		if (0 == costs.length || 0 == costs[0].length) return 0;
		
		float[][] minCumulativeCosts = new float[costs.length][];
		
		minCumulativeCosts[0] = costs[0].clone();
		for (int h = 1; costs.length > h; ++h)
		{
			minCumulativeCosts[h] = new float[costs[h].length];
			for (int c = 0; costs[h].length > c; ++c)
			{
				float minPrevious = Float.MAX_VALUE;
				for (int i = 0; costs[h - 1].length > i; ++i)
				{
					if (c == i) continue;
					minPrevious = Math.min(minPrevious, minCumulativeCosts[h - 1][i]);
				}
				minCumulativeCosts[h][c] = minPrevious + costs[h][c];
			}
		}
		
		float minCumulativeCost = minCumulativeCosts[costs.length - 1][0];
		for (int c = 1; costs[costs.length - 1].length > c; ++c)
		{
			minCumulativeCost = Math.min(minCumulativeCost, minCumulativeCosts[costs.length - 1][c]);
		}
		return minCumulativeCost;
	}
}