import java.util.Scanner;

public class Dijkstra
{
	public static void main(String[] args)
	{
		final int MAX_SIZE = 9;
		final int MAX = 1000000000;
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = new int[MAX_SIZE][MAX_SIZE];
		int[] distance = new int[MAX_SIZE];
		boolean[] visited = new boolean[MAX_SIZE];
		int[] preD = new int[MAX_SIZE];
		int min = 0;
		int nextNode = 0;
		
		System.out.println("Enter the matrix : ");
		for(int i = 0; i < MAX_SIZE; i++)
		{
			visited[i] = false;
			preD[i] = 0;
			
			for(int j = 0; j < MAX_SIZE; j++)
			{
				matrix[i][j] = scanner.nextInt();
				if(matrix[i][j] == 0)
				{
					matrix[i][j] = MAX;
				}
			}
		}
		distance = matrix[0];
		distance[0] = 0;
		visited[0] = true;
		
		// start with the algorithm
		for(int i = 0; i < MAX_SIZE; i++)
		{
			min = MAX;
			for(int j = 0; j < MAX_SIZE; j++)
			{
				if(min > distance[j] && visited[j] != true)
				{
					min = distance[j];
					nextNode = j;
				}
			}
		}
		
		visited[nextNode] = true;
		
		// actual start of the algorithm
		for(int i = 0; i < MAX_SIZE; i++)
		{
			if(visited[i] != true)
			{
				if(min + matrix[nextNode][i] < distance[i])
				{
					distance[i] = min + matrix[nextNode][i];
					preD[i] = nextNode;
				}
			}
		}
		
		for(int i = 0; i < MAX_SIZE; i++)
		{
			System.out.print("|" + distance[i]);
		}
		System.out.println("|");
		
		// printing the paths;
		
		for(int i = 0; i < 5; ++i)
		{
			int j;
			System.out.println("Path : " + i);
			j = i;
			
			do
			{
				j = preD[j];
				System.out.print("<-" + j);
			}while(j != 0);
			
			System.out.println();		
				
		}
	}
}
