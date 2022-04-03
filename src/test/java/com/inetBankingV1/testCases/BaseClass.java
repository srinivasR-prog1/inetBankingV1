package com.inetBankingV1.testCases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseURL = readConfig.getApplicationURL();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	public static JavascriptExecutor js;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		System.setProperty("logDir", "logs");
		System.setProperty("logFile", "log");
		logger = LogManager.getLogger("ebanking");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (br.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();

	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {

		driver.quit();

	}

	public static Boolean isAlertPresent() {

		try {

			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) {

			return false;

		}

	}

	/*public static String captureScreenShot(String screenShotName) throws IOException {
		String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshot\\" + screenShotName + df + ".png";
		File destFile = new File(path);

		FileUtils.copyFile(srcFile, destFile);
		return path;

	}*/

	public static String captureScreenShotRobo(String screenShotName)
			throws IOException, HeadlessException, AWTException {
		String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		String path = System.getProperty("user.dir") + "\\Screenshot\\" + screenShotName + df + ".png";
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(path));		
		return path;
	}
	
	public static String dynamicEmailid()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;		
		
	}
	
	public static WebElement WaitforElementClickable(By by,int timeSecond)
	{
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeSecond));
		WebElement elementClickable = wait.until(ExpectedConditions.elementToBeClickable(by));
		return elementClickable;
		
		
	}
	
	public static void scrollPageDown()
	{
		
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		
		
	}

}
