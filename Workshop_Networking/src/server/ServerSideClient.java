package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSideClient 
{
	Socket xSocket;
	Scanner scanner;
	PrintWriter printwriter;
	MsgReceive receiver;
	
	public ServerSideClient(Socket x_Socket, MsgReceive x_receiver)
	{
		xSocket = x_Socket;
		receiver = x_receiver;
		try {
			scanner = new Scanner(xSocket.getInputStream());
			
			printwriter = new PrintWriter(xSocket.getOutputStream());
		} catch (IOException e) 
		{			
			e.printStackTrace();
		}
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					String s = scanner.nextLine();
					receiver.getMsg(s);
				}
			}
		});
		t.start();
		
	}
	
	public void send(String s)
	{
		printwriter.println(s);
		printwriter.flush();
	}
	
}
