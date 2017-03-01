//[Pre-Test 1차] 2번 문제
//
//다음 단어를 표준 입력(standard input)에서 읽어서 모음이 연속 2개인 단어와 모음 이외의 알파벳이 연속 3개인 단어를 각각 찾아내서 그 갯수를 순서대로 출력하세요.
//
//주어지는 단어의 입력은 10개 이하이며, 20자 이하의 임의의 알파벳 소문자로 구성된 문자열입니다.
//단어는 공백으로만 구분됩니다.
//모음은 (a, e, i, o, u) 5가지만 해당됩니다.
//올바른 출력은 두 개의 문장이어야 하며, 각 문장의 마지막은 불필요한 공백문자 없이 newline(개행)으로 끝나야 합니다.
//예시
//
//입력이 toast standard bank display book일 경우 
//2개의 단어 toast와 book은 모음이 연속 2개(oa, oo)인 단어들이며, 1개의 단어 display는 모음 이외의 알파벳(spl)이 연속 3개인 단어이다. 따라서 결과는 다음과 같다. 
//2
//1
//입/출력 예시
//⋇ 입출력 형식을 잘 지켜주세요.
//␣ : 공백↵ : 줄바꿈
//입력 1
//toast ␣standard ␣bank ␣display ␣booktoast standard bank display book
//출력 1
//2↵
//1↵
//2
//1



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.sound.midi.Synthesizer;

public class CharacterSequence 
{
    public static void main(String[] args) 
    {
        String[] words = null; 
        final int VOW_MAX = 2;
        final int CONSO_MAX = 3;
        int vowMaxCount = 0;
        int consoMaxCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
        {
            String line = br.readLine();
            words = line.split(" ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
           
        for (String word : words)
        {
        	int size = word.length();
            int vowCount = 0;
            int consoCount = 0;
            boolean isVow = true;
            boolean isConso = true;
            
        	for(int i = 0; i < size; i++)
        	{
        		switch(word.charAt(i))
        		{
        		case 'a': case 'e': case 'i': case 'o': case 'u':
        			vowCount++;
        			if(vowCount == VOW_MAX)
                	{
                		vowMaxCount++;
                	}
        			consoCount = 0;
        			break;
        		default:
        			consoCount++;
        			if(consoCount == CONSO_MAX)
                	{
                		consoMaxCount++;
                	}
        			vowCount = 0;
        			break;
        		}
        		
        	}
        	
        }
        
        System.out.println(vowMaxCount);
        System.out.println(consoMaxCount);
        
    }
}