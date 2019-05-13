import java.util.stream.Stream;

import javafx.util.Pair;

public class Problem
{
	public static <T> T pickRandomElement(Stream<T> stream)
	{
		if (null == stream) return null;
		
		return stream.parallel()
			  .map((element) -> new Pair<Double, T>(Math.random(), element))
			  .reduce((lhs, rhs) -> lhs.getKey() > rhs.getKey() ? lhs : rhs)
			  .get()
			  .getValue();
	}
}