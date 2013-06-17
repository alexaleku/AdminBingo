package seleniumscripts;

//http://54.234.204.160/bingo/index.php/admin/find_player/
import model.ToolModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenPageScript implements Runnable {

    private String serverUrl;
    private String userID;
    private ToolModel toolModel;

    public OpenPageScript(String serverUrl, String userID, ToolModel toolModel) {
        this.serverUrl = serverUrl;
        this.userID = userID;
        this.toolModel = toolModel;
    }

    @Override
    public void run() {
        openPage();
    }

    void openPage() {
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
        // ------------- IF PROD SERVER------------------
        // if (server == PROD) {
        // driver.findElement(By.name("username")).sendKeys(NAME);
        // driver.findElement(By.name("password")).sendKeys(PASS);
        // driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        // }

        driver.findElement(By.name("unique")).sendKeys(userID);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        
        try {
        driver.findElement(By.linkText("Player")).click();

        
        if (driver.findElement(By.name("is_test_account")).isSelected() == false) {
            driver.findElement(By.name("is_test_account")).click();
            driver.findElement(By.xpath("//input[@value='Update Player']")).click();
        }
        }
        catch (Exception error) {
            System.out.println("Unable to locate element");
        }
    }
}
