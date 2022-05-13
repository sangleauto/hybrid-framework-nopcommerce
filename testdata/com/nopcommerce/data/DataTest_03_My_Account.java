package com.nopcommerce.data;

import java.util.Random;

import com.nopcommerce.common.Common_01_Register_End_User;

public class DataTest_03_My_Account {

	public static class myAccountInfo {
		public static final String EMAIL = Common_01_Register_End_User.email;
		public static final String PASSWORD = Common_01_Register_End_User.password;
		public static final String FIRSTNAME = Common_01_Register_End_User.firstName;
		public static final String LASTNAME = Common_01_Register_End_User.lastName;
		public static final String NEW_FIRSTNAME = "Automation";
		public static final String NEW_LASTNAME = "FC";
		public static final String DAY = "1";
		public static final String MONTH = "January";
		public static final String YEAR = "1999";
		public static final String NEW_EMAIL = "automationfc" + generateRandomNumber() + "@gmail.com";
		public static final String COMPANY_NAME = "Automation FC";
		public static final String COUNTRY = "Viet Nam";
		public static final String STATE_PROVINCE = "Other";
		public static final String CITY = "Da Nang";
		public static final String ADDRESS1 = "123/04 Le Lai";
		public static final String ADDRESS2 = "234/05 Hai Phong";
		public static final String ZIP_CODE = "550000";
		public static final String PHONE_NUMBER = "0123456789";
		public static final String FAX_NUMBER = "09876543231";
		public static final String NEW_PASSWORD = "123147";
		public static final String REVIEW_TITLE = "Review Title " + generateRandomNumber();
		public static final String REVIEW_TEXT = "This is Review Text " + generateRandomNumber();
		public static final String REVIEW_RATING = "4";
		public static final String PASSWORD_CHANGED_SUCCESS_MSG = "Password was changed";

	}

	public static class menuHeaderInfo {
		public static final String MENU_NAME = "Computers";
		public static final String SUB_MENU_NAME = "Desktops";
	}

	public static int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}