package flyus_junit_multipe;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlyUsAllModules extends BaseClass
{
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		oneWay1Adult();
	
	}
	public static int OneAdult1Child() throws IOException, InterruptedException, AWTException
	{

		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		screenshot("OneAdult1Child\\mainPage.jpeg");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		screenshot("OneAdult1Child\\dateSelected.jpeg");
		Thread.sleep(1000);
		findByXpath("//span[text()='Children']/following-sibling::div/child::a[text()='+']").click();		
		Thread.sleep(1000);

		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		screenshot("OneAdult1Child\\searchResults.jpeg");
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		screenshot("OneAdult1Child\\selectedFlight.jpeg");
		selectByVisibleText(findByXpath("//select[@name='paxes[ADULT-0][title]']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));
		
		
		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-1-dob']"),  name.get(2));
		
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		
		//selecting country, state
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(3000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		
		//entering city name, zip code, phone, email and email confirmation
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));
		//findByXpath("(//input[@type='checkbox'])[2]").click();
		//findByXpath("//button[text()='CONTINUE & BOOK']").click();
	//	returnActionsObj().cl
		
		//getting text and writing in excel
		String price = findByXpath("(//h2[@class='m-t-none m-b-xs ng-binding'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelOutputRecordingFile.xlsx", "sheet1", 0, 0, price);
		screenshot("OneAdult1Child\\selectedFlightlast.jpeg");

	return 1;
		
		
	}
	
	
	
	public static int oneWay1Adult() throws IOException, InterruptedException, AWTException
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
		test.selectDateOneWay();
		Thread.sleep(1000);
		findByXpath("//span[text()='Children']/following-sibling::div/child::a[text()='+']").click();		
		Thread.sleep(1000);

		findByXpath("//button[@type='submit']").click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		screenshot("OneAdult1Child\\searchResults.jpeg");
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		screenshot("OneAdult1Child\\selectedFlight.jpeg");
		selectByVisibleText(findByXpath("//select[@name='paxes[ADULT-0][title]']"), "Mr.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-0']"), "Male");
		List<String> name = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\ThridProjectFlyUs\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 2);
		fillText(findByXpath("//input[@id='fname-pax-0']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-0']"), name.get(1));
		findByXpath("//input[@id='paxes-ADULT-0-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-0-dob']"),  name.get(2));
		
		
		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-1']"), name.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), name.get(1));
		findByXpath("//input[@id='paxes-CHILDREN-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-1-dob']"),  name.get(2));
		
		fillText(findByXpath("//input[@id='cc-first-name']"), name.get(0));
		fillText(findByXpath("//input[@id='cc-last-name']"), name.get(1));
		
		fillText(findByXpath("(//input[@id='billing-address'])[1]"), name.get(3));
		
		//selecting country, state
		selectByVisibleText(findByXpath("//select[@id='cc-country']"), "India");
		Thread.sleep(3000);
		selectByVisibleText(findByXpath("//select[@id='cc-region']"), "Tamil Nadu");
		
		//entering city name, zip code, phone, email and email confirmation
		fillText(findByXpath("//input[@id='cc-city']"), name.get(4));
		fillText(findByXpath("//input[@id='cc-zip']"), name.get(5));
		fillText(findByXpath("//input[@id='cc-phone']"), name.get(6));
		fillText(findByXpath("//input[@id='cc-email']"), name.get(7));
		fillText(findByXpath("//input[@id='cc-email-conf']"), name.get(7));
		//findByXpath("(//input[@type='checkbox'])[2]").click();
		//findByXpath("//button[text()='CONTINUE & BOOK']").click();
	//	returnActionsObj().cl
		
		//getting text and writing in excel
		String price = findByXpath("(//h2[@class='m-t-none m-b-xs ng-binding'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelOutputRecordingFile.xlsx", "sheet1", 0, 0, price);
		screenshot("OneAdult1Child\\selectedFlightlast.jpeg");

	return 1;
		
		
	
	}
	

}
