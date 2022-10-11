package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Test extends Basic_Test {
	
	@Test(priority=10)
	public void visitTheLoginPage() {
//		Postaviti EN jezik stranice
//		Klik na login dugme iz navigacije
//		Verifikovati da se u url-u stranice javlja ruta /login
		navPage.getChooseLanguageButton().click();
		navPage.getEngLang().click();
		navPage.getLoginButton().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should be contains /login.");
	}
	
	@Test(priority=20)
	public void checkInputTypes() {
//		Klik na login dugme iz navigacije
//		Verifikovati da polje za unos emaila za atribut type ima vrednost email
//		Verifikovati da polje za unos lozinke za atribut type ima vrednost password
		navPage.getLoginButton().click();
		Assert.assertEquals(
				loginPage.getEmailInput().getAttribute("type"), 
				"email",
				"ERROR: Input type should be email");
		
		Assert.assertEquals(
				loginPage.getPasswordInput().getAttribute("type"), 
				"password",
				"ERROR: Input type should be password");
	}
	
	@Test(priority=30)
	public void displaysErrorsWhenUserDoesNotexist() {
//		email: non-existing-user@gmal.com
//		password: password123
//		Koraci: 
//		Klik na login dugme iz navigacije
//		Popuniti login formu podacima za logovanje
//		Klik na login dugme
//		Sacekati da popu za prikaz greske bude vidljiv
//		Verifikovati da greska sadrzi poruku User does not exists
//		Verifikovati da se u url-u stranice javlja /login ruta 
		navPage.getLoginButton().click();
		
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLogInButton().click();
		
		messagePopUpPage.waitForPopUpToBeVisible();
		
		Assert.assertTrue(
				messagePopUpPage.getElementWithMessage()
				.getText()
				.equals("User does not exists"),
				"ERROR: Message should be User does not exist.");
		
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should be contains /login.");
			
	}
	
	@Test(priority=40)
	public void displaysErrorsWhenPasswordIsWrong() {
//		email: admin@admin.com
//		password: password123
//		Koraci: 
//		Klik na login dugme iz navigacije
//		Popuniti login formu podacima za logovanje
//		Klik na login dugme
//		Sacekati da popu za prikaz poruke bude vidljiv
//		Verifikovati da greska sadrzi poruku Wrong password
//		Verifikovati da se u url-u stranice javlja /login ruta 
		navPage.getLoginButton().click();
		
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLogInButton().click();
		
		messagePopUpPage.waitForPopUpToBeVisible();
		
		Assert.assertTrue(
				messagePopUpPage.getElementWithMessage()
				.getText()
				.equals("Wrong password"),
				"ERROR: Message should be Wrong password");
		
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should be contains /login.");
			
	}
	
	@Test(priority=50)
	public void  login() throws InterruptedException {
//		email: admin@admin.com
//		password: 12345
//		Koraci: 
//		Klik na login dugme iz navigacije
//		Popuniti login formu podacima za logovanje
//		Verifikovati da se u url-u stranice javlja /home ruta 
		navPage.getLoginButton().click();
		
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLogInButton().click();
		Thread.sleep(1000);
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/home"),
				"ERROR: Url should be contains /home.");
	}
	
	@Test(priority=60)
	public void logout() {
//		Verifikovati da je dugme logout vidljivo na stranici
//		Kliknuti na logout dugme
		Assert.assertTrue(
				navPage.getLogoutButton().isDisplayed(),
				"ERROR: Logout button is not displayed.");
		navPage.getLogoutButton().click();
		
		

	}
}
