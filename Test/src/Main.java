import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{	
	static int count;
	static int[] inArray;
	static int[] postArray;
	static Node2 root;
	static int nodeCount = 1;
	
	static StringBuilder result = new StringBuilder("");
	
	public static void main(String[] args)
	{
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
				
		
		try
		{
			count = Integer.parseInt(reader.readLine());
			
			
			
			if(count != 1)
			{
				inArray = new int[count];
				postArray = new int[count];
				int i = 0;
				StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
				
				while(token.hasMoreTokens())
				{
					inArray[i++] = Integer.parseInt(token.nextToken());
				}
				
				token = new StringTokenizer(reader.readLine());
				
				i = 0;
				while(token.hasMoreTokens())
				{
					postArray[i++] = Integer.parseInt(token.nextToken());
				}
				
				
				root = new Node2(postArray[count - 1]);
				makeTree(inArray, postArray, root);
				
				result = new StringBuilder("");
				preOrder(root);				
				System.out.println((result.toString()).trim());
				
//				result = new StringBuilder("");
//				inOrder(root);
//				System.out.println(result.toString());
//				
//				result = new StringBuilder("");
//				postOrder(root);
//				System.out.println(result.toString());
			}
			else
			{
				System.out.println(reader.readLine());
			}
			
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public static void preOrder(Node2 root)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			result.append(root.getNumber() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	public static void inOrder(Node2 r)
	{
		if(r == null)
		{
			return;
		}
		else
		{
			
			inOrder(r.getLeft());
			result.append(r.getNumber() + " ");
			inOrder(r.getRight());
		}
	}
	
	public static void postOrder(Node2 r)
	{
		if(r == null)
		{
			return;
		}
		else
		{
			
			postOrder(r.getLeft());
			postOrder(r.getRight());
			result.append(r.getNumber() + " ");
		}
	}
	
	public static void makeTree(int[] inArray, int[] postArray, Node2 newNode)
	{
		int rightIndex = 0;
		for(int i = 0; i < count; i++)
		{
			if(inArray[count - 1] == postArray[i])
			{
				rightIndex = i;
				break;
			}
		}
		
		for(int i = rightIndex - 1; i >= 0; i--)
		{
			insertNode(root, postArray[i]);
		}
		
		for(int i = count - 2; i >= rightIndex; i--)
		{
			insertNode(root, postArray[i]);
		}
	}
	
	public static void insertNode(Node2 r, int number)
	{
//		System.out.print(number + " ");
		if(r.getNumber() > number)
		{
//			System.out.println("left");
			if(r.getLeft() == null)
			{
				r.setLeft(new Node2(number));
			}
			else
			{
				insertNode(r.getLeft(), number);
			}
		}
		else
		{
//			System.out.println("right");
			if(r.getRight() == null)
			{
				r.setRight(new Node2(number));
			}
			else
			{
				insertNode(r.getRight(), number);
			}
		}
	}
}

class Node2
{
	private Node2 left;
	private Node2 right;
	int number;
	
	public Node2()
	{
		left = right = null;
		// TODO Auto-generated constructor stub
	}
	
	public Node2(int number)
	{
		this();
		this.number = number;
	}

	public Node2 getLeft()
	{
		return left;
	}

	public void setLeft(Node2 left)
	{
		this.left = left;
	}

	public Node2 getRight()
	{
		return right;
	}

	public void setRight(Node2 right)
	{
		this.right = right;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}
}

	
	
