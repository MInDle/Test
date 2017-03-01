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
         
         //서버에게 한문장 읽어오기
         BufferedReader in = new BufferedReader(
               new InputStreamReader(socket.getInputStream()));
         
         String read = in.readLine();
         System.out.println("서버 : " + read);
         
         //답변하기
         String answer;
         answer = new Scanner(System.in).nextLine();
         Writer out = new OutputStreamWriter(socket.getOutputStream());
         out.write(answer + "\r\n");
         out.flush();
         
         //마지막 대답 듣기
         read = in.readLine();
         System.out.println("서버 : " + read);
       }
       catch(IOException e)
       {e.printStackTrace();}
   }
}