package testClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import pomPages.CSVUploadPage;
import pomPages.LoginPage;

public class fullTeamSetUpTest {
	@Test
	public void teamSetUp() throws AWTException, IOException, InterruptedException {
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(chromeoptions);
		driver.manage().window().maximize();
		
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/testData.properties");
		Properties properties=new Properties();
		LoginPage loginpage=new LoginPage(driver);
		AgentPage agentpage=new AgentPage(driver);
		CSVUploadPage csvuploadpage=new CSVUploadPage(driver);
		Random random=new Random();
		int randomnumber = random.nextInt(99);
		
		properties.load(fileinputstream);
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
		agentpage.confirmationPopUp();
		
		agentpage.mouseHoverCallList();

		String listNameTest = properties.getProperty("ListName");

		csvuploadpage.listNameTextField(listNameTest);

		csvuploadpage.selectAnAgent();

		csvuploadpage.selectAll();
		csvuploadpage.mouseHover();
		Thread.sleep(2000);
		csvuploadpage.fileUpLoad();

		Robot robot = new Robot();
		robot.delay(2000);
		StringSelection stringselection = new StringSelection("C:\\Users\\vamsh\\Downloads\\Sample File.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER); 

		csvuploadpage.uploadFileButton();
		csvuploadpage.sweetPopUpButton();
		
		csvuploadpage.belongToFirstName();
		csvuploadpage.belongToPhoneNumber();
		csvuploadpage.belongToNotes();
		csvuploadpage.importDataButton();
		csvuploadpage.dataUploadedSuccessfullyPopUp();


	}
}
