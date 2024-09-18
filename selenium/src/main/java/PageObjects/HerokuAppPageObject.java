package PageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;

public class HerokuAppPageObject {

	WebDriver driver;

	public HerokuAppPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "A/B Testing")
	private WebElement abTesting;

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
	private WebElement dropDown;
	
	@FindBy(id = "dropdown")
	public WebElement dropDownList;
	
	@FindBy(css = "a[href='/entry_ad']")
	private WebElement entryAd;
	
	@FindBy(css = "#restart-ad")
	private WebElement restartAd;
	
	@FindBy(xpath = "//p[normalize-space()='Close']")
	private WebElement entryAdModalClose;
	
	@FindBy(css = "a[href='/floating_menu']")
	private WebElement floatingMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Geolocation']")
	private WebElement geolocation;
	
	@FindBy(css = "button[onclick='getLocation()']")
	private WebElement whereAmIBtn;
	
	@FindBy(id = "lat-value")
	private WebElement latitude;
	
	@FindBy(id = "long-value")
	private WebElement longitude;
	
	@FindBy(css = "a[href='/horizontal_slider']")
	private WebElement horizontalSlider;
	
	@FindBy(xpath = "//input[@type='range']")
	public WebElement slider;
	
	@FindBy(css = "a[href='/nested_frames']")
	private WebElement nestedFrames;
	
	@FindBy(xpath = "//a[normalize-space()='Multiple Windows']")
	private WebElement multipleWindows;
	
	@FindBy(xpath = "//a[normalize-space()='Click Here']")
	private WebElement windowClickHere;
	
	@FindBy(xpath = "//a[normalize-space()='Key Presses']")
	private WebElement keyPress;
	
	@FindBy(xpath = "//input[@id='target']")
	private WebElement keyPressField;
	
	@FindBy(xpath = "//p[@id='result']")
	private WebElement keyPressResult;
	
	@FindBy(xpath = "//a[normalize-space()='JavaScript onload event error']")
	private WebElement javaScriptError;
	
	@FindBy(xpath = "//a[normalize-space()='JavaScript Alerts']")
	private WebElement javaScriptAlerts;
	
	@FindBy(css = "button[onclick='jsAlert()']")
	private WebElement JSAlertBtn;
	
	@FindBy(css = "button[onclick='jsConfirm()']")
	private WebElement JSConfirmBtn;
	
	@FindBy(css = "button[onclick='jsPrompt()']")
	private WebElement JSPromptBtn;
	
	@FindBy(xpath = "//p[@id='result']")
	private WebElement JSAlertResult;
	
	@FindBy(css = "a[href='/jqueryui/menu']")
	private WebElement JQueryUIMenus;
	
	@FindBy(css = "a[href='/inputs']")
	private WebElement inputs;
	
	@FindBy(css = "input[type='number']")
	public WebElement inputsNumbers;
	
	@FindBy(css = "a[href='/infinite_scroll']")
	private WebElement infiniteScroll;
	
	@FindBy(css = "a[href='/hovers']")
	private WebElement hovers;
	
	@FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
	public WebElement hoversimg1;
	
	@FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
	public WebElement hoversimg2;
	
	@FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
	public WebElement hoversimg3;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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
	
	public void clickOnFloatingMenu()
	{
		floatingMenu.click();
	}
	
	public void clickOnGeoLocation()
	{
		geolocation.click();
	}
	
	public void clickOnWhereAmI()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(whereAmIBtn)).click();
		
	}

	public String getLatitude()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(latitude));
		return latitude.getText();
	}
	
	public String getLongitude()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(longitude));
		return longitude.getText();
	}
	
	public void clickOnHorizontalSlider()
	{
		horizontalSlider.click();
	}
	
	public void setHorizontalSliderValue(int n)
	{
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider,n,0).build().perform();
	}
	
	public void clickOnNestedFrames()
	{
		nestedFrames.click();
	}
	
	public void clickOnMultipleWindows()
	{
		multipleWindows.click();
	}
	
	public void clickOnWindowClickHere()
	{
		windowClickHere.click();
	}
	
	public void clickOnKeyPresses()
	{
		keyPress.click();
	}
	
	public String keyPressField(Keys button)
	{
		keyPressField.sendKeys(button);
		return keyPressResult.getText();
		
	}
	
	public String keyPressField(String button)
	{
		keyPressField.sendKeys(button);
		return keyPressResult.getText();
		
	}
	
	public void clickOnJavaScriptError()
	{
		keyPress.click();
	}
	
	public void clickOnJavaScriptAlerts()
	{
		javaScriptAlerts.click();
	}
	
	public void clickOnJSAlertBtn()
	{
		JSAlertBtn.click();
	}
	
	public void clickOnJSConfirmBtn()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(JSConfirmBtn));
		JSConfirmBtn.click();
	}
	
	public void clickOnJSPromptBtn()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(JSPromptBtn));
		JSPromptBtn.click();
	}
	
	public String getJSAlertsResult()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(JSAlertResult));
		return JSAlertResult.getText();
	}
	
	public void clickOnJQueryUIMenus()
	{
		JQueryUIMenus.click();
	}
	
	public void clickOnInputs()
	{
		inputs.click();
	}
	
	public String getinputNumber()
	{
		return inputsNumbers.getAttribute("value");
	}
	
	public void clickOnInfiniteScroll()
	{
		infiniteScroll.click();
	}
	
	public void clickOnhovers()
	{
		hovers.click();
	}
	
	
	

	
	
	
	
	
	
}
