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
			
			if(totalSize != 1)
			{
				drawStar10(0, 0, totalSize);
//				f2();

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
				
				System.out.print(result.toString());
			}
			else
			{
//				System.out.print("*");
			}
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public static void f2()
	{
		int x = 0, y = 0;
		int tempX, tempY;
		int size = 3;
		while(true)
		{			
			tempX = x;
			tempY = y;
			for(int i = 0; i < 8; i++)
			{
				switch (i)
				{
				case 1:
					y = tempY;
					x = tempX + size;
					break;
				case 2:
					y = tempY;
					x = tempX + (size * 2);
					break;
				case 3:
					y = tempY + size;
					x = tempX;
					break;
				case 4:
					y = tempY + (size * 2);
					x = tempX;
					break;
				case 5:
					y = tempY + (size * 2);
					x = tempX + size;
					break;
				case 6:
					y = tempY + size;
					x = tempX + (size * 2);
					break;
				case 7:
					y = tempY + (size * 2);
					x = tempX + (size * 2);
					break;
				default:
					break;
				}
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
			x = size;
			y = size;
			size += 3;
			
			if(size == totalSize)
			{
				break;
			}
			
		}
	}

	public static void drawStar10(int y, int x, int size)
	{
		if (size > 3)
		{
			drawStar10(y, x, size / 3);
			drawStar10(y, x + (size / 3), size / 3);
			drawStar10(y, x + (size / 3) * 2, size / 3);
			drawStar10(y + (size / 3), x, size / 3);
			drawStar10(y + (size / 3), x + (size / 3) * 2, size / 3);
			drawStar10(y + (size / 3) * 2, x, size / 3);
			drawStar10(y + (size / 3) * 2, x + (size / 3), size / 3);
			drawStar10(y + (size / 3) * 2, x + (size / 3) * 2, size / 3);
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