import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class Bank_account {

	public static void main(String[] args)
	{
		Bank_accountFunc f = new Bank_accountFunc();
		try {
			f.withdraw("1001", "1111",500);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		
}
