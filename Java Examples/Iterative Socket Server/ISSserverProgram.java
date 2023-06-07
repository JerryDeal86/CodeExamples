//Server Program

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;


public class ISSserverProgram
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);//create scanner object for user input
		
		int portNumber = getPortNumber(userInput);//assign port number
		
		runSocket(portNumber);//call and run the socket based in the selected port number
		
	}
	public static void runSocket(int portNumber)
	{
		try (ServerSocket serverSocket = new ServerSocket(portNumber))//create the server socket
		{
			System.out.println("Server is connected to port" + portNumber);//report connection
			long startTime = System.nanoTime();//mark time connection begins
			
			while(true)//run forever and list for client threads
				{
				
				runClient(serverSocket);//call method to process client and request
				
				}
		}
		catch(IOException ex)//catch IO exception
		{
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public static int getPortNumber(Scanner userInput)
	{
		boolean validPort = false;
		int portNumber = 0;
		while(!validPort)
		{
			System.out.print("Enter port number:");
			portNumber = Integer.parseInt(userInput.nextLine());
			if(portNumber > 1025 && portNumber < 4999)
			{
				validPort = true;
			}
			else
			{
				System.out.println("Invalid entry. Port number must be betwee 1025 and 4998.\n");
			}
		}
		return portNumber;
	}
	public static void runClient(ServerSocket serverSocket) throws IOException//method to process client or throw exception
	{
		//generate variables and assign them
		Socket socket = serverSocket.accept();//create a new socket and accept client
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));					
		PrintWriter writer = new PrintWriter(output, true);
		
		System.out.println("A new client has connected.");
		
		String command = reader.readLine();//get command for current client
		String commandResult = "";
		
		ProcessBuilder processBuilder = new ProcessBuilder();
		
		Process process;
		
		switch (command)//verify command and alter to linnux command if neccessary
		{
			case "date":
			case "uptime":
			case "netstat":
			case "users":
				break;
			case "memory":
				command = "free";
				break;
			case "processes":
				command = "ps -a";
				break;
			default:
				writer.println("Error: invalid command");
				return;
		}
		
		process = Runtime.getRuntime().exec(command);//execute linnux command and assign the return to the process object
		
		BufferedReader standardInput = new BufferedReader(new InputStreamReader(process.getInputStream()));//assign results from process input stream to a buffered reader object
		
		String string = standardInput.readLine();//assign first line of results to a string
		
		while (string != null)//loop through till buffered reader is empty
		{
			if(!commandResult.equals(""))//add a line for each line in results till buffered reader is empty
			{
				commandResult += '\n';
			}
			
			commandResult += string;//append current string to command results
			string = standardInput.readLine();//reassign string to next line in buffered reader
		}
		System.out.println(command);//print current command in server
		System.out.println(commandResult);//print the results in the server
		writer.println(commandResult);//send results back to client
		socket.close();//close the current socket
		
	}
}











