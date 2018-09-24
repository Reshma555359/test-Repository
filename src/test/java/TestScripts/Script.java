package TestScripts;

import org.testng.annotations.Test;
import CommonLibrary.TestBase;
public class Script extends TestBase {

	
	@Test
	public void testingListener(){
		//selectBrowser("browser");
		System.out.println(driver.getTitle());
	}
	
}
