package m;

import java.awt.image.BufferedImage;
import java.sql.Date;

public class RenterDB {
	
	public int renter_id;
	public String personal_id;
	public String name;
	public String surname;
	public String phone;
	public String house_number;
	public String road;
	public String soi;
	public String tambon;
	public String district;
	public String province;
	public String postal_code;
	public String occupation;
	public String company_name;
	public String salary;
	public Date checkin;
	public Date checkout;
	public String room_id;
	public BufferedImage image;
	
	public RenterDB()
	{}
	
	public RenterDB(int xrenter_id,String xpersonal_id,String xname,String xsurname,String xphone,String xhouse_number,String xroad,String xsoi,String xtambon,String xdistrict,String xprovince,String xpostal_code,String xoccupation,String xcompany_name,String xsalary,Date xcheckin,Date xcheckout,BufferedImage ximage)
	{
		renter_id = xrenter_id;
		personal_id = xpersonal_id;
		name = xname;
		surname = xsurname;
		phone = xphone;
		house_number = xhouse_number;
		road = xroad;
		soi = xsoi;
		tambon = xtambon;
		district = xdistrict;
		province = xprovince;
		postal_code = xpostal_code;
		occupation = xoccupation;
		company_name = xcompany_name;
		salary = xsalary;
		checkin = xcheckin;
		checkout = xcheckout;	
		image = ximage;
				
	}
	
	public RenterDB(int xrenter_id,String xpersonal_id,String xname,String xsurname,String xphone,String xhouse_number,String xroad,String xsoi,String xtambon,String xdistrict,String xprovince,String xpostal_code,String xoccupation,String xcompany_name,String xsalary,Date xcheckin,BufferedImage ximage)
	{
		renter_id = xrenter_id;
		personal_id = xpersonal_id;
		name = xname;
		surname = xsurname;
		phone = xphone;
		house_number = xhouse_number;
		road = xroad;
		soi = xsoi;
		tambon = xtambon;
		district = xdistrict;
		province = xprovince;
		postal_code = xpostal_code;
		occupation = xoccupation;
		company_name = xcompany_name;
		salary = xsalary;
		checkin = xcheckin;
		image = ximage;
		
				
	}
	public RenterDB(int xrenter_id,String xpersonal_id,String xname,String xsurname,String xphone,String xhouse_number,String xroad,String xsoi,String xtambon,String xdistrict,String xprovince,String xpostal_code,String xoccupation,String xcompany_name,String xsalary)
	{
		renter_id = xrenter_id;
		personal_id = xpersonal_id;
		name = xname;
		surname = xsurname;
		phone = xphone;
		house_number = xhouse_number;
		road = xroad;
		soi = xsoi;
		tambon = xtambon;
		district = xdistrict;
		province = xprovince;
		postal_code = xpostal_code;
		occupation = xoccupation;
		company_name = xcompany_name;
		salary = xsalary;
		
				
	}
	
	public RenterDB(String xpersonal_id,String xroom_id)
	{
		personal_id = xpersonal_id;
		room_id = xroom_id;
	}

}
