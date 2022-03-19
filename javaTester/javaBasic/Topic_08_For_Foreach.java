package javaBasic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	
	@Test
	public void TC_01_For() {
		int numberA = 5;
		int numberB = 9;
		int result = 0;
		for (int i = numberA; i < numberB + 1; i++) {	
				result +=i;
		}
		
		System.out.println(result);
		Assert.assertTrue(false);
	}

}
