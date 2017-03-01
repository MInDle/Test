import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Client 
{
   public static int PORT = 7009;
   public static void main(String[] args) 
   {
      String address = "192.168.168.100";
       Socket socket = null;
       try 
       {
         socket = new Socket(address, PORT);
         socket.setSoTimeout(3000);
         
         //�������� �ѹ��� �о����
         BufferedReader in = new BufferedReader(
               new InputStreamReader(socket.getInputStream()));
         
         String read = in.readLine();
         System.out.println("���� : " + read);
         
         //�亯�ϱ�
         String answer;
         answer = new Scanner(System.in).nextLine();
         Writer out = new OutputStreamWriter(socket.getOutputStream());
         out.write(answer + "\r\n");
         out.flush();
         
         //������ ��� ���
         read = in.readLine();
         System.out.println("���� : " + read);
       }
       catch(IOException e)
       {e.printStackTrace();}
   }
}