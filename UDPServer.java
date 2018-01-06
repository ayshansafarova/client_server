import java.io.*;
import java.net.*;

class UDPServer {
     public static int cPort = 789, sPort=790;
     public static byte buf[] = new byte[1024];

       public static void main(String[] args) throws IOException {
          DatagramSocket ds = new DatagramSocket(sPort);
          DatagramPacket dp = new DatagramPacket(buf,buf.length);
          BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		  InetAddress a = InetAddress.getLocalHost();
           
		   while(true)
         {
           ds.receive(dp);
           String str = new String(dp.getData(), 0, dp.getLength());
           if(str.equals("Stop!"))
            { 
              System.out.println("Terminated...");
              break;
            }
			
          System.out.println("Client: " + str);
          String str1 = new String(r.readLine());
          buf = str1.getBytes();
          ds.send(new DatagramPacket(buf,str1.length(), a, cPort));
	     }
        }
    }