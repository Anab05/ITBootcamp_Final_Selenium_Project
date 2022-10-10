package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getHomeLink() {
		return driver.findElement(By.className("btnHome"));
	}
	public WebElement getAboutLink() {
		return driver.findElement(By.className("btnAbout"));
	}
	public WebElement getMyProfileLink() {
		return driver.findElement(By.className("btnProfile"));
	}
	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}
	public WebElement getAdminCitiesLink() {
		return driver.findElement(By.className("btnAdminCities"));
	}
	public WebElement getAdminUsersLink() {
		return driver.findElement(By.className("btnAdminUsers"));
	}
	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')][2]"));
	}
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')][1]"));
	}
	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}
	public WebElement getChooseLanguageButton() {
		return driver.findElement(By.className("btnLocaleActivation"));
	}
	public WebElement getEngLang() {
		return driver.findElement(By.className("btnEN"));
	}
	public WebElement getEspLang() {
		return driver.findElement(By.className("btnES"));
	}
	public WebElement getFreLang() {
		return driver.findElement(By.className("btnFR"));
	}
	public WebElement getChinLang() {
		return driver.findElement(By.className("btnCN"));
	}
	public WebElement getHeaderFromWelcomePage() {
		return driver.findElement(By.className("display-2"));
	}
}
