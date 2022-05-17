package pageUIs.nopCommerce.admin;

public class BasePageNopCommerceUI {
	public static final String SIDEBAR_BY_NAME = "xpath=(//li[contains(@class, 'nav-item has-treeview')]//p[contains(text(), '%s')])[1]";
	public static final String SUB_SIDEBAR_BY_NAME = "xpath=(//ul[@class='nav nav-treeview']//p[contains(text(), '%s')])[1]";
	public static final String LOADING_ICON = "xpath=//div[@id='ajaxBusy']";
	public static final String ROLE_DROPDOWN_LOADING = "xpath=//select[@id='SelectedCustomerRoleIds']";
	public static final String ROLE_SPAN = "xpath=(//span[@unselectable='on'])[1]";

}
