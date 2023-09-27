package TestNg;

import org.testng.annotations.*;


public class SampleTest {

	 @BeforeTest
	    public void beforeTest(){
	        System.out.println("From BeforeTest annotation in SampleTestngUsage class ..");
	    }

	    @BeforeSuite
	    public void beforeSuite(){
	        System.out.println("From BeforeSuite annotation in SampleTestngUsage class ..");
	    }
}
