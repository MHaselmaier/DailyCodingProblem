import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem
{
	public static List<String> getOriginalSentence(String input, Set<String> words)
	{
		if (null == input || null == words) return null;
		
		if (input.isEmpty()) return new ArrayList<>();
		
		for (String word: words)
		{
			if (input.startsWith(word))
			{
				List<String> result = getOriginalSentence(input.replaceFirst(word, ""), words);
				if (null != result)
				{
					result.add(0, word);
					return result;
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many words would you like to enter in the dictionary?");
		int wordsInDictionary = sc.nextInt();
		sc.nextLine();
		
		Set<String> words = new HashSet<>();
		for (int i = 0; wordsInDictionary > i; ++i)
		{
			System.out.println("Please enter word #" + (i + 1) + ":");
			words.add(sc.nextLine());
		}
		
		System.out.println("Please enter the sentence that should be reconstructed:");
		String input = sc.nextLine().replaceAll(" ", "");
		
		sc.close();
		
		List<String> result = getOriginalSentence(input, words);
		if (null != result)
		{
			System.out.println("The senctence could have been:");
			System.out.println(result);
		}
		else
		{
			System.out.println("No reconstruction possible!");
		}
	}
}