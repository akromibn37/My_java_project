package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSEND;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Server xServer;
	/**
	 * Create the frame.
	 */
	public ServerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 52, 441, 323);
		contentPane.add(textArea);
		
		JButton btnOpen = new JButton("OPEN");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xServer = new Server(new MsgReceive(){
					@Override
					public void getMsg(String s) {
						textArea.setText(textArea.getText() + "\r\n client : " + s);
					}
				});
			}
		});
		btnOpen.setBounds(10, 11, 89, 23);
		contentPane.add(btnOpen);		
		
		
		textField = new JTextField();
		textField.setBounds(10, 386, 314, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnSEND = new JButton("SEND");
		btnSEND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(xServer == null)
				{
					JOptionPane.showMessageDialog(ServerGUI.this, "PLEASE PUSH OPEN BUTTON FIRST");
					return;
				}
				xServer.sendAll(textField.getText());
				textField.setText("");
			}
		});
		btnSEND.setBounds(334, 386, 117, 30);
		contentPane.add(btnSEND);
	}
}
