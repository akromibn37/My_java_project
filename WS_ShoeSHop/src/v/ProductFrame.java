package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import m.CustomerDB;
import m.CustomerManager;
import m.ProductDB;
import m.ProductManager;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_description;
	private JTextField textField_price_per_unit;
	private JTextField textField_name;
	private JTextField textField_id;
	private ImagePanel imagePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			   
//					 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//					        if ("Nimbus".equals(info.getName())) {
//					            UIManager.setLookAndFeel(info.getClassName());
//					            break;
//					        }
//					    }			
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			    ProductFrame frame = new ProductFrame();
				frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 789, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 445, 433);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRowCount()<1)return;
				int index = table.getSelectedRow();
				BufferedImage img = list.get(index).product_image;
				if(img != null)
				{
					imagePanel.setImage(img);
				}
				int id = 			Integer.parseInt(table.getValueAt(index, 0).toString());
				String product_name = 		table.getValueAt(index, 1).toString();
				String price = 				table.getValueAt(index, 2).toString();
				String description = 		table.getValueAt(index, 3).toString();
				
				textField_id.setText("" + id); 
				textField_name.setText("" + product_name); 
				textField_price_per_unit.setText("" + price); 
				textField_description.setText("" + description); 
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblProductId = new JLabel("product id");
		lblProductId.setBounds(465, 22, 78, 14);
		contentPane.add(lblProductId);
		
		JLabel lblProductName = new JLabel("product name");
		lblProductName.setBounds(465, 49, 78, 14);
		contentPane.add(lblProductName);
		
		JLabel lblPricePerUnit = new JLabel("price per unit");
		lblPricePerUnit.setBounds(465, 75, 78, 14);
		contentPane.add(lblPricePerUnit);
		
		JLabel lblProductDescription = new JLabel("product description");
		lblProductDescription.setBounds(465, 105, 106, 14);
		contentPane.add(lblProductDescription);
		
		textField_description = new JTextField();
		textField_description.setColumns(10);
		textField_description.setBounds(598, 102, 149, 23);
		contentPane.add(textField_description);
		
		textField_price_per_unit = new JTextField();
		textField_price_per_unit.setColumns(10);
		textField_price_per_unit.setBounds(598, 74, 149, 23);
		contentPane.add(textField_price_per_unit);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(598, 46, 149, 23);
		contentPane.add(textField_name);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setColumns(10);
		textField_id.setBackground(Color.YELLOW);
		textField_id.setBounds(598, 18, 149, 23);
		contentPane.add(textField_id);
		
		JButton button_save = new JButton("SAVE NEW");
		button_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_price_per_unit.getText().trim().matches("[-+]?\\d*\\.?\\d+"))
				{
					JOptionPane.showMessageDialog(ProductFrame.this, "Number only Please!!");
					textField_price_per_unit.requestFocus();
					textField_price_per_unit.selectAll();
				}
				ProductDB x = new ProductDB();
				x.product_id = 0;
				x.product_name = textField_name.getText().trim();
				x.price_per_unit = Double.parseDouble(textField_price_per_unit.getText().trim());
				x.product_description = textField_description.getText().trim();
				x.product_image = (BufferedImage) imagePanel.getImage();
				
				ProductManager.saveProduct(x);
				load();
				textField_id.setText("");
				textField_name.setText("");
				textField_price_per_unit.setText("");
				textField_description.setText("");
				imagePanel.setImage(null);
				JOptionPane.showMessageDialog(ProductFrame.this, "Finished!!");
			}
		});
		button_save.setBounds(465, 384, 89, 23);
		contentPane.add(button_save);
		
		JButton button_edit = new JButton("EDIT");
		button_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDB x = new ProductDB();
				x.product_id = Integer.parseInt(textField_id.getText().trim().toString());
				x.product_name = textField_name.getText().trim();
				x.price_per_unit = Double.parseDouble(textField_price_per_unit.getText().trim());
				x.product_description = textField_description.getText().trim();
				x.product_image = (BufferedImage) imagePanel.getImage();
					
				ProductManager.editProduct(x);
				load();
				textField_id.setText("");
				textField_name.setText("");
				textField_price_per_unit.setText("");
				textField_description.setText("");
				imagePanel.setImage(null);
				JOptionPane.showMessageDialog(ProductFrame.this, "Finished!!");
			}
		});
		button_edit.setBounds(559, 384, 89, 23);
		contentPane.add(button_edit);
		
		JButton button_delete = new JButton("DELETE");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(ProductFrame.this, "Are you sure?","confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					int k = 0;
					if(!textField_id.getText().matches("\\d+"))
					{
						JOptionPane.showMessageDialog(ProductFrame.this, "Please Select one row on table!!");
					}
					ProductDB x =new ProductDB();
					x.product_id = Integer.parseInt(textField_id.getText().toString().trim()); 
					ProductManager.deleteProduct(x);
					load();
					textField_id.setText("");
					textField_name.setText("");
					textField_price_per_unit.setText("");
					textField_description.setText("");
					imagePanel.setImage(null);					
					JOptionPane.showMessageDialog(ProductFrame.this, "Finished!!");
				}
			}
		});
		button_delete.setBounds(658, 384, 89, 23);
		contentPane.add(button_delete);
		
		imagePanel = new ImagePanel();
		imagePanel.setBounds(475, 164, 272, 209);
		contentPane.add(imagePanel);
		
		JButton btnBrowseImage = new JButton("Browse Image");
		btnBrowseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.addChoosableFileFilter(new OpenFileFilter("jpeg","Photo in JPEG format") );
				fc.addChoosableFileFilter(new OpenFileFilter("jpg","Photo in JPEG format") );
				fc.addChoosableFileFilter(new OpenFileFilter("png","PNG image") );
				fc.addChoosableFileFilter(new OpenFileFilter("svg","Scalable Vector Graphic") );
				int returnVal = fc.showOpenDialog(ProductFrame.this);
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
					File f = fc.getSelectedFile();
					try {
						BufferedImage bimg = ImageIO.read(f);
						imagePanel.setImage(bimg);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnBrowseImage.setBounds(475, 130, 149, 23);
		contentPane.add(btnBrowseImage);
		load();
	}
	ArrayList<ProductDB> list;
	private JTable table;
	public void load()
	{
		list = ProductManager.getAllProduct();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("product_id");
		model.addColumn("product_name");
		model.addColumn("price_per_unit");
		model.addColumn("product_description");
		
		for(ProductDB c : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + c.product_id,c.product_name,c.price_per_unit,c.product_description});
		}
		table.setModel(model);
	}
}
class OpenFileFilter extends FileFilter {

    String description = "";
    String fileExt = "";

    public OpenFileFilter(String extension) {
        fileExt = extension;
    }

    public OpenFileFilter(String extension, String typeDescription) {
        fileExt = extension;
        this.description = typeDescription;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        return (f.getName().toLowerCase().endsWith(fileExt));
    }

    @Override
    public String getDescription() {
        return description;
    }

	public boolean accept2(File f) {
		// TODO Auto-generated method stub
		return false;
	}
}
