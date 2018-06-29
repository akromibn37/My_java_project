package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server 
{
	ServerSocket xServerSocket;
	MsgReceive receiver;
	ArrayList<ServerSideClient> list;
	public Server(MsgReceive x_receiver)
	{
		receiver = x_receiver;
		list = new ArrayList<ServerSideClient>();
		try {
			xServerSocket = new ServerSocket(111);
			
			Thread t = new Thread(new Runnable(){

				@Override
				public void run() 
				{
					while(true)
					{
						try
						{
							Socket socket = xServerSocket.accept();
							ServerSideClient ssc = new ServerSideClient(socket,receiver);
							list.add(ssc);
						}
						catch(IOException e)
						{
							e.printStackTrace();
						}
					}
					
				}				
			});
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendAll(String s)
	{
		for(ServerSideClient ss : list)
		{
			ss.send(s);
		}
	}
}
