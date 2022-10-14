package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Pages.CitiesPage;
import Pages.LoginPage;
import Pages.MessagePopUpPage;
import Pages.NavPage;
import Pages.SignupPage;

public class BasicTest {
	 protected WebDriver driver;
	    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	    protected LoginPage login;
	    protected NavPage nav;
	    protected SignupPage signUp;
	    protected CitiesPage cities;
	    protected MessagePopUpPage messagePopUp;

	    
	    @BeforeClass
	    public void beforeClass() {
	        System.setProperty("webdriver.chrome.driver",
	                "drivers/chromedriver.exe");

	        driver = new ChromeDriver();

	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	        login = new LoginPage(driver);
	        nav = new NavPage(driver);
	        signUp = new SignupPage(driver);
	        cities = new CitiesPage(driver);
	        messagePopUp = new MessagePopUpPage(driver);
	    }


	    @BeforeMethod
	    public void beforeMethod() {
	        this.driver.navigate().to(baseUrl);
	    }


	    @AfterMethod
	    public void afterMethod() {
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
