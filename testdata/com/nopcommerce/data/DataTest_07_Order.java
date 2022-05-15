package com.nopcommerce.data;

import java.util.Random;

import com.nopcommerce.common.Common_01_Register_End_User;

import ultilities.DataUtil;

public class DataTest_07_Order {
	public static DataUtil faker = DataUtil.getData();

	public static class IndexValue {
		public static final String INDEX_1 = "1";
		public static final String INDEX_2 = "2";
		public static final String INDEX_3 = "3";
		public static final String INDEX_4 = "4";
		public static final String INDEX_5 = "5";
		public static final String INDEX_10 = "10";
	}

	public static class MenuHeaderInfo {
		public static final String MENU_NAME = "Computers";
		public static final String SUB_MENU_NAME_DESKTOP = "Desktops";
		public static final String SUB_MENU_NAME_NOTEBOOK = "Notebooks";
	}

	public static class OrderInfo {
		public static final String DESKTOP_BUILD_COMPUTER_NAME = "Build your own computer";
		public static final String DESKTOP_LENOVO_PRODUCT_NAME = "Lenovo IdeaCentre 600 All-in-One PC";
		public static final String NOTEBOOK_APPLE_PRODUCT_NAME = "Apple MacBook Pro 13-inch";
		public static final String PROCESSOR = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		public static final String RAM = "8GB [+$60.00]";
		public static final String HDD = "400 GB [+$100.00]";
		public static final String OS = "Vista Premium [+$60.00]";
		public static final String SOFTWARE_MICROSOFT = "Microsoft Office [+$50.00]";
		public static final String SOFTWARE_ACROBAT = "Acrobat Reader [+$10.00]";
		public static final String SOFTWARE_COMMANDER = "Total Commander [+$5.00]";
		public static final String TOTAL_PRICE_CART = "$1,500.00";
		public static final String PRODUCT_COLUMN = "Product(s)";
		public static final String PRICE_COLUMN = "Price";
		public static final String QUANTITY_COLUMN = "Qty.";
		public static final String TOTAL_COLUMN = "Total";
		public static final String PRODUCT_COLUMN_ORDER_DETAIL = "Name";
		public static final String PRICE_COLUMN_ORDER_DETAIL = "Price";
		public static final String QUANTITY_COLUMN_ORDER_DETAIL = "Quantity";
		public static final String TOTAL_COLUMN_ORDER_DETAIL = "Total";
		public static final String REMOVE_COLUMN = "Remove";
		public static final String LENOVO_TOTAL_PRICE = "$2,500.00";
		public static final String PENDIND_STATUS = "Pending";
		public static final String ORDER_PENDIND_STATUS = "Order Status: Pending";
		public static final String NOT_SHIPPED_STATUS = "Not yet shipped";
		public static final String GIFT_WRAPPING_STATUS = "Gift wrapping: No";
		public static final String PRICE_0_$ = "$0.00";
		public static final String NOTEBOOK_APPLE_PRICE = "$1,800.00";
		public static final String NOTEBOOK_APPLE_PRICE_TOTAL = "$3,600.00";
		public static final String NOTEBOOK_APPLE_PRICE_RE_ORDER = "$18,000.00";

	}

	public static class EditOrderInfo {
		public static final String EDIT_PROCESSOR = "2.2 GHz Intel Pentium Dual-Core E2200";
		public static final String EDIT_RAM = "4GB [+$20.00]";
		public static final String EDIT_HDD = "320 GB";
		public static final String EDIT_OS = "Vista Home [+$50.00]";
		public static final String TOTAL_PRICE_AFTER_EDIT = "$1,320.00";
		public static final String TOTAL_PRICE_IN_CART_AFTER_EDIT = "$2,640.00";

	}

	public static class BillingAddress {
		public static final String ADDRESS_DROPDOWN = "New Address";
		public static final String FIRST_NAME = Common_01_Register_End_User.firstName;
		public static final String LAST_NAME = Common_01_Register_End_User.lastName;
		public static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
		public static final String EMAIL = Common_01_Register_End_User.email;
		public static final String COUNTRY = "Viet Nam";
		public static final String STATE_PROVINCE = "Other";
		public static final String CITY = faker.getCity();
		public static final String ADDRESS1 = faker.getAddress();
		public static final String ZIP_CODE = faker.getZipCode();
		public static final String PHONE_NUMBER = faker.getPhoneNumber();
		public static final String CITY_STATE_ZIP = CITY + "," + ZIP_CODE;

	}

	public static class NewBillingAddress {
		public static final String ADDRESS_DROPDOWN = "New Address";
		public static final String FIRST_NAME = Common_01_Register_End_User.firstName;
		public static final String LAST_NAME = Common_01_Register_End_User.lastName;
		public static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
		public static final String EMAIL = Common_01_Register_End_User.email;
		public static final String COUNTRY = "Viet Nam";
		public static final String STATE_PROVINCE = "Other";
		public static final String CITY = faker.getCity();
		public static final String ADDRESS1 = faker.getAddress();
		public static final String ZIP_CODE = faker.getZipCode();
		public static final String PHONE_NUMBER = faker.getPhoneNumber();
		public static final String CITY_STATE_ZIP = CITY + "," + ZIP_CODE;

	}

	public static class ShippingAddress {
		public static final String ADDRESS_DROPDOWN = "New Address";
		public static final String FIRST_NAME = Common_01_Register_End_User.firstName;
		public static final String LAST_NAME = Common_01_Register_End_User.lastName;
		public static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
		public static final String EMAIL = Common_01_Register_End_User.email;
		public static final String COUNTRY = "Japan";
		public static final String STATE_PROVINCE = "Other";
		public static final String CITY = faker.getCity();
		public static final String ADDRESS1 = faker.getAddress();
		public static final String ZIP_CODE = faker.getZipCode();
		public static final String PHONE_NUMBER = faker.getPhoneNumber();
		public static final String CITY_STATE_ZIP = CITY + "," + ZIP_CODE;

	}

	public static class NewShippingAddress {
		public static final String ADDRESS_DROPDOWN = "New Address";
		public static final String FIRST_NAME = Common_01_Register_End_User.firstName;
		public static final String LAST_NAME = Common_01_Register_End_User.lastName;
		public static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
		public static final String EMAIL = Common_01_Register_End_User.email;
		public static final String COUNTRY = "Japan";
		public static final String STATE_PROVINCE = "Other";
		public static final String CITY = faker.getCity();
		public static final String ADDRESS1 = faker.getAddress();
		public static final String ZIP_CODE = faker.getZipCode();
		public static final String PHONE_NUMBER = faker.getPhoneNumber();
		public static final String CITY_STATE_ZIP = CITY + "," + ZIP_CODE;

	}

	public static class CheckoutInfo {
		public static final String SHIPPING_METHOD_GROUND = "Ground ($0.00)";
		public static final String SHIPPING_METHOD_AIR = "Next Day Air ($0.00)";
		public static final String CONFIRM_SHIPPING_GROUND = "Ground";
		public static final String CONFIRM_SHIPPING_AIR = "Next Day Air";
		public static final String PAYMENT_METHOD_CHEQUE = "Check / Money Order";
		public static final String PAYMENT_METHOD_CARD = "Credit Card";
		public static final String PAYMENT_INFO = "NOP SOLUTIONS\nyour address here,\nNew York, NY 10001\nUSA";
		public static final String CREDIT_CARD_TYPE = "Visa";
		public static final String CARD_HOLDER_NAME = ShippingAddress.FULL_NAME;
		public static final String CARD_NUMBER = "4009 6011 9413 8747";
		public static final String EXPIRE_MONTH = "12";
		public static final String EXPIRE_YEAR = "2023";
		public static final String CARD_CODE = "617";

	}

	public static class OrderMessage {
		public static final String ADD_TO_CART_MSG = "The product has been added to your shopping cart";
		public static final String EMPTY_CART_MSG = "Your Shopping Cart is empty!";
		public static final String ORDER_SUCCESS_MSG = "Your order has been successfully processed!";
	}

	public static int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(900) + 100;
	}
}