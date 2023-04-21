//Client Program


import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.lang.Thread;
import java.util.ArrayList;

public class ISSModularClientProgram
{
	public static void main (String [] args)
	{
		Scanner userInput = new Scanner(System.in); //Create scanner object to capture user input
		
		System.out.print("Host IP Address: ");
		String hostIpAddress = userInput.nextLine(); //get host IP Address
		
		System.out.print("Port: ");
		int port = Integer.parseInt(userInput.nextLine()); // Get port number for host IP Address
		
		String command = "";
		
		while(!command.equals("exit"))
		{
			
			command = recieveCommand(userInput); //call method to get the command to be performed
			
			if(!command.equals("exit"))
			{
				
				System.out.print("Number of simulated clients: "); 
				int amountOfClients = Integer.parseInt(userInput.nextLine());//Acquire number of clients to be tested
				ArrayList<Client> clientList = new ArrayList<Client>(amountOfClients);
				long runtime = 0;
			
				clientList = createClientList(amountOfClients, hostIpAddress, port, command); //create all client threads and assign them to an array list 
				
				for(int i = 0 ; i < clientList.size(); i++)
				{
					while(clientList.get(i).isAlive())
					{
						//loop to let all threads end and prevent outpacing
					}
				}
				printResults(clientList, runtime, amountOfClients); // Call method and pass it the array list runtime and the amount of clients
			}
			
		}
	}
	public static ArrayList<Client> createClientList(int amountOfClients, String hostIpAddress, int port, String command) //Generate an Array list containing all clients and return it
	{
		ArrayList<Client> clientList = new ArrayList<Client>();
		for(int i = 0; i < amountOfClients; i++)
		{
			clientList.add(new Client("Client " + (i+1), hostIpAddress, port, command, System.nanoTime()));//calls method to create new client, send it to the server and perform necessary actions, then add it to the arraylist
			
		}
		return clientList; // return the newly created array list
	}
	
	public static void printResults(ArrayList<Client> clientList, long runtime, int amountOfClients)
	{
		for(int i = 0 ; i < amountOfClients; i++)
		{
			
			long duration = clientList.get(i).runtime; //call method from client class to get the runtime for the current client
			
			System.out.println(clientList.get(i).getName() + " runtime: " + (duration/1000000) + " ms"); //print the client name and its runtime adjusted to milliseconds
			
			runtime += duration; //add current runtime to the duration
			
			System.out.println("Total runtime for " + (i + 1) + " clients: " + runtime/1000000 + " ms");//print the amount of clients  and their total runtime
			
			System.out.println("Average runtime: " + (runtime/1000000)/amountOfClients + " ms");//average the runtime between the clients
		
			
		}
	}
	public static String recieveCommand(Scanner userInput) //recieve the command from the user and verify that it is acceptable
	{
		boolean validCommand = false;
		String command = null;
		while(!validCommand) //loop until a valid command is entered
		{
			System.out.println("Available commands are:\n1.date\n2.uptime\n3.memory\n4.netstat\n5.users\n6.processes\n7.exit");
			System.out.print("Command to perform:");
			command = userInput.nextLine();// recieve the command and assing it to a string variable
			if(command.equals("date") || command.equals("uptime") || command.equals("memory") || command.equals("netstat") || command.equals("users") || command.equals("processes") || command.equals("exit"))
			{
				validCommand = true;
			}
			else
			{
				System.out.print("\nInvalid Entry, Please choose from available options.\n");
			}
		}
		return command; //return the verified command
	}
}


class Client extends Thread //generate a class that extends the thread type
{
	//declare variables
	String hostIP;
	int port;
	String command;
	long start = 0;
	long end = 0;
	long runtime = 0;
	
	//constructor for the class
	Client(String name, String hname, int portNumber, String c, long time)
	{
		super(name);
		hostIP = hname;
		port = portNumber;
		command = c;
		start = time;
		this.start();//calls run() method for client after its creation
	}
	
	public long getRuntime()//class method to generate runtime
	{
		if(end != 0)
		{
			return end - start;
		}
		else
		{
			return -1;
		}
	}
	
	public void run()//sends current client thread to the server to perform necessary actions and prints results of chosen command
	{
		try(Socket socket = new Socket(hostIP, port))//create a socket for each client
		{
			//generate necessary variables and assign them
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			writer.println(command);//sends the user input command
			
			String s = reader.readLine();
			String result = "";
			while(s != null)//loop through and add each line of the results from the server, dropping down one line for each string read
			{
				result = result + "\n" + s;
				s = reader.readLine();
			}
			System.out.println(this.getName() + " result: " + result);//print the results
			end = System.nanoTime();//adjust client time
			runtime = getRuntime();
		}
		catch(UnknownHostException ex)//catch server exception, incorrect server address
		{
			System.out.println("Server not found:" + ex.getMessage());
		}
		catch(IOException ex)//catch IO exception in current client thread
		{
			System.out.println("IOException in thread" + this.getName() + ":" + ex.getMessage());
		}
	}
}




