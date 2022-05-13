package com.nopcommerce.data;

import com.nopcommerce.common.Common_01_Register_End_User;

public class DataTest_02_Login {
	public static class loginInfo {
		public static final String EMAIL = Common_01_Register_End_User.email;
		public static final String PASSWORD = Common_01_Register_End_User.password;
		public static final String WRONG_EMAIL = "abc123";
		public static final String WRONG_PASSWORD = "pass123";
		public static final String UNREGISTERED_EMAIL = "autotesting@gmail.com";
	}

	public static class loginMessage {
		public static final String LOGIN_EMPTY_DATA_MSG = "Please enter your email";
		public static final String LOGIN_INVALID_EMAIL_MSG = "Wrong email";
		public static final String LOGIN_UNREGISTERED_EMAIL_MSG = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
		public static final String LOGIN_INVALID_PASSWORD_MSG = "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect";

	}
}