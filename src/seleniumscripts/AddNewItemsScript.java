package seleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import model.ToolModel;

public class AddNewItemsScript implements Runnable {
    private String serverUrl;
    private String userID;
    private ToolModel toolModel;
    private String itemsType;
    private String[] itemsIds;
    

    public AddNewItemsScript(String serverUrl, String userID, ToolModel toolModel, String itemsType, String[] itemIds) {
        this.serverUrl = serverUrl;
        this.userID = userID;
        this.toolModel = toolModel;
        this.itemsType =  itemsType;
        this.itemsIds = itemIds;
       
    }

    @Override
    public void run() {
        addItems();

    }

    private void addItems() {
        OpenPageScript openPageScript = new OpenPageScript(serverUrl, userID, toolModel);
        openPageScript.openPage();
        WebDriver driver = toolModel.getDriver();
        
        
        String type = "Charm";
        if(itemsType.equalsIgnoreCase("Collactable")) {
            type = "Collactable";
        } 
        
        for (int i = 0; i < itemsIds.length; i++) {
            driver.findElement(By.name("add_item_type")).sendKeys(type);
            driver.findElement(By.name("add_item_id")).sendKeys(itemsIds[i]);
            driver.findElement(By.xpath("//input[@value='Update Player']")).click();
        }
        
    }

}
