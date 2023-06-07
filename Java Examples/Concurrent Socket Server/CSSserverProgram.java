import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
import java.lang.Thread;
import java.util.ArrayList;

public class CSSserverProgram
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);//create scanner object for user input
		
		int portNumber = getPortNumber(userInput);//assign port number
		
		createSocket(portNumber);//call and run the method to create a server socket based on the selected port number
		
	}
	public static void createSocket(int portNumber)
	{
		try (ServerSocket serverSocket = new ServerSocket(portNumber))//create the server socket
		{
			int i = 0;
			System.out.println("Server is connected to port" + portNumber);//report connection
			long startTime = System.nanoTime();//mark time connection begins
			ArrayList<clientRequest> clientRequests = new ArrayList<clientRequest>();
			while(true)//run forever and listen for client threads
				{
					Socket socket = serverSocket.accept();//open a socket and accept the new client request
					clientRequests.add(new clientRequest("Request number" + (i + 1), socket));//add the new request to the array list and call method to generate a new self terminating thread
					i++;
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
	
}
class clientRequest extends Thread 
{
	Socket request;
	
	clientRequest(String name, Socket socket)
	{
		super(name);
		request = socket;
		this.start();
	}
	
	public void run()
	{
		try
		{
			//generate variables and assign them
			InputStream input = request.getInputStream();
			OutputStream output = request.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));					
			PrintWriter writer = new PrintWriter(output, true);
			
			System.out.println( getName() +  " is being processed");
			
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
			request.close();//close the current socket
		}
		catch (IOException ex)
		{
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		
	}
}










