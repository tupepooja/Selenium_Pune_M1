package com.ShoppersStack.GenericUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
	
	public int randomnumber() {
		Random r=new Random();
		int value = r.nextInt(1000);
		return value;
	}
	
	public String localDate() {
		return LocalDate.now().toString().replace("-","");
	}
	
	public String localDateTime() {
		return LocalDateTime.now().toString().replace("-","").replace(":","").replace(".", "");
	}
	

}
