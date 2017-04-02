import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{	
	static StringBuilder result = new StringBuilder("");
	
	public static void main(String[] args)
	{
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		int size = 0;
		String[] inputStr = null;
		try
		{
			size = Integer.parseInt(reader.readLine());
			inputStr = new String[size];
			
			for(int i = 0; i < size; i++)
			{
				inputStr[i] = reader.readLine();
			}
			
			getVPS(size, inputStr);
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public static boolean getVPS(int size, String[] inputStr)
	{
		LinkedList<Character> stack = new LinkedList<Character>();
		int strSize = 0;
		char temp = 0;
		char popChar = 0;
		boolean isVPS = true;
		
		
		try
		{
			for(int i = 0; i < size; i++)
			{
				strSize = inputStr[i].length();
				
				for(int j = 0; j < strSize && isVPS; j++)
				{
					temp = inputStr[i].charAt(j);
					
					if(temp == '(')
					{
						stack.addLast(temp);
					}
					else
					{
						if(stack.isEmpty())
						{
							isVPS = false;
						}
						else
						{
							popChar = stack.removeLast();
							
							if(popChar == '(')
							{
								
							}
							else
							{
								isVPS = false;
							}
							
						}
						
					}

				}
				
				if(stack.size() != 0)
				{
					isVPS = false;
				}
				
				if(isVPS)
				{
					result.append("YES");
				}
				else
				{
					result.append("NO");
				}
				
				if(i < size - 1)
				{
					result.append("\n");
				}
				
				isVPS = true;
				stack = new LinkedList<Character>();
				
			}
			
			System.out.println(result.toString());
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return true;
	}
	
}