import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem
{
	private static int nextPointer = 1;
	private static Map<Object, Integer> objectToPointer = new HashMap<>();
	private static Map<Integer, Object> pointerToObject = new HashMap<>();
	
	public static int get_pointer(Object object)
	{
		if (Problem.objectToPointer.containsKey(object))
			return Problem.objectToPointer.get(object);
		
		Problem.objectToPointer.put(object, Problem.nextPointer);
		Problem.pointerToObject.put(Problem.nextPointer, object);
		return Problem.nextPointer++;
	}
	
	public static Object dereference_pointer(int pointer)
	{
		return Problem.pointerToObject.get(pointer);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many elements would you like to enter?");
		int size = sc.nextInt();
		sc.nextLine();
		XORLinkedList<String> list = new XORLinkedList<>();
		for (int i = 0; size > i; ++i)
		{
			System.out.println("Please enter element #" + (i + 1) + ":");
			list.add(sc.nextLine());
		}
		
		System.out.println("Please enter the index of the element you want to retreive:");
		int index = sc.nextInt();
		
		sc.close();
		
		System.out.println("The element at index " + index + " is " + list.get(index) + ".");
	}
}