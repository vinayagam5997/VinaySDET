package TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctions.functions;
import PageObjects.UserRole_POM;

public class Test_UserRole extends functions {

Logger log = Logger.getLogger(Test_UserRole.class);
public void actionsUser() {
	log.warn("when performing the mouseover action don't move your mouse");
	Actions acc = new Actions(driver);
	log.info("navigating to admin tab");
	acc.moveToElement(UserRole_POM.admin);
	log.info("moving to the Usermanagement");
	acc.moveToElement(UserRole_POM.usermanage);
	log.info("clicking on the users");
	acc.moveToElement(UserRole_POM.users);
	acc.click().perform();
	

}
public void selectUserRole() {
	
	Select s = new Select(UserRole_POM.userRole);
	s.selectByIndex(1);

}
public void selectUserStatus() {
	
	Select s = new Select(UserRole_POM.status);
	s.selectByIndex(1);

}
@Test
public void userInfo() {
	PageFactory.initElements(driver, UserRole_POM.class);
	actionsUser();
	selectUserRole();
	log.info("selecting the status of user");
	selectUserStatus();
	log.info("Clicking on the search button");
	UserRole_POM.searchButton.click();
	String actualROle = UserRole_POM.userRoleTable.getText();
	log.info("verifying the admin");
	Assert.assertEquals(actualROle, "Admin");
	String actualStatus = UserRole_POM.userStatusTable.getText();
	log.info("verifying the status");
	Assert.assertEquals(actualStatus, "Enabled");
	log.info("Test_UserRole testcase is done");

}
}
