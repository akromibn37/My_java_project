package m;

public class RoomrateDB {
	
	public String id;
	public int room_price;
	public int water_price;
	public int electricity_price;
	public int car_price;
	public int motor_price;
	public int internet_price;
	
	public RoomrateDB()
	{}
	
	public RoomrateDB(String xid,int xroom_price,int xwater_price,int xelectricity_price,int xcar_price,int xmotor_price,int xinternet_price)
	{
		id = xid;
		room_price = xroom_price;
		water_price = xwater_price;
		electricity_price = xelectricity_price;
		car_price = xcar_price;
		motor_price = xmotor_price;
		internet_price = xinternet_price;
	}
	
}
