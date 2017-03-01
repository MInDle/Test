import java.util.Scanner;

public class Dijkstra2
{
	public static void main(String[] args)
	{

		final int MAX = 100000000;
		final int MAX_SIZE = 6;
		int s, e, min = 0, nextNode = 0;
		boolean[] visited = new boolean[MAX_SIZE];
		int[] distance = new int[MAX_SIZE];
		int[] via =  new int[MAX_SIZE];
		int[][] data = {
				{0,2,1,MAX,MAX,MAX},
				{5,0,MAX,1,MAX,MAX},	
				{4,MAX,0,3,1,MAX},
				{MAX,2,2,0,MAX,3},
				{MAX,MAX,5,MAX,0,2},
				{MAX,MAX,MAX,1,3,0}
		};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Start : ");
		s = scanner.nextInt();
		System.out.println("End : ");
		e = scanner.nextInt();
		
		for(int i = 0; i < MAX_SIZE; i++)
		{
			visited[i] = false;
			distance[i] = MAX;
		}
		
		distance[s - 1] = 0;
		for(int i = 0; i < MAX_SIZE; i++)
		{			
			min = MAX;
			for(int j = 0; j < MAX_SIZE; j++)
			{
				if(visited[j] == false && distance[j] < min)
				{
					nextNode = j;
					min = distance[j];
					System.out.println("min : " + min + ", nextNode : " + nextNode);
				}
			}
			
			visited[nextNode] = true;
			
			if(min == MAX)
			{
				break;
			}
			
			for(int j = 0; j < MAX_SIZE; j++)
			{
				if(distance[j] > distance[nextNode] + data[nextNode][j])
				{
					distance[j] = distance[nextNode] + data[nextNode][j];
					via[j] = nextNode;
					System.out.println("via, distance " + j + " : " + via[j] + ", " + distance[j]);
				}
			}			
			System.out.println("--------------------------------");
		}
		
		System.out.printf("Start : %d, End : %d, distance %d\n",s, e, distance[e - 1]);
		int[] path = new int[MAX_SIZE];
		int pathCount = 0;
		nextNode = e - 1;
		
		while(true)
		{
			path[pathCount++] = nextNode;
			
			if(nextNode == s - 1)
			{
				break;
			}
			
			nextNode = via[nextNode];
			
			System.out.print("Path : ");
			for(int i = pathCount; i >= 0; i--)
			{
				System.out.printf("%d -> ", path[i] + 1);
			}
			System.out.println();
//			System.out.printf("%d ..", path[i] + 1);
		}
		
	
	}
}
