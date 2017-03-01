//[Pre-Test 1차] 3번 문제
//
//하나의 자연수를 표준 입력(standard input)에서 읽어서 앞뒤 어느 쪽에서 읽어도 동일한 값을 가질 때까지 다음과 같이 정의된 rev_plus 연산을 반복 수행하여 결과를 출력하세요.
//
//rev_plus 연산이란, 하나의 자연수에 대해서, 그 수를 뒤집은 다음 뒤집어진 수를 원래의 수에 더하는 것으로 정의합니다.
//
//rev_plus: 195 + 591 = 786
//반복 수행의 종료 조건은 결과로 좌우 대칭인 수가 만들어지는 경우입니다.
//예외적으로 다음과 같은 경우에 연산을 멈추고 -1을 출력해야 합니다.
//연산 횟수가 3회에 도달했지만, 수행 결과가 좌우 대칭이 아닌 경우
//주어지는 입력은 3자리 이하의 자연수입니다.
//올바른 출력은 하나의 문장이어야 하며, 문장의 마지막은 불필요한 공백문자 없이 newline(개행)으로 끝나야 합니다.
//예시 1
//
//입력이 57인 경우, 
//1회 rev_plus: 57 + 75 = 132
//2회 rev_plus: 132 + 231 = 363
//363은 앞뒤 어느 쪽에서 읽어도 같은 값을 가지므로, 결과는 다음과 같다.
//363
//예시 2
//
//입력이 78인 경우,
//1회 rev_plus: 78 + 87 = 165
//2회 rev_plus: 165 + 561 = 726
//3회 rev_plus: 726 + 627 = 1353
//3회까지의 연산 값은 1353이며 앞뒤에서 읽은 값이 같지 않으므로 연산을 멈추고 결과는 다음과 같다.
//-1
//입/출력 예시
//⋇ 입출력 형식을 잘 지켜주세요.
//␣ : 공백↵ : 줄바꿈
//입력 1
//5757
//출력 1
//363↵
//363
//
//입력 2
//7878
//출력 2
//-1↵
//-1


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevPlus
{
    public static void main(String[] args) 
    {
        int number = 0;
        int result = 0;
        final int MAX = 3;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
        {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        
        
        
        for(int i = 0; i < MAX; i++)
        {
        	String num = String.valueOf(number);
        	int size = num.length();
        	String temp = "";
        	int sum = 0;
        	String sumStr = "";
        	
        	temp = reverse(num);
        	
        	sum = number + Integer.parseInt(temp);
        	sumStr = String.valueOf(sum);
        	temp = reverse(sumStr);
        	if(sumStr.equals(temp))
        	{
        		result = Integer.parseInt(sumStr);
        		break;
        	}
        	else
        	{
        		number = sum;
        	}
        	
        }
        
        if(result == 0)
        {
        	result = -1;
        }
        System.out.println(result);
    }
    
    public static String reverse(String str)
    {
    	String temp = "";
    	int size = str.length();
    	for(int k = size - 1; k >= 0; k--)
    	{
    		temp += str.charAt(k);   		
    		
    	}
    	return temp;
    }
}