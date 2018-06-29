package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.MsgReceive;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_IP;
	private JTextField textField_Port;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Client xClient;
	/**
	 * Create the frame.
	 */
	public ClientGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_send = new JButton("SEND");
		button_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xClient.send(textField.getText());
				textField.setText("");
			}
		});
		button_send.setBounds(345, 386, 117, 30);
		contentPane.add(button_send);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(21, 386, 314, 30);
		contentPane.add(textField);
		
		textArea = new JTextArea();
		textArea.setBounds(21, 52, 441, 323);
		contentPane.add(textArea);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xClient = new Client(new MsgReceive()
				{
					@Override
					public void getMsg(String s) 
					{
						textArea.setText(textArea.getText() + "\r\n" +s);
					}
				},textField_IP.getText(),Integer.parseInt(textField_Port.getText()));
			}				
		});
			
		btnConnect.setBounds(21, 11, 89, 23);
		contentPane.add(btnConnect);
		
		textField_IP = new JTextField();
		textField_IP.setText("127.0.0.1");
		textField_IP.setBounds(139, 12, 135, 23);
		contentPane.add(textField_IP);
		textField_IP.setColumns(10);
		
		textField_Port = new JTextField();
		textField_Port.setText("111");
		textField_Port.setBounds(304, 11, 126, 23);
		contentPane.add(textField_Port);
		textField_Port.setColumns(10);
	}
}
