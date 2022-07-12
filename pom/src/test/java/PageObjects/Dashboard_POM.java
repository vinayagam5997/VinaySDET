package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_POM {
@FindBy(xpath="//*[@id='task-list-group-panel-menu_holder']//following::tr[@class='odd']")
public static WebElement pendingLeave;
}
