package seleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import model.ToolModel;

public class AddResMasteryScript implements Runnable {
	private String serverUrl;
	private String userID;
	private ToolModel toolModel;

	public AddResMasteryScript(String serverUrl, String userID,
			ToolModel toolModel) {
		this.serverUrl = serverUrl;
		this.userID = userID;
		this.toolModel = toolModel;
	}

	@Override
	public void run() {
		AddResScript addResScript = new AddResScript(serverUrl, userID,
				toolModel);
		addResScript.addRes();
		WebDriver driver = toolModel.getDriver();

		String[] arrayOfXPathModifiers = { "34", "37", "42", "49", "56", "63",
				"70" };

		for (int i = 0; i < arrayOfXPathModifiers.length; i++) {
			String xPathCurrentLevel = "//div[@id='player_tab']/form[2]/table/tbody/tr["
					+ arrayOfXPathModifiers[i] + "]/td[3]";
			String currentLevel = driver.findElement(
					By.xpath(xPathCurrentLevel)).getText();
			int currentLevelInt = Integer.parseInt(currentLevel);
			int levelDeltaInt = 6 - currentLevelInt;
			String levelDelta = Long.toString(levelDeltaInt);
			driver.findElement(
					By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr["
							+ arrayOfXPathModifiers[i] + "]/td[3]/input"))
					.clear();
			driver.findElement(
					By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr["
							+ arrayOfXPathModifiers[i] + "]/td[3]/input"))
					.sendKeys(levelDelta);
		}
		driver.findElement(By.xpath("//input[@value='Update Player']")).click();
	}
}
