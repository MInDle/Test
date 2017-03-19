import java.util.*;
import java.io.*;
import java.math.BigInteger;

/*
 * i got it!!!!
 * also i got it!!!!
 * really ?!?!?!?!?!?
 */
public class Main
{	
	static int totalSize;
	static char[][] arr;
	static int count = 0;

	public static void main(String[] args)
	{
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		try
		{
			totalSize = Integer.parseInt(reader.readLine());
			arr = new char[totalSize][totalSize];
			f(0, 0, totalSize);

			StringBuilder result = new StringBuilder("");
			for (int i = 0; i < totalSize; i++)
			{
				for (int j = 0; j < totalSize; j++)
				{
					result.append(arr[i][j]);
				}
				
				if(i + 1 != totalSize)
				{
					result.append("\n");
				}
			}
			
			System.out.println(result.toString());
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}

	public static void f(int y, int x, int size)
	{
		if (size > 3)
		{
			f(y, x, size / 3);
			f(y, x + (size / 3), size / 3);
			f(y, x + (size / 3) * 2, size / 3);
			f(y + (size / 3), x, size / 3);
			f(y + (size / 3), x + (size / 3) * 2, size / 3);
			f(y + (size / 3) * 2, x, size / 3);
			f(y + (size / 3) * 2, x + (size / 3), size / 3);
			f(y + (size / 3) * 2, x + (size / 3) * 2, size / 3);
		} else
		{
			arr[y][x] = '*';
			arr[y][x + 1] = '*';
			arr[y][x + 2] = '*';
			arr[y + 1][x] = '*';
			/* arr[y+1][x+1]=' '; */
			arr[y + 1][x + 2] = '*';
			arr[y + 2][x] = '*';
			arr[y + 2][x + 1] = '*';
			arr[y + 2][x + 2] = '*';
		}
		
		
	}
}