package com.nopcommerce.data;

import ultilities.DataUtil;

public class DataTest_08_Admin {
	static DataUtil faker = DataUtil.getData();

	public static class LoginInfo {
		public static final String EMAIL_ADMIN = "admin@yourstore.com";
		public static final String PASSWORD_ADMIN = "admin";
	}

	public static class SidebarInfo {
		public static final String CATALOG = "Catalog";
		public static final String PRODUCTS = " Products";
		public static final String CUSTOMERS = "Customers";
		public static final String CUSTOMERS_SUB = " Customers";

	}

	public static class ProductInfo {
		public static final String PRODUCT_LENOVO_NAME = "Lenovo IdeaCentre 600 All-in-One PC";
		public static final String PRODUCT_LENOVO_SKU = "LE_IC_600";
		public static final String PRODUCT_LENOVO_PRICE = "500";
		public static final String PRODUCT_LENOVO_STOCK = "10000";
		public static final String PRODUCT_LENOVO_CHECKED_ICON = "fas fa-check true-icon";
		public static final String INDEX_1 = "1";
		public static final String TABLE_NAME_COLUMN = "Product name";
		public static final String TABLE_SKU_COLUMN = "SKU";
		public static final String TABLE_PRICE_COLUMN = "Price";
		public static final String TABLE_STOCK_COLUMN = "Stock quantity";
		public static final String TABLE_PUBLISHED_COLUMN = "Published";
		public static final String CATEGORY_COMPUTERS = "Computers";
		public static final String CATEGORY_COMPUTERS_DESKTOPS = "Computers >> Desktops";
		public static final String CATEGORY_ALL = "All";
		public static final String MANUFACTURER_APPLE = "Apple";
		public static final String SKU_LENOVO = "LE_IC_600";
		public static final String DESCRIPTION_LENOVO = "The A600 features a 21.5in screen, DVD or optional Blu-Ray drive, support for the full beans 1920 x 1080 HD, Dolby Home Cinema certification and an optional hybrid analogue/digital TV tuner.\nConnectivity is handled by 802.11a/b/g - 802.11n is optional - and an ethernet port. You also get four USB ports, a Firewire slot, a six-in-one card reader and a 1.3- or two-megapixel webcam.";
		public static final String PRICE_LENOVO = "500";
		public static final String STOCK_LENOVO = "10000";

	}

	public static class Message {
		public static final String NO_DATA_MSG = "No data available in table";
		public static final String ADD_CUSTOMER_SUCCESS_MSG = "×\nThe new customer has been added successfully.";
		public static final String EDIT_CUSTOMER_SUCCESS_MSG = "×\nThe customer has been updated successfully.";
		public static final String ADD_ADDRESS_SUCCESS_MSG = "×\nThe new address has been added successfully.";
		public static final String UPDATE_ADDRESS_SUCCESS_MSG = "×\nThe address has been updated successfully.";

	}

	public static class CustomerInfo {
		public static final String EMAIL = faker.getEmailAddress();
		public static final String PASSWORD = "123123";
		public static final String FIRST_NAME = faker.getFirstName();
		public static final String LAST_NAME = faker.getLastName();
		public static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
		public static final String GENDER = "Male";
		public static final String DOB = "1/1/2000";
		public static final String DOB_MONTH = "1";
		public static final String DOB_DAY = "1";
		public static final String COMPANY_NAME = "Automation Testing";
		public static final String DEFAULT_ROLE = "Registered";
		public static final String CUSTOMER_ROLE = "Guests";
		public static final String ADMIN_COMMENT = "Add new Customers (Guest)";
		public static final String NAME_COLUMN = "Name";
		public static final String ROLE_COLUMN = "Customer roles";
		public static final String COMPANY_COLUMN = "Company name";
	}

	public static class EditCustomerInfo {
		public static final String EMAIL = faker.getEmailAddress();
		public static final String FIRST_NAME = faker.getFirstName();
		public static final String LAST_NAME = faker.getLastName();
		public static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
		public static final String DOB = "2/2/2004";
		public static final String DOB_MONTH = "2";
		public static final String DOB_DAY = "2";
		public static final String COMPANY_NAME = "Edit Automation Testing";
		public static final String ADMIN_COMMENT = "Edit Customers (Guest)";
		public static final String CUSTOMER_ROLE = "Guests";

	}

	public static class AddressInfo {
		public static final String EMAIL = faker.getEmailAddress();
		public static final String FIRST_NAME = faker.getFirstName();
		public static final String LAST_NAME = faker.getLastName();
		public static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
		public static final String COMPANY_NAME = "Automation FC";
		public static final String COUNTRY = "Viet Nam";
		public static final String STATE = "Other";
		public static final String CITY = faker.getCity();
		public static final String ADDRESS1 = faker.getAddress();
		public static final String ZIP_CODE = faker.getZipCode();
		public static final String PHONE_NUMBER = faker.getPhoneNumber();
		public static final String ADDRESS_CONTENT_TABLE = COMPANY_NAME + "\n" + ADDRESS1 + "\n" + CITY + "," + ZIP_CODE + "\n" + COUNTRY;
		public static final String FIRST_NAME_COLUMN = "First name";
		public static final String LAST_NAME_COLUMN = "Last name";
		public static final String EMAIL_COLUMN = "Email";
		public static final String PHONE_COLUMN = "Phone number";
		public static final String ADDRESS_COLUMN = "Address";

	}

	public static class EditAddressInfo {
		public static final String EMAIL = faker.getEmailAddress();
		public static final String FIRST_NAME = faker.getFirstName();
		public static final String LAST_NAME = faker.getLastName();
		public static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
		public static final String COMPANY_NAME = "Automation FC";
		public static final String COUNTRY = "United States";
		public static final String STATE = "California";
		public static final String CITY = faker.getCity();
		public static final String ADDRESS1 = faker.getAddress();
		public static final String ZIP_CODE = faker.getZipCode();
		public static final String PHONE_NUMBER = faker.getPhoneNumber();
		public static final String ADDRESS_CONTENT_TABLE = COMPANY_NAME + "\n" + ADDRESS1 + "\n" + CITY + "," + STATE + "," + ZIP_CODE + "\n" + COUNTRY;

	}
}