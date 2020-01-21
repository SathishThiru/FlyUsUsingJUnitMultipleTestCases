package flyus_junit_multipe;

import org.junit.Assert;
import org.junit.Test;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({OneWay.class})
public class TestRunnerClass
{
	
		@Test
		public void testOneW1AE() throws Throwable
		{
			
			Assert.assertEquals(1, OneWay.oneW1AE());
		}
		
		@Test
		public void testOneW1A1CE() throws Throwable
		{
			Assert.assertEquals(2, OneWay.oneW1A1CE());

		}
	
	@Test
	public void testOneW1A1C1ICE()throws Throwable
	{
		Assert.assertEquals(3, OneWay.oneW1A1C1IE());
	}
	
	@Test
	public void testOneW2A1C1IE()throws Throwable
	{
		Assert.assertEquals(3, OneWay.oneW2A1C1IE());
	}
	
	@Test
	public void testOneW2A2C1IE()throws Throwable
	{
		Assert.assertEquals(5, OneWay.oneW2A2C1IE());
	}
	
}
