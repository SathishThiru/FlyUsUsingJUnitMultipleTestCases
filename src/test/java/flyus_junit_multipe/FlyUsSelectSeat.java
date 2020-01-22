package flyus_junit_multipe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlyUsSelectSeat extends BaseClass {

	public static void main(String[] args) throws Throwable {
		 oneWay2AE();
	}
	
	public static int oneWay2AE() throws Throwable
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
		//one adult is selected by default .so clicking only one the '+' button to add one
		//more adult passenger
		findByXpath("(//a[text()='+'])[1]").click();


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



		//adult passenger 2 details
		List<String> passengerdetails2 = excelReadRow("C:\\\\Users\\\\sathishPC\\\\Desktop\\\\selenium\\\\Programs\\\\FlyUsUsingJUnitMultipleTestCases\\\\ExcelFiles\\\\ExcelInputGivingFile.xlsx", "Sheet0", 3);

		scrollDown(findByXpath("//select[@id='title-pax-1']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-1']"), "Ms.");
		selectByVisibleText(findByXpath("//select[@id='gender-pax-1']"), "Female");
		fillText(findByXpath("//input[@id='fname-pax-1']"), passengerdetails2.get(0) );
		fillText(findByXpath("//input[@id='lname-pax-1']"), passengerdetails2.get(1));
		findByXpath("//input[@id='paxes-ADULT-1-dob']").click();
		fillText(findByXpath("//input[@id='paxes-ADULT-1-dob']"),  passengerdetails2.get(2));
		
		//select seat
		if(findByXpath("//a[contains(text(),'Select Your Seat')]").isDisplayed())
		{
		scrollDown(findByXpath("//a[contains(text(),'Select Your Seat')]"));
		
		findByXpath("//a[contains(text(),'Select Your Seat')]").click();
		}
		
		//to find the total number of all passengers

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
		System.out.println("total number of passenger:" +sumOfAllPassengers);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> selectSeatsWebElements = driver.findElements(By.xpath("(//tbody)[3]//tr//td//img[@src='img/sm/seat-available.png']"));
		System.out.println("Total number of available seats:" +selectSeatsWebElements.size());
	//	selectSeatsWebElements.get(0).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int count=0;
		for(int i=0; i<sumOfAllPassengers; i++)
		{
			selectSeatsWebElements.get(i).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Select s = new Select(findByXpath("(//select[@data-ng-model='ckCtrl.smInfo.selPaxSeat'])[1]"));
			List<WebElement> allNameOptionsInSeatSelect = s.getOptions();
			List<String> allNames = new ArrayList<String>();
			for (WebElement webElement : allNameOptionsInSeatSelect) 
			{
				allNames.add(webElement.getText());
			}
			
			if(count==0) {
			s.selectByVisibleText( allNames.get(i+1));
			//we cant give get(i) at first time above. becaus for the first time
			//the select will have three itemse
			//and index 0 has an empty space.
			count++;
			}
		
			else
			{
				s.selectByVisibleText( allNames.get(i));
			}
			findByXpath("(//button[text()='Select seat'])[1]").click();
			Thread.sleep(1000);	
		}//for loop ends
		
		//close the floating seat selection space to proceed
		findByXpath("(//img[@src='img/red-close.svg'])[2]").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
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
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayTwoAdultEconomy.xlsx", "sheet1", 0, 0, price);

		System.out.println("total number of passengers: " +sumOfAllPassengers);

		driver.quit();

		return sumOfAllPassengers;




	}
	
}
