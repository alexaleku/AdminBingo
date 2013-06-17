package seleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import model.ToolModel;

public class AddResMasteryScript implements Runnable {
    private String serverUrl;
    private String userID;
    private ToolModel toolModel;

    public AddResMasteryScript(String serverUrl, String userID, ToolModel toolModel) {
        this.serverUrl = serverUrl;
        this.userID = userID;
        this.toolModel = toolModel;
    }

    @Override
    public void run() {       
        AddResScript addResScript = new AddResScript(serverUrl, userID, toolModel);
        addResScript.addRes();
        WebDriver driver = toolModel.getDriver();
      
        
        int ex_level1, ex_level4, ex_level9, ex_level16;
        int p_level1, p_level4, p_level9, p_level16;
        String a, b, c, d;
        String s_level1, s_level4, s_level9, s_level16;
        String aa, bb, cc, dd;

//        /html/body/div[3]/div/form[2]/table/tbody/tr[20]/td[3]
//        /html/body/div[3]/div/form[2]/table/tbody/tr[23]/td[3]
//        /html/body/div[3]/div/form[2]/table/tbody/tr[28]/td[3]
//        /html/body/div[3]/div/form[2]/table/tbody/tr[35]/td[3]
                        
            aa = "//div[@id='player_tab']/form[2]/table/tbody/tr[20]/td[3]";
            bb = "//div[@id='player_tab']/form[2]/table/tbody/tr[23]/td[3]";
            cc = "//div[@id='player_tab']/form[2]/table/tbody/tr[28]/td[3]";
            dd = "//div[@id='player_tab']/form[2]/table/tbody/tr[35]/td[3]";
            
    // resources Delta numbers calculations:
        a = driver.findElement(By.xpath(aa)).getText();
        b = driver.findElement(By.xpath(bb)).getText();
        c = driver.findElement(By.xpath(cc)).getText();
        d = driver.findElement(By.xpath(dd)).getText();
      
        ex_level1 = Integer.parseInt(a);
        ex_level4 = Integer.parseInt(b);
        ex_level9 = Integer.parseInt(c);
        ex_level16 = Integer.parseInt(d);
      
        p_level1 = 6 - ex_level1;
        p_level4 = 6 - ex_level4;
        p_level9 = 6 - ex_level9;
        p_level16 = 6 - ex_level16;

        s_level1 = Long.toString(p_level1);
        s_level4 = Long.toString(p_level4);
        s_level9 = Long.toString(p_level9);
        s_level16 = Long.toString(p_level16);

        driver.findElement(By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr[20]/td[3]/input")).clear();
        driver.findElement(By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr[20]/td[3]/input")).sendKeys(s_level1);
        driver.findElement(By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr[23]/td[3]/input")).clear();
        driver.findElement(By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr[23]/td[3]/input")).sendKeys(s_level4);
        driver.findElement(By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr[28]/td[3]/input")).clear();
        driver.findElement(By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr[28]/td[3]/input")).sendKeys(s_level9);
        driver.findElement(By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr[35]/td[3]/input")).clear();
        driver.findElement(By.xpath("//div[@id='player_tab']/form[2]/table/tbody/tr[35]/td[3]/input")).sendKeys(s_level16);
        
        driver.findElement(By.xpath("//input[@value='Update Player']")).click();
    }
}
