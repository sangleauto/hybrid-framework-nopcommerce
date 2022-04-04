package exception;

public class BrowserNotSupported extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public BrowserNotSupported(String browserName) {
		super(String.format("Browser %s is not supported !", browserName.toUpperCase()));
	}

}
