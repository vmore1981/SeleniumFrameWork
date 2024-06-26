package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class page {

	@FindBy (xpath = "//button[@id='tabButton']")
	public WebElement tabBtn;

	@FindBy (id = "sampleHeading")
	public WebElement tabText;
	
	public page() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
}
