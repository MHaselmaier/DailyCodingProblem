import java.util.concurrent.ForkJoinPool;

public class Problem
{	
	public static void schedule(Runnable func, long delay)
	{
		long doNotRunBefore = System.currentTimeMillis() + delay;
		ForkJoinPool.commonPool().execute(() -> {
			do
			{
				try
				{
					Thread.sleep(doNotRunBefore - System.currentTimeMillis());
				} catch (Exception e) {}
			}
			while (System.currentTimeMillis() < doNotRunBefore);
			func.run();
		});
	}
}