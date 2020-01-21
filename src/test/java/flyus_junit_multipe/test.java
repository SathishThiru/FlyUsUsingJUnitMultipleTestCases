package flyus_junit_multipe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class test extends BaseClass {

	
	public static void selectDateOneWay()
	{
//		launchChrome();
//		openURL("https://www.flyus.com/");
//		findByXpath("//input[@id='flys-date-0']").click();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String currentDateString = sdf.format(d);
		int currentDateInInteger = Integer.valueOf(currentDateString);
		System.out.println(currentDateInInteger);
		int count = 0;
		List<WebElement> allTrWebElements = driver.findElements(By.xpath("(//tbody)[1]//tr"));
		
		for(int i=1; i<=allTrWebElements.size();  i++)
		{
			if(count>0)
			{
				break;
			}
			String xpathOfEachTrInTbody2 = "(//tbody)[1]//tr["+i+"]";
			for(int j =1; j<=7; j++)
			{
				String xpathOfEachTdInEachTr = xpathOfEachTrInTbody2+"//td["+j+"]";
				int eachTdIntegerValue=0;
				 String eachTdStringValue = findByXpath(xpathOfEachTdInEachTr).getText();
				 System.out.println(eachTdStringValue);
				try 
				{
					 eachTdIntegerValue = Integer.valueOf(eachTdStringValue);
				}
				catch(NumberFormatException e)
				{
					System.out.println("");
				}
				
				if(currentDateInInteger<28)
				{
				if(eachTdIntegerValue>currentDateInInteger) 
				{

					//now we will be in a row in which the datevalue in webpage
					//is greater than the current date
					//we will click that date 
					findByXpath(xpathOfEachTdInEachTr).click();
					//to select another date
					//we will go to next tbody and select a date
					//String xpath = "(//tbody)[2]//tr["+i+"]";

					count++;
					break;
				
				}
				
			}
				else if(currentDateInInteger>=28)
				{
					findByXpath("(//th[@class='next available'])[1]").click();
					findByXpath("(//tbody)[1]//tr[2]//td[2]").click();
					count++;
					break;
					
				}
				
				
				
			}
		}
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		selectDateOneWay();
	}
}
