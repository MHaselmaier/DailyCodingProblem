import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Problem
{
	public static <T, U, R> Function<BiFunction<T, U, R>, R>  cons(T a, U b)
	{
		
		return (f) -> f.apply(a, b);
	}
	
	@SuppressWarnings("unchecked")
	public static <T, U, R> T car(Function<BiFunction<T, U, R>, R> cons)
	{
		return (T)cons.apply((a, b) -> (R)a);
	}
	
	@SuppressWarnings("unchecked")
	public static <T, U, R> U cdr(Function<BiFunction<T, U, R>, R> cons)
	{
		return (U)cons.apply((a, b) -> (R)b);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the first element of your pair:");
		String first = sc.nextLine();
		
		System.out.println("Please enter the second element of your pair:");
		String second = sc.nextLine();
		
		sc.close();
		
		System.out.println("The first element of your pair is " + car(cons(first, second)) + ".");
		System.out.println("The second element of your pair is " + cdr(cons(first, second)) + ".");
	}
}