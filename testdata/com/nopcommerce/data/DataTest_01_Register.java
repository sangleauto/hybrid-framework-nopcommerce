package com.nopcommerce.data;

import ultilities.DataUtil;

public class DataTest_01_Register {
	public static DataUtil faker = DataUtil.getData();

	public static class registerInfo {
		public static final String FIRSTNAME = faker.getFirstName();
		public static final String LASTNAME = faker.getLastName();
		public static final String EMAIL = faker.getEmailAddress();
		public static final String SECOND_EMAIL = faker.getEmailAddress();
		public static final String PASSWORD = faker.getPassword();
		public static final String INVALID_EMAIL = "john@cena@123";
		public static final String PASSWORD_LESS_THAN_6_CHARS = "12345";
		public static final String INVALID_CONFIRM_PASSWORD = "123abc";
	}

	public static class registerMessage {
		public static final String FIRST_NAME_ERROR_MSG = "First name is required.";
		public static final String LAST_NAME_ERROR_MSG = "Last name is required.";
		public static final String EMAIL_ERROR_MSG = "Email is required.";
		public static final String PASSWORD_ERROR_MSG = "Password is required.";
		public static final String INVALID_EMAIL_ERROR_MSG = "Wrong email";
		public static final String REGISTER_SUCCESS_MSG = "Your registration completed";
		public static final String EXISTED_EMAIL_ERROR_MSG = "The specified email already exists";
		public static final String PASSWORD_LESS_THAN_6_Chars_ERROR_MSG = "Password must meet the following rules:\nmust have at least 6 characters";
		public static final String CONFIRM_PASSWORD_NOT_MATCHED_ERROR_MSG = "The password and confirmation password do not match.";

	}
}