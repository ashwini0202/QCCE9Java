package demo.actiTime.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtils {
	public String getPropertyData(String filePath, String key ) {
		FileInputStream file;
		try {
			file = new FileInputStream(filePath);
			Properties property = new Properties();
			property.load(file);
			return property.getProperty(key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
			
	}

}
