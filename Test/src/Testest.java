import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Testest
{
	static int totalSize;
	static char[][] arr;

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
				result.append("\n");
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
		
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < totalSize; i++)
		{
			for (int j = 0; j < totalSize; j++)
			{
				result.append(arr[i][j]);
			}
			result.append("\n");
		}
		
		System.out.println(result.toString());
		System.out.println("==========================================================================================");
	}

}
