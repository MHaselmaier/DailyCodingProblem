import java.util.Scanner;

public class Problem
{
	public static <T> LinkedList<T> intersectionNode(LinkedList<T> a, LinkedList<T> b)
	{
		int sizeOfA = getSize(a);
		int sizeOfB = getSize(b);
		
		int currentA = 0;
		int currentB = 0;
		
		while (sizeOfA - sizeOfB > currentA)
		{
			a = a.next;
			++currentA;
		}
		while (sizeOfB - sizeOfA > currentB)
		{
			b = b.next;
			++currentB;
		}
		
		LinkedList<T> intersection = null;
		for (int i = currentA; sizeOfA > i; ++i)
		{
			if (!a.value.equals(b.value))
				intersection = null;
			else if (null == intersection)
				intersection = a;
			
			a = a.next;
			b = b.next;
		}
		
		return intersection;
	}
	
	private static<T> int getSize(LinkedList<T> a)
	{
		int size = 0;
		
		while (null != a)
		{
			++size;
			a = a.next;
		}
		
		return size;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many elements should the first list have?");
		int sizeA = sc.nextInt();
		sc.nextLine();
		
		LinkedList<String> a = null;
		for (int i = 0; sizeA > i; ++i)
		{
			System.out.println("Please enter the " + (sizeA - i) + "th element of the first list:");
			a = new LinkedList<>(sc.nextLine(), a);
		}
		
		System.out.println("How many elements should the second list have?");
		int sizeB = sc.nextInt();
		sc.nextLine();
		
		LinkedList<String> b = null;
		for (int i = 0; sizeB > i; ++i)
		{
			System.out.println("Please enter the " + (sizeB - i) + "th element of the second list:");
			b = new LinkedList<>(sc.nextLine(), b);
		}
		
		sc.close();
		
		LinkedList<String> intersection = intersectionNode(a, b);
		if (null != intersection)
		{
			System.out.println("The intersecting point has the value: " + intersection.value + ".");
		}
		else
		{
			System.out.println("There is no intersecting point!");
		}
	}
}