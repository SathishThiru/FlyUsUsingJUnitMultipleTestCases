package flyus_junit_multipe;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class TestFlyUsAllModules extends FlyUsAllModules{
	@Test
	public void testOneAdult1Child() throws IOException, InterruptedException, AWTException
	{
		Assert.assertEquals("testing OneAdult1Child()", 1,OneAdult1Child());
		
	}
}
