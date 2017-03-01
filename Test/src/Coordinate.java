//[Pre-Test 1차] 1번 문제
//
//여러 개의 1차원의 점을 표준 입력(standard input)에서 읽은 후, 그 중 가장 가까운 거리에 있는 두 점의 한 쌍을 출력하세요.
//단, 동일한 거리를 가지는 두 점이 여러 쌍인 경우, 합이 최소가 되는 한 쌍을 출력하세요.
//
//주어지는 입력은 10개 이하이며, 각각 10자리 이하의 자연수입니다.
//숫자는 공백으로만 구분됩니다.
//결과 출력 시, 예시와 동일하게 구분자로 공백 한 글자가 요구됩니다.
//올바른 출력은 하나의 문장이어야 하며, 문장의 마지막은 불필요한 공백문자 없이 newline(개행)으로 끝나야 합니다.
//예시
//
//입력이 6 20 34 8 38 40 인 경우
//가장 가까운 거리에 있는 두 점은 (6, 8), (38, 40)이며 합이 최소가 되는 쌍은 (6,8)이다. 따라서 결과는 다음과 같다. 
//6 8
//입/출력 예시
//⋇ 입출력 형식을 잘 지켜주세요.
//␣ : 공백↵ : 줄바꿈
//입력 1
//6 ␣20 ␣34 ␣8 ␣38 ␣406 20 34 8 38 40
//출력 1
//6 ␣8↵
//6 8



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Collections;

public class Coordinate 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        ArrayList<Integer> startIndex = new ArrayList<Integer>();
        ArrayList<Integer> endIndex = new ArrayList<Integer>();
        ArrayList<Integer> dist = new ArrayList<Integer>();
        int resultIndex;        
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String input = br.readLine();
            String[] numStrList = input.split(" ");
            for (String numStr : numStrList) 
            {
                numberList.add(Integer.parseInt(numStr));
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        int size = numberList.size();       
        for(int i = 0; i < size - 1; i++)
        {
        	for(int j = i + 1; j < size; j++)
        	{        		
        		dist.add(Math.abs(numberList.get(i) - numberList.get(j)));
        		
        		startIndex.add(i);
        		endIndex.add(j);
        	}
        }
        
        int minDist = dist.get(0);   
        size = dist.size();
        for(int i = 1; i < size; i++)
        {
        	if(minDist > dist.get(i))
        	{
        		minDist = dist.get(i);
        	}
        }
       
        ArrayList<Integer> minIndex = new ArrayList<Integer>();
        for(int i = 0; i < size; i++)
        {
        	if(minDist == dist.get(i))
        	{
        		minIndex.add(i);
        	}
        }
        
        ArrayList<Integer> sumList = new ArrayList<Integer>();
    	ArrayList<Integer> indexList = new ArrayList<Integer>();
    	
        size = minIndex.size();
        if(size > 1)
        {
        	for(int i = 0; i < size; i++)
        	{
        		sumList.add(numberList.get(startIndex.get(minIndex.get(i))) + numberList.get(endIndex.get(minIndex.get(i))));
        		indexList.add(i);
        	}
        	
        	int minSum = sumList.get(0);
        	int minSumIndex = 0;
        	size = sumList.size();
        	for(int i = 1; i < size; i++)
        	{
        		if(minSum > sumList.get(i))
        		{
        			minSum = sumList.get(i);
        			minSumIndex = i;
        		}
        	}        	
        	resultIndex = minSumIndex;
        	
        	System.out.println(numberList.get(startIndex.get(minIndex.get(indexList.get(resultIndex)))) + " " + numberList.get(endIndex.get(minIndex.get(indexList.get(resultIndex)))));
                        	 
        }
        else
        {
        	resultIndex = 0;
        	System.out.println(numberList.get(startIndex.get(minIndex.get(0))) + " " + numberList.get(endIndex.get(minIndex.get(0))));
             
        }   
        
    }
}