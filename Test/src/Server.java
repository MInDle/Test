import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

   public static int PORT = 7009;

   public static void main(String[] args) 
   {
      try 
      {
         ServerSocket server = new ServerSocket(PORT);
         System.out.println("서버 가동");
         try(Socket connection = server.accept())
         {
            //클라이언트에게 질문
            System.out.println(connection.getInetAddress() + " 와 연결");
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            out.write("언제 등교할거야? " + "\r\n");
            out.flush();
            System.out.println("서버 : 질문완료");
            
            //답변을 듣는다.
            BufferedReader in = new BufferedReader(
                  new InputStreamReader(connection.getInputStream()));
            
            String read = in.readLine();
             System.out.println("client의 답변 : " + read);

             
             //끝을 알린다
             out.write("알았어 그때보자." + "\r\n");
             out.flush();
             out.close();
         }
      } 
      catch (IOException e) 
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      

   }
}