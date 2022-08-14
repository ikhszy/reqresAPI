package ctcorp.iviewAPI.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		} catch(Exception e) {
			System.out.println("exception: " + e.getMessage());
		}
	}
	
	public String getBaseURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getBaseURI() {
		String uri=prop.getProperty("baseURI");
		return uri;
	}
	
	public String getUserPath() {
		String user = prop.getProperty("userPath");
		return user;
	}
	
	public String getChromepath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() {
		String geckopath = prop.getProperty("geckopath");
		return geckopath;
	}

}
