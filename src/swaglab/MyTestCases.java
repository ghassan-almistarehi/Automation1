package swaglab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new EdgeDriver();

	String myWebsite = "https://www.saucedemo.com/";

	@BeforeTest
	public void mySetup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(myWebsite);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void LoginWithNormalUser() {
		String TheUserName = "standard_user";
		String ThePassword = "secret_sauce";

		WebElement usernameinput = driver.findElement(By.id("user-name"));
		WebElement passowrdinput = driver.findElement(By.id("password"));

		WebElement loginbutton = driver.findElement(By.id("login-button"));
		usernameinput.sendKeys(TheUserName);
		passowrdinput.sendKeys(ThePassword);

		loginbutton.click();

		WebElement thefirstitem = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
		WebElement theseconditem = driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)"));
		thefirstitem.click();
		theseconditem.click();

	}

	@Test(priority = 2)
	public void checkoutprocess() {
		// driver.navigate().to("https://www.saucedemo.com/cart.html");
		// driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

		WebElement Thecart = driver.findElement(By.className("shopping_cart_link"));
		Thecart.click();

		WebElement checkoutButton = driver.findElement(By.name("checkout"));
		checkoutButton.click();

		WebElement thefirstname = driver.findElement(By.id("first-name"));
		WebElement thelastname = driver.findElement(By.id("last-name"));
		WebElement thepostalcode = driver.findElement(By.id("postal-code"));
		thefirstname.sendKeys("ghassan");
		thelastname.sendKeys("mistarehi");
		thepostalcode.sendKeys("1082454");

		WebElement continuebutton = driver.findElement(By.id("continue"));
		continuebutton.click();
		WebElement finishbutton = driver.findElement(By.id("finish"));
		finishbutton.click();

	}

}
