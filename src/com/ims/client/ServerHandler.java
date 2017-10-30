package com.ims.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler {
	
	Boolean isConnected = false;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	ClientUI clientUI = new ClientUI();
	public void connectToServer(String username,String address,Integer port){
		if (isConnected == false) 
		{
			if(username.equals("")){
				clientUI.clientLog("Please enter username. \n");
			}else{

				try 
				{
					sock = new Socket(address,port);
					InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
					reader = new BufferedReader(streamreader);
					writer = new PrintWriter(sock.getOutputStream());
					writer.println(username + ":has connected.:Connect");
					writer.flush(); 
					isConnected = true; 
					clientUI.afterConnectionToServer();
				} 
				catch (Exception ex) 
				{
					clientUI.clientLog("Cannot Connect! Try Again. \n");
				}

			}
		} else if (isConnected == true) 
		{
			clientUI.clientLog("You are already connected. \n");
		}

	}
	
	public void connectToUser(String username,String connectToUsername){
		//GEN-FIRST:event_b_anonymousActionPerformed
				if(isConnected == false){
					clientUI.clientLog("You are not connected to server. \n");
				}else if(connectToUsername.equals("")){
					clientUI.clientLog("Please enter connect to username. \n");
				}
				else if(connectToUsername.equals(username)){
					clientUI.clientLog("Same username as your's. Please enter other.\n");
				}
				else {
					try 
					{
						writer.println(username + ":" + connectToUsername + ":" + "ConnectTo");
						writer.flush(); // flushes the buffer
					} 
					catch (Exception ex) 
					{
						clientUI.clientLog("Cannot Connect! Try Again. \n");
					}

					Thread clientReader = new Thread(new ClientReader(reader));
					clientReader.start();
				}
			
	}

	public void sendChatMessage(String fromUsername,String message,String toUsername){
		//GEN-FIRST:event_b_sendActionPerformed
				String nothing = "";
				if (message.equals(nothing)) {
					clientUI.clientLog("");
				} else {
					try {
						writer.println("POST localhost HTTP/1.0");
						//POST /path/script.cgi HTTP/1.0
						writer.println("From: "+fromUsername);
						//From: frog@jmarshall.com
						writer.println("User-Agent: HTTPTool/1.0");
						//User-Agent: HTTPTool/1.0
						writer.println("Content-Type: application/x-www-form-urlencoded");
						writer.println("Content-Length: 32");
						writer.println(fromUsername + ":" + message + ":" + "Chat:"+toUsername);
						clientUI.clientLog(fromUsername + ":" + message +"\n");
						
						writer.flush(); // flushes the buffer
					} catch (Exception ex) {
						clientUI.clientLog("Message was not sent. \n");
					}
				}

	}
	
	public void disconnectFromServer(String username){
		String bye = (username + ": :Disconnect");
		try
		{
			writer.println(bye); 
			writer.flush();
			sock.close();
		} catch (Exception e) 
		{
			clientUI.clientLog("Could not send Disconnect message.\n");
		}
	
	}
}
