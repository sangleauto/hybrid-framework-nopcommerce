package pageUIs.nopCommerce.admin;

public class AdminProductInfoPageUI {
	public static final String PRODUCT_NAME_TEXTBOX = "xpath=//input[@id='Name']";
	public static final String PRODUCT_DESCRIPTION_TEXTBOX = "xpath=//body[@data-id='FullDescription']";
	public static final String IFRAME_PRODUCT_DESCRIPTION = "xpath=//iframe[@id='FullDescription_ifr']";
	public static final String PRODUCT_SKU_TEXTBOX = "xpath=//input[@id='Sku']";
	public static final String PRODUCT_PRICE_TEXTBOX = "xpath=//label[@for='Price']//ancestor::div[@class='form-group row']//input[@class='k-formatted-value k-input']";
	public static final String PRODUCT_STOCK_TEXTBOX = "xpath=//label[@for='StockQuantity']//ancestor::div[@class='form-group row']//input[@class='k-formatted-value k-input']";
	public static final String EXPAND_PRICES = "xpath=//div[@id='product-price']";

}
