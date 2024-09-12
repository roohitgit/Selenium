package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuAppPageObject {

	WebDriver driver;

	public HerokuAppPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "A/B Testing")
	private WebElement abTesting;

	// @FindBy(xpath = "//h3[normalize-space()='A/B Test Control']")
	@FindBy(xpath = "//h3[contains(text(), 'A/B')]")
	private WebElement abTestingControl;

	@FindBy(css = "a[href='/add_remove_elements/']")
	private WebElement addRemoveElements;

	@FindBy(css = "button[onclick='addElement()']")
	private WebElement addElementBtn;

	@FindBy(css = ".added-manually")
	private WebElement deleteBtn;

	@FindBy(xpath = "//*[text()='Basic Auth']")
	private WebElement basicAuth;
	
	@FindBy(css = "a[href='/broken_images']")
	private WebElement brokenImages;
	
	@FindBy(xpath = "//a[normalize-space()='Checkboxes']")
	private WebElement checkBoxes;
	
	@FindBy(css = "a[href='/drag_and_drop']")
	private WebElement dragAndDrop;
	
	@FindBy(xpath = "//header[normalize-space()='A']")
	public WebElement source;
	
	@FindBy(xpath = "//header[normalize-space()='B']")
	public WebElement target;
	
	@FindBy(xpath = "//a[normalize-space()='Dropdown']")
	public WebElement dropDown;
	
	@FindBy(id = "dropdown")
	public WebElement dropDownList;
	
	@FindBy(css = "a[href='/entry_ad']")
	public WebElement entryAd;
	
	@FindBy(css = "#restart-ad")
	public WebElement restartAd;
	
	@FindBy(xpath = "//p[normalize-space()='Close']")
	public WebElement entryAdModalClose;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickOnABTesting() {
		abTesting.click();
	}

	public String getTextAfterABTestingClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(abTestingControl));

		return abTestingControl.getText();
	}

	public void clickOnAddRemoveElements() {
		addRemoveElements.click();
	}

	public void clickOnAddElementBtn(int num) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(addElementBtn));

		for (int i = 1; i <= num; i++) {
			addElementBtn.click();
		}
	}

	public void clickOnDeleteBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		deleteBtn.click();
	}

	public int checkNoOfDeleteButtons() {
		WebElement ele = driver.findElement(By.xpath("//div[@id='elements']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		return ele.findElements(By.tagName("button")).size();

	}
	
	public void clickOnBasicAuth()
	{
		basicAuth.click();
	}
	
	public void clickOnBrokenImages()
	{
		brokenImages.click();
	}
	
	public void clickOnCheckBoxes()
	{
		checkBoxes.click();
	}
	
	public List<WebElement> checkCheckBoxes()
	{
		return driver.findElements((By.xpath("//input[@type='checkbox']")));
	}
	
	public void clickOnDragAndDrop()
	{
		dragAndDrop.click();
	}
	
	public void clickOnDropDown()
	{
		dropDown.click();
	}
	
	public void clickOnDropDownList()
	{
		dropDownList.click();
	}
	
	public void clickOnEntryAd()
	{
		entryAd.click();
	}
	
	public void clickOnRestartEntryAd()
	{
		restartAd.click();
	}
	
	public void clickOnCloseEntryModalWindow()
	{
		entryAdModalClose.click();
	}

}
