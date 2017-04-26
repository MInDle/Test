import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Beakjoon_1931
{	
	
	public static void main(String[] args)
	{
		Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		ArrayList<ConferenceInfo> array = new ArrayList<>();
		try
		{
			count = Integer.parseInt(reader.readLine());
			StringTokenizer token;
			
			for(int i = 0; i < count; i++)
			{
				token = new StringTokenizer(reader.readLine(), " ");
				array.add(new ConferenceInfo(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
			}
			
			getMaxConferenceCount(count, array);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void getMaxConferenceCount(int count, ArrayList<ConferenceInfo> array)
	{
		Collections.sort(array); // 끝나는 시간으로 정렬 (왜?)
		
		int start = array.get(0).getStart();
		int end = array.get(0).getEnd();
		int resultCount = 1;
		
		for(int i = 1; i < count; i++)
		{
			if(array.get(i).getStart() == array.get(i).getEnd()) // 시작시간과 끝나는 시간이 같으면 만족
			{
				resultCount++;
			}
			else if(array.get(i).getStart() >= end) // 마지막 회의 끝나는 시간이 지금 회의 시작시간보다 작으면
			{
				resultCount++;
				start = array.get(i).getStart();
				end = array.get(i).getEnd();
			}
		}
		
		System.out.println(resultCount);
	}
	
	
}

class ConferenceInfo implements Comparable<ConferenceInfo>
{
	private int start;
	private int end;
	private int gap;
	
	public ConferenceInfo()
	{
	}
	
	public ConferenceInfo(int start, int end)
	{
		this.start = start;
		this.end = end;
		gap = end - start;
	}
	
//	@Override
//	public int compareTo(ConferenceInfo c)
//	{
//		return this.gap - c.gap;
//	}
	
	@Override
	public int compareTo(ConferenceInfo c)
	{
		return this.end - c.end;
	}

	public int getStart()
	{
		return start;
	}

	public void setStart(int start)
	{
		this.start = start;
	}

	public int getEnd()
	{
		return end;
	}

	public void setEnd(int end)
	{
		this.end = end;
	}

	public int getGap()
	{
		return gap;
	}

	public void setGap(int gap)
	{
		this.gap = gap;
	}
	
	@Override
	public String toString()
	{
		return start + ", " + end + ", " + gap;
	}
	
	
}
	



	
