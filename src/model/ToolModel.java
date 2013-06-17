package model;

import org.openqa.selenium.WebDriver;

import seleniumscripts.AddNewItemsScript;
import seleniumscripts.AddResMasteryScript;
import seleniumscripts.AddResScript;
import seleniumscripts.OpenPageScript;
import seleniumscripts.ResetUser;

public class ToolModel {
    private String itemType;
    private String[] itemIds;
    private WebDriver driver = null;

    public void runScript(String serverUrl, String userId, ScriptName scriptName) {

       
        Thread thread = null;

        switch (scriptName) {
        case opUsPg:
            OpenPageScript openPageScript = new OpenPageScript(serverUrl, userId, this);
            thread = new Thread(openPageScript);
            
            break;
        case addRes:
            AddResScript addResScript = new AddResScript(serverUrl, userId, this);
            thread = new Thread(addResScript);
            
            break;
        case addResMas:
            AddResMasteryScript addResMasteryScript = new AddResMasteryScript(serverUrl, userId, this);
            thread = new Thread(addResMasteryScript);
            
            break;
        case newItems:
            
            
            AddNewItemsScript addNewItemsScript = new AddNewItemsScript(serverUrl, userId, this, itemType, itemIds);
            thread = new Thread(addNewItemsScript);

            break;
        case reset:
            ResetUser resetUser  = new ResetUser(serverUrl, userId, this);
            thread = new Thread(resetUser);
            
            break;
        case dropAll:

            break;
        default:
            break;
        }

        thread.start();

    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemIds(String[] itemIdsArray) {
        this.itemIds = itemIdsArray;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

}
