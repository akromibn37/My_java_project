package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import server.MsgReceive;

public class Client {
	Socket xSocket;
	MsgReceive xreceive;
	Scanner scanner;
	PrintWriter printwriter;

	public Client(MsgReceive receive, String host, int port) {
		xreceive = receive;

		try {
			xSocket = new Socket(host, port);
			scanner = new Scanner(xSocket.getInputStream());
			printwriter = new PrintWriter(xSocket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					String s = scanner.nextLine();
					xreceive.getMsg(s);
				}
			}
		});
		t.start();

	}

	public void send(String s) {
		printwriter.println(s);
		printwriter.flush();
	}
}
