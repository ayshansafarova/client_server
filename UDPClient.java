import java.io.*;
import java.net.*;

class UDPClient {
   public static int cPort = 789, sPort = 790;
   public static byte buf[] = new byte[1024];

     public static void main(String[] args) throws IOException {
         DatagramSocket cs = new DatagramSocket(cPort);
         DatagramPacket dp = new DatagramPacket(buf, buf.length);
         BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		 InetAddress a = InetAddress.getLocalHost();
		 
		 while(true)
		 {
		   String str = new String(r.readLine());
		   buf = str.getBytes();
		   if(str.equals("Stop!"))
		  {
		   System.out.println("Terminated...");
		   cs.send(new DatagramPacket(buf,str.length(), a, sPort));
		   break;
           }
           cs.send(new DatagramPacket(buf, str.length(), a, sPort));
		   cs.receive(dp);
		   String str2 = new String(dp.getData(), 0, dp.getLength());
		   System.out.println("Server: " + str2);
		 } 
		}
	}