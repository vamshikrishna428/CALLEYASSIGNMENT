package testClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pomPages.RegistrationPage;
@Test
public class registrationTest {

	@Test
	public void RegistrationTest() throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		RegistrationPage registrationpage=new RegistrationPage(driver);
		Properties properties=new Properties();
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/testData.properties");
		properties.load(fileinputstream);

		String implicitwait = properties.getProperty("timeOut");
		long longtimeout = Long.parseLong(implicitwait);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longtimeout));
		String registrationurl = properties.getProperty("RegistrationUrl");
		driver.get(registrationurl);
		String nametx = properties.getProperty("Name");
		String emailid = properties.getProperty("emailid");
		String password = properties.getProperty("password");
		String passwordstring = password.toString();
		String mobileno = properties.getProperty("mobileNo");
		

		registrationpage.nameTxField(nametx);
		registrationpage.emailTxField(emailid);
		registrationpage.passworsTxField(passwordstring);
		registrationpage.mobileNO(mobileno);
		registrationpage.captchaFrame();
		registrationpage.captchaCheckBox();
		registrationpage.termsConditionsCheckBox();

		registrationpage.signUpButton();
		registrationpage.smsPopUp();

	


	}
}

