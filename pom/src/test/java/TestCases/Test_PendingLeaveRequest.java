package TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctions.functions;
import PageObjects.Dashboard_POM;
import PageObjects.Login;

public class Test_PendingLeaveRequest extends functions {
	Logger log=Logger.getLogger(Test_PendingLeaveRequest.class);
	private void loginD() {
		log.info("Navigating to the login page");
		PageFactory.initElements(driver,Login.class);
		log.info("valid username is given");
		Login.username.sendKeys(prop.getProperty("username"));
		log.info("valid password is given");
		Login.password.sendKeys(prop.getProperty("password"));
		Login.button.click();

	}
	private void leaverequest() {
		PageFactory.initElements(driver, Dashboard_POM.class);
		String message = Dashboard_POM.pendingLeave.getText();
		log.info("Getting the record data");
		Assert.assertEquals(message, "No Records are Available");
		log.info("end of the Test_PendingLeaveRequest testcase");


	}

@Test	
public void verifyRecords() {
		loginD(); 
		leaverequest();
	
}
}
