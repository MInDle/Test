//[Pre-Test 1차] 4번 문제
//
//여러 개의 자연수를 표준 입력(standard input)에서 읽은 후, 그 수들을 이어붙여서 만들 수 있는 가장 큰 수와 가장 작은 수의 합을 구하세요.
//
//주어지는 입력은 10개 이하이며, 각각 2자리 이하의 자연수입니다.
//숫자는 공백으로만 구분됩니다.
//숫자를 이어붙일 때 입력된 각 숫자들을 반드시 한 번씩 사용해야 합니다.
//두번째 예시에 대해 주의깊게 살펴보시기 바랍니다.
//올바른 출력은 하나의 문장이어야 하며, 문장의 마지막은 불필요한 공백문자 없이 newline(개행)으로 끝나야 합니다.
//예시 1
//
//입력이 1 2 3일 경우, 만들 수 있는 가장 큰 수는 321이고 가장 작은 수는 123이며 두 수의 합은 444이다. 
//따라서 결과는 다음과 같다.
//444
//예시 2
//
//입력이 2 9 10 21 24일 경우, 
//만들 수 있는 가장 큰 수는 92422110이고, 가장 작은 수는 10212249이며 두 수의 합은 102634359
//따라서 결과는 다음과 같다. 
//102634359
//입/출력 예시
//⋇ 입출력 형식을 잘 지켜주세요.
//␣ : 공백↵ : 줄바꿈
//입력 1
//1 ␣2 ␣31 2 3
//출력 1
//444↵
//444
//
//입력 2
//2 ␣9 ␣10 ␣21 ␣242 9 10 21 24
//출력 2
//102634359↵
//102634359


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Coordinate2
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        ArrayList<Integer> minList = new ArrayList<Integer>();
        ArrayList<Integer> maxList = new ArrayList<Integer>();
        
//        ArrayList<Data> dataList  = new ArrayList<Data>();
        int sum = 0;
        
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
        Data[] dataList = new Data[size];
        for(int i = 0; i < size; i++)
        {
        	int num = numberList.get(i);
        	
        	int ten = num / 10;
        	int one = 0;
        	if(ten == 0)
        	{
        		one = num % 10;
        		dataList[i] = new Data(one, num, i);
        	}
        	else
        	{
        		dataList[i] = new Data(ten, num, i);
        	}        	
        	
        }
//        for(int i = 0; i < size; i++)
//        {
//        	System.out.println(dataList[i].number);
//        }
        
        size = dataList.length;
        for(int i = 1; i <size; i++)
        {
        	Data key = new Data();
        	key = dataList[i];
        	int j = i - 1;
        	
        	while(j >= 0 && dataList[j].ten < key.ten)
        	{
        		dataList[j + 1] = dataList[j];
        		j = j - 1;
        	}
        	dataList[j + 1] = key;
        }
      
        for(int i = 0; i < size; i++)
        {
        	System.out.println(dataList[i].number);
        }
        
        // 다음과 같은 방식으로 numberList와 number 변수를 사용할 수 있음
        /*
        for (Integer number : numberList) {
            System.out.println(number);
        }
        */       

    }
    
    public static class Data
    {
    	public int ten;
    	public int number;
    	public int index;
    	
    	public Data()
    	{
    		
    	}
    	
    	public Data(int ten, int number, int index)
    	{
    		this.ten = ten;
    		this.number = number;
    		this.index = index;
    	}
    }
}