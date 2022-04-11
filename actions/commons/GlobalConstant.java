package commons;

import java.io.File;

public class GlobalConstant {
	public static final String USER_PAGE_URL_NOP = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL_NOP = "https://admin-demo.nopcommerce.com/";
	public static final String USER_PAGE_URL_LIVEGURU = "http://live.techpanda.org/index.php";
	public static final String ADMIN_PAGE_URL_LIVEGURU = "http://live.techpanda.org/index.php/backendlogin/customer/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_FILE = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	public static final int SHORT_TIME_OUT = 5;
	public static final int LONG_TIME_OUT = 30;

}
