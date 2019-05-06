import java.util.Scanner;

public class Problem
{
	private int nextIndex = 0;
	private int[] lastOrderIds;
	
	public Problem(int n)
	{
		this.lastOrderIds = new int[n];
	}
	
	public void record(int order_id)
	{
		if (0 >= order_id)
			throw new IllegalArgumentException();
		
		this.lastOrderIds[this.nextIndex++] = order_id;
		this.nextIndex %= this.lastOrderIds.length;
	}
	
	public int get_last(int i)
	{
		if (0 >= i || this.lastOrderIds.length < i)
			throw new IndexOutOfBoundsException();
		
		int index = (this.nextIndex - i + this.lastOrderIds.length);
		index %= this.lastOrderIds.length;
		
		if (0 == this.lastOrderIds[index])
			throw new IndexOutOfBoundsException();
		
		return this.lastOrderIds[index];
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many order ids would you like to buffer?");
		Problem p = new Problem(sc.nextInt());
		sc.nextLine();
		
		System.out.println("How many order ids would you like to enter?");
		int orderIds = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; orderIds > i; ++i)
		{
			System.out.println("Please enter order id #" + (i + 1) + ":");
			p.record(sc.nextInt());
			sc.nextLine();
		}
		
		System.out.println("Which ith last order id would you like to retrieve?");
		int ithLastOrderId = sc.nextInt();
		
		sc.close();
		
		System.out.println("The ith last order id was " + p.get_last(ithLastOrderId) + ".");
	}
}