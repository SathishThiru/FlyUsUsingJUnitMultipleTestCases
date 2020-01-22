package flyus_junit_multipe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlyUsSelectSeat extends BaseClass {

	public static void main(String[] args) throws Throwable {
		oneWay2A2C2IE();
	}

	//book tickets for 2 adults 2 children 2 Infants in Economy class
	public static int oneWay2A2C2IE() throws Throwable
	{
		launchChrome();
		driver.manage().deleteAllCookies();
		openURL("https://www.flyus.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findByXpath("//a[text()='One Way']").click();//click one way trip
		List<String> fromAndTo = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ExcelInputGivingFile.xlsx", "Sheet0", 1);
		
		fillText(findByXpath("//input[@id='flys-dpt-0']"), fromAndTo.get(0));//enter from place
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);
		
		fillText(findByXpath("//input[@id='flys-arr-0']"), fromAndTo.get(1));//enter destination
		Thread.sleep(1000);
		pressDownKey(1);
		pressEnter(1);				
		Thread.sleep(1000);
		
		selectDateOneWay();
		Thread.sleep(1000);
		
		//one adult is selected by default .so clicking only one the '+' button to add one
		//more adult passenger
		int adultCount=1;
		for(int i=1; i<2;i++)
		{
			findByXpath("(//a[text()='+'])[1]").click();
			adultCount++;
		}
		System.out.println("number of adults added = " +adultCount);
		
		//select 2 children
		int childrenCount =0;
		for(int i =1; i<=2;i++)
		{
			findByXpath("(//a[text()='+'])[2]").click();
			childrenCount++;
		}
		System.out.println("number of children added = " +childrenCount);

		//select 2 infants
		int infantCount=0;
		for(int i=1; i<=2; i++)
		{
			findByXpath("(//a[text()='+'])[3]").click();
			infantCount++;
		}
		System.out.println("number of infants added = " +infantCount);

		//click submit or search button
		findByXpath("//button[@type='submit']").click();
		
		//a  floating window will appear. wait till that to appear and then close it
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		findByXpath("(//button[@ng-click='paModalCtrl.close()'])[1]").click();
		findByXpath("(//img[@src='img/white-arrow-continue.svg'])[1]").click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//enter adult passenger details
		int i=0;
		for( i=0; i<adultCount;i++)
		{
			List<String> adultsDetails = new ArrayList<String>(); 
			adultsDetails = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\AdultsRecords.xlsx", "Sheet1", (i+1));
			selectByVisibleText(findByXpath("//select[@id='title-pax-"+i+"']"), adultsDetails.get(0));
			selectByVisibleText(findByXpath("//select[@id='gender-pax-"+i+"']"), adultsDetails.get(1));
			fillText(findByXpath("//input[@id='fname-pax-"+i+"']"), adultsDetails.get(2) );
			fillText(findByXpath("//input[@id='lname-pax-"+i+"']"), adultsDetails.get(3));
			findByXpath("//input[@id='paxes-ADULT-"+i+"-dob']").click();
			fillText(findByXpath("//input[@id='paxes-ADULT-"+i+"-dob']"),  adultsDetails.get(4));
		}

		//enter children passenger details
		for(int k=0; k<childrenCount; k++)
		{	List<String> childrenDetails = new ArrayList<String>(); 
		childrenDetails = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\ChildrenRecords.xlsx", "Sheet1", (k+1));
		scrollDown(findByXpath("//select[@id='title-pax-"+i+"']"));
		selectByVisibleText(findByXpath("//select[@id='title-pax-"+i+"']"), childrenDetails.get(0));
		selectByVisibleText(findByXpath("//select[@id='gender-pax-"+i+"']"), childrenDetails.get(1));
		fillText(findByXpath("//input[@id='fname-pax-"+i+"']"), childrenDetails.get(2) );
		fillText(findByXpath("//input[@id='lname-pax-"+i+"']"), childrenDetails.get(3));
		findByXpath("//input[@id='paxes-CHILDREN-"+i+"-dob']").click();
		fillText(findByXpath("//input[@id='paxes-CHILDREN-"+i+"-dob']"),  childrenDetails.get(4));
		i++;

		}

		//enter infant passengers details
		for(int l=0; l<infantCount;l++)
		{
			List<String> infantDetails = new ArrayList<String>(); 
			infantDetails = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\InfantsRecord.xlsx", "Sheet1", (l+1));
			scrollDown(findByXpath("//select[@id='title-pax-"+i+"']"));
			selectByVisibleText(findByXpath("//select[@id='title-pax-"+i+"']"), infantDetails.get(0));
			selectByVisibleText(findByXpath("//select[@id='gender-pax-"+i+"']"), infantDetails.get(1));
			fillText(findByXpath("//input[@id='fname-pax-"+i+"']"), infantDetails.get(2) );
			fillText(findByXpath("//input[@id='lname-pax-"+i+"']"), infantDetails.get(3));
			findByXpath("//input[@id='paxes-INFANT-"+i+"-dob']").click();
			fillText(findByXpath("//input[@id='paxes-INFANT-"+i+"-dob']"),  infantDetails.get(4));
			i++;
		}


		//click select seat if it is displayed
		if(findByXpath("//a[contains(text(),'Select Your Seat')]").isDisplayed())
		{
			scrollDown(findByXpath("//a[contains(text(),'Select Your Seat')]"));

			findByXpath("//a[contains(text(),'Select Your Seat')]").click();
		}

		//below block is to find the total number of all passengers

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
		//above line - our logic to find total number of passengers is over

		//to find total number of infants	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String infantsString = findByXpath("((//div[@class='wrapper'])[2]//div[@class='clearfix ng-scope']//span[@class='clear font-bold ng-binding'])[3]").getText();
		char c1 =infantsString.charAt(infantsString.length()-1);
		String noOfInfantsString = String.valueOf(c1);
		int noOfInfantsInteger = Integer.valueOf(noOfInfantsString);
		//logic to find total number of infants is over
		
		//below - we find the number of selectable non premium seats
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> noOfSelectableSeatsWebelements = driver.findElements(By.xpath("(//tbody)[3]//tr//td//img[@src='img/sm/seat-available.png']"));
		System.out.println("Total number of available seats:" +noOfSelectableSeatsWebelements.size());

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int count=0;
		//below code is to select seats for adult and children
		for(int m=0; m<(sumOfAllPassengers-noOfInfantsInteger); m++)
		{
			noOfSelectableSeatsWebelements.get(m).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Select s = new Select(findByXpath("(//select[@data-ng-model='ckCtrl.smInfo.selPaxSeat'])[1]"));
			List<WebElement> allNameOptionsInSeatSelect = s.getOptions();
			List<String> allNames = new ArrayList<String>();
			for (WebElement webElement : allNameOptionsInSeatSelect) 
			{
				allNames.add(webElement.getText());
			}

			if(count==0) {
				s.selectByVisibleText( allNames.get(m+1));
				//we cant give get(i) at first time above. becaus for the first time
				//the select will have three items
				//and index 0 has an empty space.
				count++;
			}

			else
			{
				s.selectByVisibleText( allNames.get(m));
			}
			findByXpath("(//button[text()='Select seat'])[1]").click();
			Thread.sleep(1000);	
		}//select seats for adult and children ends

		//close the floating seat selection frame to proceed
		findByXpath("(//img[@src='img/red-close.svg'])[2]").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//get the total price from the website and record it in excel sheet
		String price = findByXpath("(//span[@id='flyus-grand-total'])[2]").getText();
		excelWriteSingleCell("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\OneWayTwoAdultEconomy.xlsx", "sheet1", 0, 0, price);

		System.out.println("total number of passengers: " +sumOfAllPassengers);

		driver.quit();

		return sumOfAllPassengers;
	}

}
