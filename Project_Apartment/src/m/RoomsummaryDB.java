package m;

public class RoomsummaryDB {

	public String room_id;
	public String month;
	public int room_price;
	public int water_sum;
	public int electric_sum;
	public int car_sum;
	public int motor_sum;
	public int internet_sum;
	public int total;
	public String occupy_status;
	public String pay_status;
	
	
	public RoomsummaryDB()
	{}
	
	public RoomsummaryDB(String xroom_id,String xmonth,int xroom_price,int water,int electric,int car,int motor,int xinternet,int xtotal,String xoccu,String xpay)
	{
		room_id = xroom_id;
		month = xmonth;
		room_price = xroom_price;
		water_sum = water;
		electric_sum = electric;
		car_sum = car;
		motor_sum = motor;
		internet_sum = xinternet;
		total = xtotal;
		occupy_status = xoccu;
		pay_status = xpay;
		
	}
	
	public void totally()
	{
		this.total = room_price+water_sum+electric_sum+car_sum+motor_sum+internet_sum;
	}
}
