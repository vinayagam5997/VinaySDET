package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonFunctions.functions;

public class UserRole_POM{
	
@FindBy(linkText="Admin")
public static WebElement admin;
@FindBy(linkText="User Management")
public static WebElement usermanage;
@FindBy(linkText="Users")
public static WebElement users;
@FindBy(id="searchSystemUser_userName")
public static WebElement systemUserName;
@FindBy(id="searchSystemUser_userType")
public static WebElement userRole;
@FindBy(id="searchSystemUser_status")
public static WebElement status;
@FindBy(id="searchBtn")
public static WebElement searchButton;
@FindBy(xpath="//tr/td[3]")
public static WebElement userRoleTable;
@FindBy(xpath="//tr/td[5]")
public static WebElement userStatusTable;
}
