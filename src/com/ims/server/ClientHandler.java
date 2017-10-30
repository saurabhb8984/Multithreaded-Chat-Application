package com.ims.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

	BufferedReader reader;
	Socket sock;
	PrintWriter client;
	ServerUI serverUI;
	ServerSocketHandler socketHandler;
	public ClientHandler(Socket clientSocket, PrintWriter user,ServerUI logserverUI,ServerSocketHandler serverSocketHandler) 
	{
		client = user;
		socketHandler = serverSocketHandler;
		serverUI = logserverUI;
		try 
		{
			InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
			reader = new BufferedReader(isReader);
		}
		catch (Exception ex) 
		{
			serverUI.serverlog("Unexpected error... \n");
		}

	}

	@Override
	public void run() 
	{
		String message, connect = "Connect",connectTo="ConnectTo", disconnect = "Disconnect", chat = "Chat";
		String[] data;
		try 
		{
			
			while ((message = reader.readLine()) != null) 
			{
				serverUI.serverlog("Received: " + message + "\n");
				if(message.contains(connect)||message.contains(connectTo)||message.contains(disconnect)||message.contains(chat)){
				 
					data = message.split(":");

					if (data[2].equals(connect)) 
					{
						if(socketHandler.usernameAlreadyExists(data[0])){
							client.println("Username Not available:ServerInfo");
							client.flush();
						}
						else{
							socketHandler.userAdd(data[0],client);
						}
					} 
					else if(data[2].equals(connectTo))
					{
						if(!socketHandler.usernameAlreadyExists(data[1]) || socketHandler.checkIfUserIsConnected(data[1])){
							PrintWriter writer = socketHandler.getUserStream(data[0]);
							writer.println("User Not available:ServerInfo");
							writer.flush();
						}else{
							PrintWriter fromwriter = socketHandler.getUserStream(data[0]);
							fromwriter.println("You are connected to: "+data[1]+":ConnectTo");
							fromwriter.flush();
							PrintWriter towriter = socketHandler.getUserStream(data[1]);
							towriter.println("You are connected to: "+data[0]+":ConnectTo");
							towriter.flush();
							socketHandler.addConnectedUsers(data[0]);
							socketHandler.addConnectedUsers(data[1]);
						}
					}
					else if (data[2].equals(chat)) 
					{
						socketHandler.tellConnectedUser(message,data[3]);
					}
					else if (data[2].equals(disconnect)) 
					{
						socketHandler.tellConnectedUser((data[0] + ":has disconnected." + ":" + chat),data[3]);
						socketHandler.userRemove(data[0]);
					} 
				}
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
	} 
	
	

	

}
