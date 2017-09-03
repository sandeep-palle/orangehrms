package hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class Hrm {
	public static WebDriver driver = null;	
	@BeforeClass
	public static void createWebDriver() {
		System.setProperty("webdriver.gecko.driver","C:\\developement\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
}

	@Test
	public void login(){
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		
	}
	@Test(dependsOnMethods="login")
	public void pim(){
		Actions action = new Actions(driver);
		WebElement e = driver.findElement(By.linkText("PIM"));
		action.moveToElement(e).build().perform();
		driver.findElement(By.linkText("Employee List")).click();
	}
	@Test(dependsOnMethods="pim")
	public void logout(){
		driver.findElement(By.linkText("Logout")).click();
		
	}
	@AfterClass
public static void close(){
		driver.quit();
	}
	
	
	
}
	
	
