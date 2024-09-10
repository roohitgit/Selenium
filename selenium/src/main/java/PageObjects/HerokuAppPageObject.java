package PageObjects;

import java.time.Duration;
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

}
