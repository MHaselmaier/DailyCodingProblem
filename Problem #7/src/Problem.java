import java.util.Scanner;

public class Problem
{
	public static int countPossibleMessages(String encodedMessage)
	{
		return countPossibleMessages(encodedMessage, 0);
	}
	
	private static int countPossibleMessages(String encodedMessage, int currentIndex)
	{
		if (null == encodedMessage || encodedMessage.length() < currentIndex)
			return 0;
		if (encodedMessage.length() == currentIndex)
			return 1;
		
		char currentChar = encodedMessage.charAt(currentIndex);
		char nextChar = Character.MAX_VALUE;
		if (encodedMessage.length() > currentIndex + 1)
			nextChar = encodedMessage.charAt(currentIndex + 1);
		if ('0' == currentChar)
			return 0;
		
		int totalCount = 0;
		totalCount += countPossibleMessages(encodedMessage, currentIndex + 1);
		if ('1' == currentChar || ('2' == currentChar && '6' >= nextChar))
			totalCount += countPossibleMessages(encodedMessage, currentIndex + 2);
		
		return totalCount;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter an encoded message for which the count\n"
				+ "of possible initial messages should be calculated:");
		String message = sc.nextLine();
		
		sc.close();
		
		System.out.println("There are " + countPossibleMessages(message) + " possible ways to decode the message.");
	}
}