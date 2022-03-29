package com.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BasePage {
	
	public Logger pageLogs() {
		Logger logger=Logger.getLogger(this.getClass());
		String path=(System.getProperty("user.dir")+"/src/main/resources/log4jPage.properties");
		PropertyConfigurator.configure(path);
		return logger;
		
	}

}
