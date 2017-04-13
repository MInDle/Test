import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Beakjoon_10815
{	
	static int countA;
	static int countB;
	
	static int[] arrayA;
	static int[] arrayB;
	
	static StringBuilder result = new StringBuilder("");
	
	public static void main(String[] args)
	{
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
				
		try
		{
			countA = Integer.parseInt(reader.readLine());
			arrayA = new int[countA];
			int a = 0;
			StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
			while(token.hasMoreTokens())
			{
				arrayA[a++] = Integer.parseInt(token.nextToken());
			}
			a = 0;
			
			countB = Integer.parseInt(reader.readLine());
			arrayB = new int[countB];
			token = new StringTokenizer(reader.readLine(), " ");
			while(token.hasMoreTokens())
			{
				arrayB[a++] = Integer.parseInt(token.nextToken());
			}
		
			Arrays.sort(arrayA);
			
			solve2();
			
			System.out.println(result.toString());
			
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	
	public static void solve()
	{
		int temp = 0;
		for(int i = 0; i < countB; i++)
		{
			temp = Arrays.binarySearch(arrayA, arrayB[i]);
			if(temp < 0)
			{
				result.append(0 + " ");
			}
			else
			{
				result.append(1 + " ");
			}
		}
	}
	
	public static int getMiddle(int start, int end)
	{
		int temp = (end - start) / 2;
		
		return temp;
		
	}
	
	public static void solve2()
	{		
		for(int i = 0; i < countB; i++)
		{
			int temp = binarySearch(arrayB[i]);
			System.out.println(temp);
			if(temp == -1)
			{
				result.append(0 + " ");
			}
			else
			{
				result.append(1 + " ");
			}
		}
	}
	
	public static int binarySearch(int value)
	{
		System.out.print(value + " ");

		int middle = 0;
		int start = 0, end = countA;
		
		while(start <= end)
		{
			middle = (start + end) / 2;
			
			if(arrayA[middle] == value)
			{
				return middle;
			}
			else if(value > arrayA[middle])
			{
				start = middle + 1;
			}
			else
			{
				end = middle - 1;
			}
		}
		
		return -1;
	}
	
}

	
	
