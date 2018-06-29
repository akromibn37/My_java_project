package m;

public class RoomdataDB {

	public String room_id;
	public String month;
	public int water_unit;
	public int electric_unit;
	public int car_unit;
	public int motor_unit;
	public String internet;
	
	public RoomdataDB()
	{}
	
	public RoomdataDB(String xroom_id,String xmonth,int water,int electric,int car,int motor,String xinternet)
	{
		room_id = xroom_id;
		month = xmonth;
		water_unit = water;
		electric_unit = electric;
		car_unit = car;
		motor_unit = motor;
		internet = xinternet;				
	}
}
