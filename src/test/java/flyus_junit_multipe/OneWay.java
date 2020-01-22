package flyus_junit_multipe;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class OneWay extends BaseClass
{	
	public static int oneW1AE() throws Throwable
	{
		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		selectDateOneWay();
		Thread.sleep(1000);
		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		selectByVisibleText(findByXpath("//select[@name='paxes[ADULT-0][title]']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));

		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(3000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));
		String price = findByXpath("(//h2[@class='m-t-none m-b-xs ng-binding'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayOneAdultEconomy.xlsx", "sheet1", 0, 0, price);
		String numberOfAdultsString = findByXpath("(//span[text()='Adult: X1'])[2]").getText();
		char c =numberOfAdultsString.charAt(numberOfAdultsString.length()-1);
		String str = String.valueOf(c);
		int numberOfAdults = Integer.valueOf(str);

		System.out.println("number of adults"+numberOfAdults);

		driver.quit();

		return numberOfAdults;



	}


	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//one way one adult one child economy
	public static int oneW1A1CE() throws Throwable
	{

		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		selectDateOneWay();
		Thread.sleep(1000);
		//add one children //one adult is by default selected
		findByXpath("(//a[text()='+'])[2]").click();
		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//passenger 1 details
		selectByVisibleText(findByXpath("//select[@name='paxes[ADULT-0][title]']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));

		//passenger 2 details

		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-1-dob']"),  name.get(2));

		//billing details
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(3000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));

		String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayOneAdultOneChildEconomy.xlsx", "sheet1", 0, 0, price);


		List<WebElement> numberOfPassengersWebElement = driver.findElements(By.xpath("(//div[@class='wrapper'])[2]//span[text()='Total Average Amount Per Passenger']"));


		driver.quit();

		return numberOfPassengersWebElement.size();



	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public static int oneW1A1C1IE() throws Throwable
	{


		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		selectDateOneWay();
		Thread.sleep(1000);
		//add one children //one adult is by default selected
		findByXpath("(//a[text()='+'])[2]").click();

		//add one infant
		findByXpath("(//a[text()='+'])[3]").click();

		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//passenger 1 details
		selectByVisibleText(findByXpath("//select[@name='paxes[ADULT-0][title]']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));

		//passenger 2 details

		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-1-dob']"),  name.get(2));

		//passenger 3 details
		scrollDown(findByXpath("//select[@id='title-pax-2']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-2']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-2']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-2']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-2']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-2-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-2-dob']"),  name.get(2));


		//billing details
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(3000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));

		String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayOneAdultOneChildOneInfantEconomy.xlsx", "sheet1", 0, 0, price);


		List<WebElement> numberOfPassengersWebElement = driver.findElements(By.xpath("(//div[@class='wrapper'])[2]//span[text()='Total Average Amount Per Passenger']"));


		driver.quit();

		return numberOfPassengersWebElement.size();




	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public static int oneW2A1C1IE() throws Throwable
	{



		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		selectDateOneWay();
		Thread.sleep(1000);
		//we need to add two adults. but one adult is by default selected.
		//so we click only once
		findByXpath("(//a[text()='+'])[1]").click();

		//add one children //one adult is by default selected
		findByXpath("(//a[text()='+'])[2]").click();

		//add one infant
		findByXpath("(//a[text()='+'])[3]").click();

		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//adult passenger 1 details
		selectByVisibleText(findByXpath("//select[@id='title-pax-0']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));

		//adult passenger 2 details
		scrollDown(findByXpath("//select[@id='title-pax-1']"));

		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Male");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-1-dob']"),  name.get(2));



		//child passenger  details
		scrollDown(findByXpath("//select[@id='title-pax-2']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-2']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-2']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-2']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-2']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-2-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-2-dob']"),  name.get(2));

		//infant details

		scrollDown(findByXpath("//select[@id='title-pax-3']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-3']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-3']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-3']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-3']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-3-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-3-dob']"),  name.get(2));


		//billing details
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(2000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));

		String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayTwoAdultOneChildOneInfantEconomy.xlsx", "sheet1", 0, 0, price);


		List<WebElement> numberOfPassengersWebElement = driver.findElements(By.xpath("(//div[@class='wrapper'])[2]//span[text()='Total Average Amount Per Passenger']"));


		driver.quit();

		return numberOfPassengersWebElement.size();





	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static int oneW2A2C1IE() throws Throwable
	{
		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		selectDateOneWay();
		Thread.sleep(1000);
		//we need to add two adults. but one adult is by default selected.
		//so we click only once
		findByXpath("(//a[text()='+'])[1]").click();

		//add two children /
		findByXpath("(//a[text()='+'])[2]").click();

		findByXpath("(//a[text()='+'])[2]").click();

		//add one infant
		findByXpath("(//a[text()='+'])[3]").click();

		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//adult passenger 1 details
		selectByVisibleText(findByXpath("//select[@id='title-pax-0']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));

		//adult passenger 2 details
		scrollDown(findByXpath("//select[@id='title-pax-1']"));

		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Male");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-1-dob']"),  name.get(2));



		//child passenger  details
		scrollDown(findByXpath("//select[@id='title-pax-2']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-2']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-2']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-2']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-2']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-2-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-2-dob']"),  name.get(2));

		//child passenger 2
		scrollDown(findByXpath("//select[@id='title-pax-3']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-3']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-3']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-3']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-3']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-3-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-3-dob']"),  name.get(2));

		//infant details

		scrollDown(findByXpath("//select[@id='title-pax-4']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-4']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-4']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-4']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-4']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-4-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-4-dob']"),  name.get(2));


		//billing details
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(2000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));

		String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayTwoAdultOneChildOneInfantEconomy.xlsx", "sheet1", 0, 0, price);


		List<WebElement> numberOfPassengersWebElement = driver.findElements(By.xpath("(//div[@class='wrapper'])[2]//div[@class='clearfix ng-scope']//span[@class='clear font-bold ng-binding']"));
		int sumOfAllPassengers =0;
		for (WebElement webElement : numberOfPassengersWebElement) 
		{
			String noOfPassengersString = webElement.getText();
			char c = noOfPassengersString.charAt(noOfPassengersString.length()-1);
			String str = String.valueOf(c);
			int noOfPassengersInteger = Integer.valueOf(str);
			sumOfAllPassengers=sumOfAllPassengers+noOfPassengersInteger;
		}
		
		System.out.println("total number of passengers: " +sumOfAllPassengers);

		driver.quit();

		return sumOfAllPassengers;
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static int oneW2A2C2IE() throws Throwable
	{

		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		selectDateOneWay();
		Thread.sleep(1000);
		//we need to add two adults. but one adult is by default selected.
		//so we click only once
		findByXpath("(//a[text()='+'])[1]").click();

		//add two children /
		findByXpath("(//a[text()='+'])[2]").click();

		findByXpath("(//a[text()='+'])[2]").click();

		//add 2 infant
		findByXpath("(//a[text()='+'])[3]").click();
		findByXpath("(//a[text()='+'])[3]").click();

		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//adult passenger 1 details
		selectByVisibleText(findByXpath("//select[@id='title-pax-0']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));

		//adult passenger 2 details
		scrollDown(findByXpath("//select[@id='title-pax-1']"));

		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Male");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-1-dob']"),  name.get(2));



		//child passenger  details
		scrollDown(findByXpath("//select[@id='title-pax-2']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-2']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-2']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-2']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-2']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-2-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-2-dob']"),  name.get(2));

		//child passenger 2
		scrollDown(findByXpath("//select[@id='title-pax-3']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-3']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-3']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-3']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-3']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-3-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-3-dob']"),  name.get(2));

		//infant details

		scrollDown(findByXpath("//select[@id='title-pax-4']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-4']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-4']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-4']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-4']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-4-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-4-dob']"),  name.get(2));
		
		//infant 2 details

		scrollDown(findByXpath("//select[@id='title-pax-5']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-5']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-5']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-5']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-5']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-5-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-5-dob']"),  name.get(2));

		//billing details
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(2000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));

		String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayTwoAdultOneChildOneInfantEconomy.xlsx", "sheet1", 0, 0, price);


		List<WebElement> numberOfPassengersWebElement = driver.findElements(By.xpath("(//div[@class='wrapper'])[2]//div[@class='clearfix ng-scope']//span[@class='clear font-bold ng-binding']"));
		int sumOfAllPassengers =0;
		for (WebElement webElement : numberOfPassengersWebElement) 
		{
			String noOfPassengersString = webElement.getText();
			char c = noOfPassengersString.charAt(noOfPassengersString.length()-1);
			String str = String.valueOf(c);
			int noOfPassengersInteger = Integer.valueOf(str);
			sumOfAllPassengers=sumOfAllPassengers+noOfPassengersInteger;
		}
		
		System.out.println("total number of passengers: " +sumOfAllPassengers);

		driver.quit();

		return sumOfAllPassengers;
	
	}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static int oneW102E() throws Throwable
	{


		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		selectDateOneWay();
		Thread.sleep(1000);
		//add 2 infant: only one infant is allowed with one adult. 
		findByXpath("(//a[text()='+'])[3]").click();
		Thread.sleep(1000);

		findByXpath("(//a[text()='+'])[3]").click();

		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//adult passenger 1 details
		selectByVisibleText(findByXpath("//select[@id='title-pax-0']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));

		//infant details

		scrollDown(findByXpath("//select[@id='title-pax-1']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-1-dob']"),  name.get(2));
		
		//infant 2 details
try {
		scrollDown(findByXpath("//select[@id='title-pax-2']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-2']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-2']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-2']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-2']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-2-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-2-dob']"),  name.get(2));
}catch(NoSuchElementException e) {}

		//billing details
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(2000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));

		String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWay102Economy.xlsx", "sheet1", 0, 0, price);


		List<WebElement> numberOfPassengersWebElement = driver.findElements(By.xpath("(//div[@class='wrapper'])[2]//div[@class='clearfix ng-scope']//span[@class='clear font-bold ng-binding']"));
		int sumOfAllPassengers =0;
		for (WebElement webElement : numberOfPassengersWebElement) 
		{
			String noOfPassengersString = webElement.getText();
			char c = noOfPassengersString.charAt(noOfPassengersString.length()-1);
			String str = String.valueOf(c);
			int noOfPassengersInteger = Integer.valueOf(str);
			sumOfAllPassengers=sumOfAllPassengers+noOfPassengersInteger;
		}
		
		System.out.println("total number of passengers: " +sumOfAllPassengers);

		driver.quit();

		return sumOfAllPassengers;
	
	
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static int oneW112() throws Throwable
	{
		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		selectDateOneWay();
		Thread.sleep(1000);
		//we need to add two adults. but one adult is by default selected.
		
		//add one child /
		findByXpath("(//a[text()='+'])[2]").click();

		//add 2 infant: but 2nd click should not happen. one adult can carry only one infant
		findByXpath("(//a[text()='+'])[3]").click();
		findByXpath("(//a[text()='+'])[3]").click();

		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//adult passenger 1 details
		selectByVisibleText(findByXpath("//select[@id='title-pax-0']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));

		//child passenger  details
		scrollDown(findByXpath("//select[@id='title-pax-1']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-1-dob']"),  name.get(2));


		//infant details

		scrollDown(findByXpath("//select[@id='title-pax-2']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-2']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-2']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-2']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-2']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-2-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-2-dob']"),  name.get(2));
		
		//infant 2 details
try {
		scrollDown(findByXpath("//select[@id='title-pax-3']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-3']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-3']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-3']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-3']"), name.get(1));
		findByXpath("//input[@id='paxes-INFANT-3-dob']").click();
		fillText(findByXpath("//input[@id='paxes-INFANT-3-dob']"),  name.get(2));
} catch(NoSuchElementException e) {}

		//billing details
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(2000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));

		String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayTwoAdultOneChildOneInfantEconomy.xlsx", "sheet1", 0, 0, price);


		List<WebElement> numberOfPassengersWebElement = driver.findElements(By.xpath("(//div[@class='wrapper'])[2]//div[@class='clearfix ng-scope']//span[@class='clear font-bold ng-binding']"));
		int sumOfAllPassengers =0;
		for (WebElement webElement : numberOfPassengersWebElement) 
		{
			String noOfPassengersString = webElement.getText();
			char c = noOfPassengersString.charAt(noOfPassengersString.length()-1);
			String str = String.valueOf(c);
			int noOfPassengersInteger = Integer.valueOf(str);
			sumOfAllPassengers=sumOfAllPassengers+noOfPassengersInteger;
		}
		
		System.out.println("total number of passengers: " +sumOfAllPassengers);

		driver.quit();

		return sumOfAllPassengers;
	
	
	
	}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

public static int oneW121E() throws Throwable
{

	launchChrome();
	driver.manage().deleteAllCookies();
	openURL("https://www.flyus.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	findByXpath("//a[text()='One Way']").click();
	List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
	fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
	Thread.sleep(1000);
	pressDownKey(1);
	pressEnter(1);
	fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
	Thread.sleep(1000);
	pressDownKey(1);
	pressEnter(1);				
	Thread.sleep(1000);
	selectDateOneWay();
	Thread.sleep(1000);

	//add two children /
	findByXpath("(//a[text()='+'])[2]").click();

	findByXpath("(//a[text()='+'])[2]").click();

	//add 1 infant
	findByXpath("(//a[text()='+'])[3]").click();
	findByXpath("(//a[text()='+'])[3]").click();

	findByXpath("//button[@type='submit']").click();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
	findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//adult passenger 1 details
	selectByVisibleText(findByXpath("//select[@id='title-pax-0']"), "Mr.");
	selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
	List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
	fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
	fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
	findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
	fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));



	//child passenger  1 details
	scrollDown(findByXpath("//select[@id='title-pax-1']"));
	selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Ms.");
	selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Female");
	fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
	fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
	findByXpath("//input[@id='paxes-CHILDREN-1-dob']").click();
	fillText(findByXpath("//input[@id='paxes-CHILDREN-1-dob']"),  name.get(2));

	//child passenger 2
	scrollDown(findByXpath("//select[@id='title-pax-2']"));
	selectByVisibleText(findByXpath("//select[@id='title-pax-2']"), "Ms.");
	selectByVisibleText(findByXpath("//select[@id='gender-pax-2']"), "Female");
	fillText(findByXpath("//input[@id='fname-pax-2']"), name.get(0) );
	fillText(findByXpath("//input[@id='lname-pax-2']"), name.get(1));
	findByXpath("//input[@id='paxes-CHILDREN-2-dob']").click();
	fillText(findByXpath("//input[@id='paxes-CHILDREN-2-dob']"),  name.get(2));

	//infant details

	scrollDown(findByXpath("//select[@id='title-pax-3']"));
	selectByVisibleText(findByXpath("//select[@id='title-pax-3']"), "Ms.");
	selectByVisibleText(findByXpath("//select[@id='gender-pax-3']"), "Female");
	fillText(findByXpath("//input[@id='fname-pax-3']"), name.get(0) );
	fillText(findByXpath("//input[@id='lname-pax-3']"), name.get(1));
	findByXpath("//input[@id='paxes-INFANT-3-dob']").click();
	fillText(findByXpath("//input[@id='paxes-INFANT-3-dob']"),  name.get(2));


	//billing details
	fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
	fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
	fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
	selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
	Thread.sleep(2000);
	selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
	fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
	fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
	fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
	fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
	fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));

	String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
	excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayTwoAdultOneChildOneInfantEconomy.xlsx", "sheet1", 0, 0, price);


	List<WebElement> numberOfPassengersWebElement = driver.findElements(By.xpath("(//div[@class='wrapper'])[2]//div[@class='clearfix ng-scope']//span[@class='clear font-bold ng-binding']"));
	int sumOfAllPassengers =0;
	for (WebElement webElement : numberOfPassengersWebElement) 
	{
		String noOfPassengersString = webElement.getText();
		char c = noOfPassengersString.charAt(noOfPassengersString.length()-1);
		String str = String.valueOf(c);
		int noOfPassengersInteger = Integer.valueOf(str);
		sumOfAllPassengers=sumOfAllPassengers+noOfPassengersInteger;
	}
	
	System.out.println("total number of passengers: " +sumOfAllPassengers);

	driver.quit();

	return sumOfAllPassengers;



}


}
