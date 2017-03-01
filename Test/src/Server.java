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
         System.out.println("���� ����");
         try(Socket connection = server.accept())
         {
            //Ŭ���̾�Ʈ���� ����
            System.out.println(connection.getInetAddress() + " �� ����");
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            out.write("���� ��Ұž�? " + "\r\n");
            out.flush();
            System.out.println("���� : �����Ϸ�");
            
            //�亯�� ��´�.
            BufferedReader in = new BufferedReader(
                  new InputStreamReader(connection.getInputStream()));
            
            String read = in.readLine();
             System.out.println("client�� �亯 : " + read);

             
             //���� �˸���
             out.write("�˾Ҿ� �׶�����." + "\r\n");
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