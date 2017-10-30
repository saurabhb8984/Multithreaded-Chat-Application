package com.ims.client;

import java.io.BufferedReader;

public class ClientReader implements Runnable{

	BufferedReader reader;
	ClientUI clientUI = new ClientUI();
	public ClientReader(BufferedReader bufReader) {
		bufReader = reader;
	}

	@Override
	public void run() 
	{
		String[] data;
		String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat",serverInfo="ServerInfo",connectTo="ConnectTo";

		try 
		{
			while ((stream = reader.readLine()) != null) 
			{
				data = stream.split(":");

				if(data[1].equals(serverInfo)){
					clientUI.clientLog(serverInfo+": "+data[0] +"\n");
				}
				else if (data[2].equals(connectTo)){
					clientUI.clientLog(serverInfo+": "+data[0]+data[1] + "\n");
				}
				else if (data[2].equals(chat)) 
				{
					clientUI.clientLog(data[0] + ": " + data[1] + "\n");
				} 
				else if (data[2].equals(connect))
				{
					/*ta_chat.removeAll();
					userAdd(data[0]);*/
				} 
				else if (data[2].equals(disconnect)) 
				{
					//userRemove(data[0]);
				} 
				else if (data[2].equals(done)) 
				{
					//users.setText("");
					//writeUsers();
					//users.clear();
				}
			}
		}catch(Exception ex) { 
			ex.printStackTrace();
		}
	}

}
