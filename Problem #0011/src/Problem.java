import java.util.Scanner;

public class Problem
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many words would you like to enter in the dictionary?");
		int amtWords = sc.nextInt();
		sc.nextLine();
		
		TreeDictionary dict = new TreeDictionary();
		for (int i = 0; amtWords > i; ++i)
		{
			System.out.println("Please enter word #" + (i + 1) + ":");
			dict.enterWord(sc.nextLine());
		}
		
		System.out.println("Enter the word you would like to have completed:");
		String toComplete = sc.nextLine();
		
		sc.close();
		
		System.out.println("Your word could be completed to one of these:");
		System.out.println("\t" + dict.completeWord(toComplete));
	}
}