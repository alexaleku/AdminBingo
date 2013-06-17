package seleniumscripts;

import model.ToolModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddResScript implements Runnable {
    

    private String serverUrl;
    private String userID;
    private ToolModel toolModel;

    public AddResScript(String serverUrl, String userID, ToolModel toolModel) {
        this.serverUrl = serverUrl;
        this.userID = userID;
        this.toolModel = toolModel;
    }

    @Override
    public void run() {
// extracted to separate method to get ability call it from addResAndMastery        
        addRes();
    }

    void addRes() {
        OpenPageScript openPageScript = new OpenPageScript(serverUrl, userID, toolModel);
        openPageScript.openPage();
        WebDriver driver = toolModel.getDriver();

        int level = 20;
        long max_coins = 50000;
        long chips = 5000;
        long gems = 5000;
        
        long ex_coins, ex_chips, ex_gems, ex_level;
        long p_coins, p_chips, p_gems, p_level;
        String a, b, c, d;
        String s_coins, s_chips, s_gems, s_level;
        String aa, bb, cc, dd;

            aa = "//div[@id='player_tab']/form[2]/table/tbody/tr[11]/td[2]";
            bb = "//div[@id='player_tab']/form[2]/table/tbody/tr[12]/td[2]";
            cc = "//div[@id='player_tab']/form[2]/table/tbody/tr[13]/td[2]";
            dd = "//div[@id='player_tab']/form[2]/table/tbody/tr[14]/td[2]";
            
    // resources Delta numbers calculations:
        a = driver.findElement(By.xpath(aa)).getText();
        b = driver.findElement(By.xpath(bb)).getText();
        c = driver.findElement(By.xpath(cc)).getText();
        d = driver.findElement(By.xpath(dd)).getText();
      
        ex_coins = Long.parseLong(a);
        ex_chips = Long.parseLong(b);
        ex_gems = Long.parseLong(c);
        ex_level = Long.parseLong(d);
      
        p_coins = max_coins - ex_coins;
        p_chips = chips - ex_chips;
        p_gems = gems - ex_gems;
        p_level = level - ex_level;

        s_coins = Long.toString(p_coins);
        s_chips = Long.toString(p_chips);
        s_gems = Long.toString(p_gems);
        s_level = Long.toString(p_level);

        driver.findElement(By.name("coins")).clear();
        driver.findElement(By.name("coins")).sendKeys(s_coins);
        driver.findElement(By.name("chips")).clear();
        driver.findElement(By.name("chips")).sendKeys(s_chips);
        driver.findElement(By.name("gems")).clear();
        driver.findElement(By.name("gems")).sendKeys(s_gems);
        driver.findElement(By.name("level")).clear();
        driver.findElement(By.name("level")).sendKeys(s_level);
        
        driver.findElement(By.xpath("//input[@value='Update Player']")).click();
    }

}
