package com.ims.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ServerSocketHandler {
	Map<String,PrintWriter> users = new HashMap<String, PrintWriter>();
	Set<String> connectedUsers = new HashSet<String>();

	public void createServerSocket() {
		ServerSocket serverSock = null;
		ServerUI serverUI = new ServerUI();
		
		try 
		{	
			serverSock = new ServerSocket(80);
			ServerSocketHandler serverSocketHandler = new ServerSocketHandler();
			
			while (true) 
			{
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				Thread listener = new Thread(new ClientHandler(clientSock, writer,serverUI,serverSocketHandler));
				listener.start();
				serverUI.serverlog("Got a connection. \n");
			}
		}
		catch (Exception ex)
		{
			serverUI.serverlog("Error making a connection. \n");
		}
	}
	
	public void userAdd (String data, PrintWriter client) 
	{
		users.put(data, client);
	}

	public void userRemove (String data) 
	{
		users.remove(data);
	}

	public void tellConnectedUser(String message, String toUsername) {
		PrintWriter writer = users.get(toUsername);
		writer.println(message);
		writer.flush();
	}
	
	public Boolean usernameAlreadyExists(String username){
		return users.keySet().contains(username);
	}
	
	public Boolean checkIfUserIsConnected(String username){
		return connectedUsers.contains(username);
	}
	
	public PrintWriter getUserStream(String username){
		return users.get(username);
	}
	
	public void addConnectedUsers(String username){
		connectedUsers.add(username);
	}
}
