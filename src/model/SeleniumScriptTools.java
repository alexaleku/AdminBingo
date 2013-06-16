package model;
//http://54.234.204.160/bingo/index.php/admin/find_player/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumScriptTools {
	private WebDriver driver = null;

	public void openPage(String userID, String server) {
		
		System.out.println(userID);
		System.out.println(server);
		String userNam = "Undefined";

		if (driver == null) {
			driver = new FirefoxDriver();
			System.out.println("new instance");
		} 
			try {
				if (server != "") {
				driver.get(server);
				}
			} catch (Exception e) {
				driver.quit();
				driver = new FirefoxDriver();
				driver.get(server);
			}
			
			
			driver.findElement(By.name("unique")).sendKeys(userID);
			driver.findElement(By.cssSelector("input[type=\"submit\"]"))
					.click();
			driver.findElement(By.linkText("Player")).click();

			
	
	}

	

}
