package app;

import action.LoginAction;
import action.LoginActionImpl;
import action.LogoutAction;
import action.LogoutActionImpl;

public class Application {
	public static void main(String[] args) {
		LoginAction action = new LoginActionImpl();
		String result = action.execute("ramu", "secret");
		System.out.println(result);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		LogoutAction action2 = new LogoutActionImpl();
		result = action2.execute("ramu");
		System.out.println(result);
	}
}
