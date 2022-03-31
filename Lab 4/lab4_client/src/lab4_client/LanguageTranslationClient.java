package lab4_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class LanguageTranslationClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//Connect to the server at localhost for port 4228
			Socket socket = new Socket(InetAddress.getLocalHost(),4228);
			
			//Create input object
			Scanner sc = new Scanner(System.in);
			
			//create output stream,
			DataOutputStream outputStream = new
			DataOutputStream(socket.getOutputStream());
			
			//Display
			System.out.println("----------------------------------------------");
			System.out.println("\t Client Side");
			System.out.println("----------------------------------------------");
			System.out.println(" ");
			//Input From User
			System.out.print("Enter Words In English: ");
			String text =(sc.nextLine());
			//send data to server
			outputStream.writeUTF(text);
			outputStream.flush();
			
			//create input stream
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			
			//assign object to read data from server
			String translatedText = dataIn.readUTF();
			System.out.println("\nTranslated text: " );
			System.out.println("\nMalay      Arabic     Korean");
			
			//print translated text sent from server
			System.out.println(translatedText);
			
			//Close everything
			outputStream.close();
			sc.close();
			socket.close();
			dataIn.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}


	}

}
