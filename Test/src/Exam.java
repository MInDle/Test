import java.util.Arrays;
import java.util.Vector;

public class Exam
{
	public final static int INF = 1000;
	public final static int N = 5;
	
	static int[][] LEN = new int[N][N];
	
	static{
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(LEN[i],  INF);
			LEN[0][1] = LEN[1][0] = 6;
			LEN[0][2] = LEN[2][0] = 2;
			LEN[1][2] = LEN[2][1] = 3;
			LEN[2][3] = LEN[3][2] = 3;
			LEN[1][3] = LEN[3][1] = 6;
			LEN[1][4] = LEN[4][1] = 4;
			LEN[3][3] = LEN[4][3] = 11;
		}
	}
	
	public static int[] dist = new int[N];
	
	static
	{
		Arrays.fill(dist, INF);
		
		
	}
	
	public static boolean[] visited = new boolean[N];
	static
	{
		Arrays.fill(visited, false);
	}
	
	public static int[] prev = new int[N];
	static
	{
		Arrays.fill(prev, 0);
	}
	
	static Vector<Integer> steps = new Vector<Integer>();
	
	public static int shortestPath(int start, int end)
	{
		if(start == end)
		{
			return dist[end];
		}
		
		visited[start] = true;
		
		int min = INF;
		
		for(int i = 0; i < N; i++)
		{
			if(LEN[start][i] != INF && visited[i] == false)
			{
				if(dist[i] > dist[start] + LEN[start][i])
				{
					dist[i] = dist[start] + LEN[start][i];
					prev[i] = start;
				}
				
				if(min == INF || dist[min] > dist[i])
				{
					min = i;
				}
			}
		}
		
		shortestPath(min, end);
		
		return 0;
	}
	
	public static void makingPath(int start, int end, int node)
	{
		if(node == start)
		{
			steps.add(node);
		}
		
		makingPath(start, end, prev[node]);
		steps.add(node);
	}
	
	public static void main(String[] args)
	{
		dist[0] = 0;
		
		shortestPath(0, N-1);
		makingPath(0, N - 1, N - 1);
		System.out.print("최종경로 = " );
        for(int node : steps){
            System.out.print(node + " ");
        }
        
        System.out.println();
        
        System.out.print("각 노드의 최적 누적거리 = ");
        for(int d : dist){
            System.out.print(d + " ");
        }
	}
}
