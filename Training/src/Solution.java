import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
        int min = 0;
        int val = 10001;
        String result = "";
        String[] s = new String [n];
        int j = 0;
        for(int i = 0;i<temps.length();i++)
        {
        	if(i == 0){s[0] = "";}
        	if(temps.charAt(i) != ' '){
        		s[j]+=temps.charAt(i);
        	}
        	else{
        		j++;
        		s[j] = "";
          }
         
        }
        System.out.println(Arrays.toString(s));
        for(int k = 0;k<n;k++)
        {
        	if(Math.abs(Integer.parseInt(s[k])-min)<=val)
        	{         		
        		if(Math.abs(Integer.parseInt(s[k])-min) == val){
        			if(Integer.parseInt(s[k])-min > 0)
        			{result = s[k];}
        		}
        		else{val = Math.abs(Integer.parseInt(s[k])); result = s[k];}        		        		
        	}
        }
        if(n == 0)
        {
        	result = "0";
        }
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");        
        System.out.println(result);
    }
}