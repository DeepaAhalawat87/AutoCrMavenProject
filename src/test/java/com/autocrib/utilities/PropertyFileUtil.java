package com.autocrib.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {

	
	public static FileInputStream fis;
	public static Properties p;
	public static String  getPropertyValue(String key)
	{
		
		try {
			fis= new FileInputStream("./PropertyFiles/config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		p=new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.getProperty(key);
		
		
	}
}
