import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Problem
{
	public static Optional<Integer> getMinimumSteps(boolean[][] field, int[] start, int[] end)
	{
		if (null == field || null == start || null == end)
			return Optional.empty();
		
		int[][] steps = new int[field.length][];
		for (int i = 0; field.length > i; ++i)
		{			
			steps[i] = new int[field[i].length];
			Arrays.fill(steps[i], -1);
		}
		steps[start[0]][start[1]] = 0;
		
		List<int[]> uncheckedPositions = new ArrayList<>();
		uncheckedPositions.add(start);
		
		while (!uncheckedPositions.isEmpty())
		{
			int[] position = uncheckedPositions.remove(0);
			
			List<int[]> neighbors = getNeighbors(field, position);
			for (int[] neighbor: neighbors)
			{
				if (-1 != steps[neighbor[0]][neighbor[1]]) continue;
				
				steps[neighbor[0]][neighbor[1]] = steps[position[0]][position[1]] + 1;
				uncheckedPositions.add(neighbor);
			}
		}
		
		if (-1 == steps[end[0]][end[1]])
			return Optional.empty();
		else
			return Optional.of(steps[end[0]][end[1]]);
	}
	
	private static List<int[]> getNeighbors(boolean[][] field, int[] position)
	{
		List<int[]> neighbors = new ArrayList<>();
		
		if (field.length > position[0] + 1 && !field[position[0] + 1][position[1]])
			neighbors.add(new int[] {position[0] + 1, position[1]});
		if (0 <= position[0] - 1 && !field[position[0] - 1][position[1]])
			neighbors.add(new int[] {position[0] - 1, position[1]});
		if (field[position[0]].length > position[1] + 1 && !field[position[0]][position[1] + 1])
			neighbors.add(new int[] {position[0], position[1] + 1});
		if (0 <= position[1] - 1 && !field[position[0]][position[1] - 1])
			neighbors.add(new int[] {position[0], position[1] - 1});
		
		return neighbors;
	}
}