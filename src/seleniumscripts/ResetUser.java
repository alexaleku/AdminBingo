package seleniumscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import model.ToolModel;

public class ResetUser implements Runnable {
    private String serverUrl;
    private String userID;
    private ToolModel toolModel;

    public ResetUser(String serverUrl, String userID, ToolModel toolModel) {
        this.serverUrl = serverUrl;
        this.userID = userID;
        this.toolModel = toolModel;
    }

    @Override
    public void run() {
        resetUser();

    }

    private void resetUser() {
        OpenPageScript openPageScript = new OpenPageScript(serverUrl, userID, toolModel);
        openPageScript.openPage();
        WebDriver driver = toolModel.getDriver();
        
        driver.findElement(By.xpath("//input[@value='Reset']")).click();
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
