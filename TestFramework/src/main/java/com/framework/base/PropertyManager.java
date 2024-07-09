package com.framework.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private static PropertyManager instance;
	private static final Object lock = new Object();
	private static String propertyFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resource\\config.properties";
	private static String url;
	private static String current_EmailPageurl;
	private static String current_Passwordurl;
	private static String userEmail;
	private static String userPassword;
	private static String userConfirmPassword;
	private static String user_wrong_email1;
	private static String user_wrong_email2;
	private static String user_wrong_password;
	private static String user_wrong_confirmPassword;
	// String file_Name;
	// Properties prop;

	// Create a Singleton instance. We need only one instance of Property Manager.
	public static PropertyManager getInstance() {

		if (instance == null) {
			synchronized (lock) {
				instance = new PropertyManager();
				instance.loadData();
			}
		}
		return instance;
	}

	// Get all configuration data and assign to related fields.
	public void loadData() {
		Properties prop = new Properties();
		// String propertyFilePath = System.getProperty("user.dir")+
		// "src\\main\\java\\com\\automation\\properties\\"+file+".properties";
		// prop = new Properties();

		try {
			prop.load(new FileInputStream(propertyFilePath));
			// prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}

		url = prop.getProperty("url");
		current_EmailPageurl = prop.getProperty("currenrt_UserEmailPage_URL");
		current_Passwordurl = prop.getProperty("current_PasswordPage_URL");
		userEmail = prop.getProperty("userEmail");
		userPassword = prop.getProperty("userPassword");
		userConfirmPassword = prop.getProperty("userConfirmPassword");
		user_wrong_email1 = prop.getProperty("user_wrong_email1");
		user_wrong_email2 = prop.getProperty("user_wrong_email2");
		user_wrong_password = prop.getProperty("user_wrong_password");
		user_wrong_confirmPassword = prop.getProperty("user_wrong_confirmPassword");
		// return prop;
	}

	public static String getUrl() {
		return url;
	}

	public static String getCurrent_EmailPageurl() {
		return current_EmailPageurl;
	}

	public static String getCurrent_Passwordurl() {
		return current_Passwordurl;
	}

	public static String getUserEmail() {
		return userEmail;
	}

	public static String getUserPassword() {
		return userPassword;
	}

	public static String getUserConfirmPassword() {
		return userConfirmPassword;
	}

	public static String getUser_wrong_email1() {
		return user_wrong_email1;
	}

	public static String getUser_wrong_email2() {
		return user_wrong_email2;
	}

	public static String getUser_wrong_password() {
		return user_wrong_password;
	}

	public static String getUser_wrong_confirmPassword() {
		return user_wrong_confirmPassword;
	}

}
