package seleniumscripts;

import model.ToolModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewItemsScript implements Runnable {
	private String serverUrl;
	private String userID;
	private ToolModel toolModel;
	private String itemsType;
	private String[] itemsIds;

	public AddNewItemsScript(String serverUrl, String userID,
			ToolModel toolModel, String itemsType, String[] itemIds) {
		this.serverUrl = serverUrl;
		this.userID = userID;
		this.toolModel = toolModel;
		this.itemsType = itemsType;
		this.itemsIds = itemIds;

	}

	@Override
	public void run() {
		addItems();

	}

	private void addItems() {
		OpenPageScript openPageScript = new OpenPageScript(serverUrl, userID,
				toolModel);
		openPageScript.openPage();
		WebDriver driver = toolModel.getDriver();

		String type = "Charm";
		if (itemsType.equalsIgnoreCase("Collectable")) {
			type = "Collectable";
		}

		for (int i = 0; i < itemsIds.length; i++) {
			Select x = new Select(driver.findElement(By.name("add_item_type")));
			x.selectByVisibleText(type);
			// driver.findElement(By.name("add_item_type")).sendKeys(type);
			driver.findElement(By.name("add_item_id")).sendKeys(itemsIds[i]);
			driver.findElement(By.name("add_item_quantity")).sendKeys("1");
			driver.findElement(By.xpath("//input[@value='Update Player']"))
					.click();
		}

	}

}
