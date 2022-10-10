package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitForPopUpToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
	}
	public void waitForSavedSuccessfulyMsg() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Saved successfully ']")));
	}
	public WebElement getElementWithMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'error')]//ul/li"));
	}
	public WebElement getSavedSuccessfulMsg() {
		return driver.findElement(By.className("success"));
	}
	public void waitForSuccessfullSavedMsg() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
	}
	public WebElement getCloseButton() {
		return driver.findElement(By.xpath("//*[text()='Close']/.."));
	}
	public void waitForVerifyYourAccountDialogToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'grey')]/..")));
	}
	public WebElement getVerifyYourAccountMsg () {
		return driver.findElement(By.xpath("//*[text()=' IMPORTANT: Verify your account ']"));
	}
	public WebElement getCloseMsgBtn() {
		return driver.findElement(By.className("btnClose"));
	}
}
