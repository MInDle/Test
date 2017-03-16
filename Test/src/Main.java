import java.util.*;
import java.io.*;
import java.math.BigInteger;

/*
 * home desktop
 */
public class Main
{
	static int[][] array;
	static int size;
	static StringBuilder result = new StringBuilder("");

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		try
		{
			size = Integer.parseInt(reader.readLine());
			array = new int[size][size];
			String numbers = "";
			
			for(int i = 0; i < size; i++)
			{
				numbers = reader.readLine();
				
				for(int j = 0; j < size; j++)
				{
					array[i][j] = numbers.charAt(j) - '0';
				}
			}
			
			getQuadNumber(0, 0, size, size);
			System.out.println(result.toString());

		} catch (Exception e)
		{
			// TODO: handle exception
		}

	}
	
	public static boolean checkAll(int startI, int startJ, int endI, int endJ)
	{
		int first = -1;
		int next = -1;
		
		first = array[startI][startJ];
		
		for(int i = startI; i < endI; i++)
		{
			for(int j = startJ; j < endJ; j++)
			{
				next = array[i][j];
				
				if(first != next)
				{
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static void getQuadNumber(int startI, int startJ, int endI, int endJ)
	{
		int first =0;
		int next = 0;
		int subStartI = 0, subStartJ = 0, subEndI = 0, subEndJ = 0;		
		boolean isContinue = true;
		int gap = (endI - startI) / 2;
				
//		if(startI + 1 == endI)
//		{
//			result.append(array[startI][startJ]);
//			return;
//		}
		
		result.append("(");
		
		if(checkAll(startI, startJ, endI, endJ))
		{
			result.append(array[startI][startJ]);
		}
		else
		{
			for(int k = 0; k < 4; k++)
			{
				isContinue = true;
				
				switch(k)
				{
				case 0:
					subStartI = startI;
					subStartJ = startJ;
					subEndI = endI - gap;
					subEndJ = endJ - gap;
					break;
				case 1:
					subStartI = startI;
					subStartJ = endJ - gap;
					subEndI = endI - gap;
					subEndJ = endJ;
					break;
				case 2:
					subStartI = endI - gap;
					subStartJ = startJ;
					subEndI = endI;
					subEndJ = endJ - gap;
					break;
				case 3:
					subStartI = endI - gap;
					subStartJ = endJ - gap;
					subEndI = endI;
					subEndJ = endJ;
					break;
				default:
						
				}
//				System.out.println(subStartI + ", " + subEndI + ", " + subStartJ + ", " + subEndJ);
				first = array[subStartI][subStartJ];
				
				for(int i = subStartI; i < subEndI; i++)
				{
					if(!isContinue)
					{
						break;
					}
					
					for(int j = subStartJ; j < subEndJ; j++)
					{
						next = array[i][j];
						
						if(first != next)
						{
							getQuadNumber(subStartI, subStartJ, subEndI, subEndJ);
							isContinue = false;
							break;
						}
					}
				}
				
				if(isContinue)
				{
					result.append(first);
//					System.out.println(result.toString());
				}
				
			}
		}
		
		result.append(")");
	}
}