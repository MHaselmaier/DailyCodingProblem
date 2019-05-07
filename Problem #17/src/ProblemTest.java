import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest
{
	@Test
	void testExampleFromProblem1()
	{
		String fileSystem = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		assertEquals(32, Problem.getLongestAbsolutPathToFile(fileSystem));
	}
	
	@Test
	void testExampleFromProblem2()
	{
		String fileSystem = "dir\n\tsubdir1\n\\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2";
		assertEquals(0, Problem.getLongestAbsolutPathToFile(fileSystem));
	}
	
	@Test
	void testNullFileSystem()
	{
		assertEquals(0, Problem.getLongestAbsolutPathToFile(null));
	}
	
	@Test
	void testEmptyFileSystem()
	{
		String fileSystem = "";
		assertEquals(0, Problem.getLongestAbsolutPathToFile(fileSystem));
	}
}