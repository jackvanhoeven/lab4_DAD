package demotcpclientText;

import java.io.*; 
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;



/**
* This is client side application
* 
* @author Zaki ARMINDO
*
*/
public class ClientTranslationApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			//Connect to the server at localhost, port 4228
			Socket socket = new Socket(InetAddress.getLocalHost(),4228);
					
			//Create input stream
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//Read from the network and display the date
			String text = bufferedReader.readLine();
			System.out.println(text);
			
			//Close everything
			bufferedReader.close();
			
			socket.close();
			
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}

	}

}
