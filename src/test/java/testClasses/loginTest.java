package testClasses;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomPages.LoginPage;
@Test
public class loginTest {
	@Test
	public void login() throws InterruptedException, IOException, AWTException {
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(chromeoptions);
		driver.manage().window().maximize();
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/testData.properties");
		Properties properties=new Properties();
		properties.load(fileinputstream);
		LoginPage loginpage=new LoginPage(driver);
		String loginurl = properties.getProperty("LoginUrl");
		driver.get(loginurl);

		String implicitwait = properties.getProperty("timeOut");
		long longtimeout = Long.parseLong(implicitwait);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longtimeout));
		String usernameData = properties.getProperty("useremail");
		String passwordData = properties.getProperty("userpassword");
		loginpage.signIn(usernameData, passwordData);

		String expectedtitle = "Getcalley - Dashboard";
		String actualtitle = driver.getTitle();
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualtitle,expectedtitle);
		driver.quit();
		softassert.assertAll();

		

	}

}
