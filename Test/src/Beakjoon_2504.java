import java.util.*;

import jdk.nashorn.internal.ir.CatchNode;

import java.io.*;
import java.math.BigInteger;

public class Beakjoon_2504
{	
	final static boolean isLog = true;
	
	final static int PARENTHESIS = 2;
	final static int BRACKET = 3;
	

	public static void log(String str)
	{
		if(isLog)
		{
			System.out.println(str);
		}
	}
	
	public static void main(String[] args)
	{
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		Scanner scanner = new Scanner(System.in);
		
		String str = null;
		
		try
		{
			str = reader.readLine();
			getBracketValue(str);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void getBracketValue(String str)
	{
		LinkedList<Character> stack = new LinkedList<Character>();
		int len = str.length();
		int value = 0;
		int tempResult = 1;
		char ch = 0;
		char temp = 0;
		int result = 0;
		boolean isNew = false;
		
		try
		{
			for(int i = 0; i < len; i++)
			{
				ch = str.charAt(i);
				isNew = false;
				
				if(ch == '(' || ch == '[')
				{
					if(stack.isEmpty())
					{
						isNew = true;
					}
					stack.addLast(ch);
					
				}
				else
				{
					switch(ch)
					{
					case ')':
						if(stack.removeLast() != '(')
						{
							System.out.println(0);
							return;
						}
						value = PARENTHESIS;
						break;
					case ']':
						if(stack.removeLast() != '[')
						{
							System.out.println(0);
							return;
						}
						value = BRACKET;
						break;
					}
					if(isNew)
					{
						tempResult *= value;
					}
					else
					{
						tempResult += value;
					}

					log("tempResult: " + tempResult + ", " + value);
					
				}
				log(Arrays.toString(stack.toArray()));
				
				if(stack.isEmpty())
				{
					result += tempResult;
					tempResult = 1;
					log("result : " + result);
				}
			}
			
			if(!stack.isEmpty())
			{
				System.out.println(0);
			}
			else
			{
				System.out.println(result);
			}
			
		} catch (Exception e)
		{
			System.out.println(0);
		}
	}
	
}

	



	
