package demotcpserverText;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;



/**
 * This  server class will count the number of words in the
 *  text and returns it to the client..
 * 
 * @author Zaki ARMINDO
 *
 */
public class ServerTranslationApplication {
	
	public static void main(String[] args, String words) throws IOException{
		
		ServerSocket serverSocket = null;
		
		try {
			//Bind Server socket to a port
			int portNo = 4228;
			serverSocket = new ServerSocket(portNo); 
			
			String text1 = "Good Afternoon";
			System.out.println("Waiting for request");
			int count = 0;
			while(true) {
				
				//Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//Create stream to write data on the network 
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				//Send current data back to the client
				outputStream.writeUTF(text1);
				

				//call method 
				count=countWord(words);
			
				outputStream.writeInt(count);
				outputStream.flush();

				//Close the socket
				clientSocket.close();
			}
			
			
		}catch (IOException ioe) {
		
			if(serverSocket != null)
				serverSocket.close();
			
				ioe.printStackTrace();
		}
		
		
	}
	
	public static int countWord(String words)
	{
	 if(words.isBlank())
	 {
	 return 0;
	 }
	 
	 int count = 0;
	 
	 for(int index = 0;index<words.length() -1 ;index++)
	 {
	 if(words.charAt(index) == ' ' && words.charAt(index +1) != ' ')
	 {
	 count += 1;
	 }
	 }
	 return count + 1;
	}


}
