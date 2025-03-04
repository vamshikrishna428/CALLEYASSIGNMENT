package testClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import pomPages.AgentPage;
import pomPages.LoginPage;

public class addAgentsTest {
	@Test
	public void addAgents() throws IOException, InterruptedException {
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(chromeoptions);
		driver.manage().window().maximize();
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/testData.properties");
		Properties properties=new Properties();
		properties.load(fileinputstream);
		LoginPage loginpage=new LoginPage(driver);
		AgentPage agentpage=new AgentPage(driver);
		Random random=new Random();
		int randomnumber = random.nextInt(99);
		String loginurl = properties.getProperty("LoginUrl");
		driver.get(loginurl);

		String implicitwait = properties.getProperty("timeOut");
		long longtimeout = Long.parseLong(implicitwait);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longtimeout));
		String usernameData = properties.getProperty("useremail");
		String passwordData = properties.getProperty("userpassword");
		loginpage.signIn(usernameData, passwordData);
		agentpage.mouseHoverTeam();
		String agentNameTxField = properties.getProperty("AgentName");
		agentpage.addAgentNameTxField(agentNameTxField+randomnumber);
		String agentMobileNumber = properties.getProperty("AgentmobileNumber");
		agentpage.agentMobileNoTxField(agentMobileNumber+randomnumber);
		String agentEmailId = properties.getProperty("AgentEmailId");

		agentpage.agentEmailId(agentEmailId+randomnumber+"@gmail.com");
		String agentPassword = properties.getProperty("AgentPassword");
		agentpage.agentPassword(agentPassword);
		agentpage.agentSubmitButton();
		System.out.println(driver.switchTo().alert().getText());
		agentpage.confirmationPopUp();

		}
}
