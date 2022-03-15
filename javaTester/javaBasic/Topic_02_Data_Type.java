package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Primitive type/ Value type (nguyên thủy)
	byte bNumber = 6;
	short sNumber;
	int iNumber;
	long lNumber;
	
	float fNUmber = 10.3f;
	double dNumber = 10.33;
	
	char cChar = 'a';
	
	boolean bStatus = true;
	
	// Reference type (tham chiếu)
	
	// String
	String name = "Testing";
	
	// Array
	String[] nameList= {"sang", name};
	
	// Class
	Topic_02_Data_Type topic;
	
	// Interface
	WebDriver driver;
	
	// Object
	Object aObject;
	
	// Collection
	// List, set, quere, map
	List<WebElement> homePageLinks = driver.findElements(By.xpath("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	public void Test() {
		
	}
	
	public static void main(String[] args) {
		

	}

}
