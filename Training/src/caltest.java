import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class caltest extends JFrame {

	private JPanel contentPane;
	private JTextField textNum1;
	private JTextField textNum2;
	private JTextField textAnswer;
	private int num1,num2,numAns,i=0;
	private String operation;
	private JList list;
//	private NumberFormat amountFormat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					caltest frame = new caltest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void input()
	{
		if(textNum1.getText().isEmpty())
		{
			num1 = 0;
		}
		else{num1 = Integer.parseInt(textNum1.getText());}		
		
		if(textNum2.getText().isEmpty())
		{
			num2 = 0;
		}
		else{num2 = Integer.parseInt(textNum2.getText());}		
	}

	/**
	 * Create the frame.
	 */
	
	public caltest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstnum = new JLabel("Firstnum");
		lblFirstnum.setFont(new Font("TH Sarabun New", Font.PLAIN, 30));
		lblFirstnum.setBounds(25, 77, 95, 29);
		contentPane.add(lblFirstnum);
		
		JLabel lblSecondnum = new JLabel("Secondnum");
		lblSecondnum.setFont(new Font("TH Sarabun New", Font.PLAIN, 30));
		lblSecondnum.setBounds(25, 117, 118, 29);
		contentPane.add(lblSecondnum);
		
		JLabel lblNewLabel = new JLabel("Calcutor version 1");
		lblNewLabel.setFont(new Font("TH Sarabun New", Font.PLAIN, 55));
		lblNewLabel.setBounds(46, 11, 311, 42);
		contentPane.add(lblNewLabel);
		
		textNum1 = new JTextField();
		((AbstractDocument) textNum1.getDocument()).setDocumentFilter(new CustomDocumentFilter());
		textNum1.setBounds(165, 77, 206, 26);
		contentPane.add(textNum1);
		textNum1.setColumns(10);
		
		textNum2 = new JTextField();
		((AbstractDocument) textNum2.getDocument()).setDocumentFilter(new CustomDocumentFilter());
		textNum2.setColumns(10);
		textNum2.setBounds(165, 117, 206, 26);
		contentPane.add(textNum2);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("TH Sarabun New", Font.PLAIN, 30));
		lblAnswer.setBounds(25, 157, 118, 29);
		contentPane.add(lblAnswer);
		
		textAnswer = new JTextField();
		textAnswer.setEditable(false);
		textAnswer.setColumns(10);
		textAnswer.setBounds(165, 154, 206, 26);
		contentPane.add(textAnswer);
		
		DefaultListModel model = new DefaultListModel();
		list = new JList(model);
		list.setBounds(451, 11, 165, 240);
		contentPane.add(list);
		
		JButton btnAdd = new JButton("ADD(+)");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input();
				numAns = num1+num2;
				textAnswer.setText(Integer.toString(numAns));
				operation = "+";
			}
		});
		btnAdd.setBounds(25, 197, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSub = new JButton("SUB(-)");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				numAns = num1-num2;
				textAnswer.setText(Integer.toString(numAns));
				operation = "-";
			}
		});
		btnSub.setBounds(124, 197, 89, 23);
		contentPane.add(btnSub);
		
		JButton btnMultiply = new JButton("MULTIPLY(X)");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				numAns = num1*num2;
				textAnswer.setText(Integer.toString(numAns));
				operation = "x";
			}
		});
		btnMultiply.setBounds(223, 197, 102, 23);
		contentPane.add(btnMultiply);
		
		JButton btnDivide = new JButton("DIVIDE(/)");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				numAns = num1/num2;
				textAnswer.setText(Integer.toString(numAns));
				operation = "/";
			}
		});
		btnDivide.setBounds(335, 197, 89, 23);
		contentPane.add(btnDivide);
		
		JButton btnEqual = new JButton("EQUAL(=)");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.add(i, num1);i++;
				model.add(i, operation);i++;
				model.add(i, num2);i++;				
				textNum1.setText(Integer.toString(numAns));
				textNum1.setEditable(false);
				textNum2.setText("0");
			}
		});
		btnEqual.setBounds(313, 231, 111, 23);
		contentPane.add(btnEqual);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNum1.setText("0");	
				textNum1.setEditable(true);
				textNum2.setText("0");
				textNum2.setEditable(true);
				textAnswer.setText("");
				model.clear();
			}
		});
		btnClear.setBounds(25, 231, 125, 23);
		contentPane.add(btnClear);		
		
		JButton btnAnswer = new JButton("Answer");
		btnAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNum2.setEditable(false);
				operation = "=";
				model.add(i, operation);i++;
				model.add(i, numAns);i++;
				
			}
		});
		btnAnswer.setBounds(165, 231, 128, 23);
		contentPane.add(btnAnswer);
		
	}
	 private class CustomDocumentFilter extends DocumentFilter {

	        private Pattern regexCheck = Pattern.compile("[0-9]+");

	        @Override
	        public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
	            if (str == null) {
	                return;
	            }

	            if (regexCheck.matcher(str).matches()) {
	                super.insertString(fb, offs, str, a);
	            }
	        }

	        @Override
	        public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
	                throws BadLocationException {
	            if (str == null) {
	                return;
	            }

	            if (regexCheck.matcher(str).matches()) {
	                fb.replace(offset, length, str, attrs);
	            }
	        }
	    }
}

