package stepDefinitions;



import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSteps {
	WebDriver driver;
	
	@Before ("@parameter")
	public void openFacebookApplication() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://vi-vn.facebook.com/login.php/");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	
	@After ("@parameter")
	public void closeApplication() {
		driver.quit();
		
	}
	
	@When("Input to Username textbox")
	public void inputToUsernameTextbox() {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test2307qa@gmail.com");
	    
	}
	
	@When("Input to Password textbox")
	public void inputToPasswordTextbox() {
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Test123!");    
	}
	
	@When("Input to Username textbox with {string}")
	public void inputToUsernameTextboxWith(String userName) {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);    
		
	}
	
	@When("Input to Password textbox with {string}")
	public void inputToPasswordTextboxWith(String password) {
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);    
	
	}
	
	@When("Input to Username textbox with {string} and Password with {string}")
	public void inputToUsernameTextboxWithAndPasswordWith(String userName, String password) {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);    
	
		
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);    
	}
	
	@When("Click to Login button")
	public void clickToLoginButton() {
	    driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
	}
	
	@When("Input to Username and Password")
	public void inputToUsernameAndPassword(DataTable table) {
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(customer.get(0).get("Username"));
		
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(customer.get(0).get("Password"));
	}
	

}
