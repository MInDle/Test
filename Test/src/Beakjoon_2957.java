import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Beakjoon_2957
{	
	static int count;
	static int[] arr = {0};
	static StringBuilder result = new StringBuilder("");
	
	public static void main(String[] args)
	{
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		
		
		try
		{
			count = Integer.parseInt(reader.readLine());
			arr = new int[count];
			
			for(int i = 0 ; i < count; i++)
			{
				arr[i] = Integer.parseInt(reader.readLine());
			}
			
			insertBinaryTree();
			
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public static void insertBinaryTree()
	{
		BinaryTree bt = new BinaryTree(new Node(arr[0]));
		Node newNode;
		
		for(int i = 1; i < count; i++)
		{
			newNode = new Node(arr[i]);
			result.append(bt.insert(newNode, bt.root));
			
			if(i != count - 1)
			{
				result.append("\n");
			}
		}
		
		System.out.println(result.toString());
	}
	
	
	
}

class BinaryTree
{
	Node root;
	int count;
	
	public BinaryTree()
	{
		
	}
	
	public BinaryTree(Node root)
	{
		this.root = root;
	}
	
	public int insert(Node newNode, Node root)
	{
		count++;
		
		if(root.getNumber() > newNode.getNumber())
		{
			if(root.getLeft() == null)
			{
				root.setLeft(newNode);
			}
			else
			{
				insert(newNode, root.getLeft());
			}
		}
		else
		{
			if(root.getRight() == null)
			{
				root.setRight(newNode);
			}
			else
			{
				insert(newNode, root.getRight());
			}
		}
		
		
		return count;
	}
}

class Node
{
	private Node left;
	private Node right;
	private int number;
	


	public Node()
	{
		left = null;
		right = null;
	}
	
	public Node(Node left, Node right, int number, int count)
	{
		this.left = left;
		this.right = right;
		this.number = number;
		
	}
	
	public Node(int number)
	{
		this();
		this.number = number;
	}

	public Node getLeft()
	{
		return left;
	}

	public void setLeft(Node left)
	{
		this.left = left;
	}

	public Node getRight()
	{
		return right;
	}

	public void setRight(Node right)
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

