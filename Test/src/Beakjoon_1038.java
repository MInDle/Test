import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Beakjoon_1038
{	
	public static void main(String[] args)
	{
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		Scanner scanner = new Scanner(System.in);
		
		int num = 0;
		
		try
		{
			num = scanner.nextInt();
			
			getDownNumber(num);
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
	}
	

	public static void getDownNumber(int count)
	{
		if(count <= 10)
		{
			System.out.println(count);
			return;
		}

		String str = "";
		int len = 0;
		char ch = 0;
		boolean isDown;
		int downNumberCount = 10;
		long result = 0;
		
		long i = 20;

		while(true)
		{
			isDown = true;
			str = Integer.toString((int)i);
			len = str.length();

			for(int j = 0; j < len - 1; j++)
			{
				if(str.charAt(j) <= str.charAt(j + 1))
				{
					isDown = false;
					break;
				}
			}

			if(isDown)
			{
				downNumberCount++;
			}

			if(downNumberCount == count)
			{
				result = i;
				break;
			}

			i++;
		}

		System.out.println(result);

	}

}

	
	
