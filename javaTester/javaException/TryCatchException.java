package javaException;

public class TryCatchException {
	public static void main(String[] args) throws InterruptedException {

		sleepInSecond(3);
	}

	public static void sleepInSecond(long timeout) throws InterruptedException {
		Thread.sleep(timeout * 1000);
	}

}