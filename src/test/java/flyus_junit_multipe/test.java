package flyus_junit_multipe;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class test extends BaseClass {

	
	public static void main(String[] args) throws IOException {
		
		for(int i=0; i<=5; i++)
		{
		List<String> str = excelReadRow("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FlyUsUsingJUnitMultipleTestCases\\ExcelFiles\\AdultsRecords.xlsx", "Sheet1", i);
		for (String string : str) {
			System.out.println(string);
			
		}
		}
	}
}
