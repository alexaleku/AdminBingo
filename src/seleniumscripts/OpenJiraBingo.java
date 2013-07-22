package seleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import model.ToolModel;

public class OpenJiraBingo implements Runnable {

	private String serverUrl = "http://jira.funzio.com/secure/IssueNavigator.jspa?mode=show&createNew=true";
	private String query;
	private ToolModel toolModel;

	public OpenJiraBingo(String query, ToolModel toolModel) {
		this.query = query;
		this.toolModel = toolModel;
	}

	@Override
	public void run() {
		// extracted to separate method to get ability call it from
		// addResAndMastery
		openJiraPage();
	}

	private void openJiraPage() {

		openPage();
		WebDriver driver = toolModel.getDriver();

		WebElement loginLink = null;
		try {
			loginLink = driver.findElement(By.linkText("Log In"));
		} catch (Exception e) {
		}

		if (loginLink != null) {

			loginLink.click();
			driver.findElement(By.name("os_username")).sendKeys(
					"z.alex.kurocha");
			driver.findElement(By.name("os_password")).sendKeys("hiddenGREE");
			driver.findElement(By.name("login")).click();
			driver.get("http://jira.funzio.com/secure/IssueNavigator.jspa?mode=show&createNew=true");
		}

		// driver.findElement(By.id("find_link")).click();
		// WebElement advanceSearch =
		// driver.findElement(By.xpath("//*[@id=\"switchnavtype\"]"));

		WebElement advanceSearch = null;
		try {
			advanceSearch = driver.findElement(By.linkText("advanced"));
		} catch (Exception e) {
		}

		if (advanceSearch != null) {
			advanceSearch.click();
		}
		driver.findElement(By.name("jqlQuery")).clear();
		driver.findElement(By.name("jqlQuery")).sendKeys(query);
		driver.findElement(By.id("jqlrunquery")).click();
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
