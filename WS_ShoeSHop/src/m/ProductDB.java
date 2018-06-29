package m;

import java.awt.image.BufferedImage;

public class ProductDB
{
	public int product_id;
	public String product_name;
	public double price_per_unit;
	public String product_description;
	public BufferedImage product_image;
	
	public ProductDB()
	{}
	public ProductDB(int id,String name,double price, String description,BufferedImage image)	
	{
		product_id = id;
		product_name = name;
		price_per_unit = price;
		product_description = description;
		product_image = image;
	}
}
