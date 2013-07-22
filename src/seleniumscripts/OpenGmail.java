package seleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import model.ToolModel;

public class OpenGmail implements Runnable {

	private ToolModel toolModel;
	private String serverUrl = "https://mail.google.com";

	public OpenGmail(ToolModel toolModel) {
		this.toolModel = toolModel;
	}

	@Override
	public void run() {

		openGmail();
	}

	private void openGmail() {
		openPage();
		WebDriver driver = toolModel.getDriver();
		driver.findElement(By.name("Email")).sendKeys(
				"z.alex.kurocha@gree.co.jp");
		driver.findElement(By.name("signIn")).click();
		driver.findElement(By.name("uid")).sendKeys("z.alex.kurocha");
		driver.findElement(By.name("password")).sendKeys("hiddenGREE");
		driver.findElement(By.name("loginSubmit")).click();
	}

	void openPage() {

		// Implemented here as code duplicate - because in OpenPageScripn class
		// this
		// code comes with "get user in Admin Tool" code (which should be
		// separated if we want do this without duplicating the code)

		WebDriver driver = toolModel.getDriver();
		if (driver == null) {
			driver = new FirefoxDriver();
			System.out.println("new instance");
			toolModel.setDriver(driver);
		}
		try {
			if (serverUrl != "") {
				driver.get(serverUrl);
			}
		} catch (Exception e) {
			driver.quit();
			driver = new FirefoxDriver();
			toolModel.setDriver(driver);
			driver.get(serverUrl);
		}
	}

}
