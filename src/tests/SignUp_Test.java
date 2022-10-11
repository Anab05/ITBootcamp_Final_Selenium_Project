package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp_Test extends Basic_Test {
	@Test(priority=10)
	public void visitsTheSignupPage() {
//		Klik na sign up dugme iz navigacije
//		Verifikovati da se u url-u stranice javlja /signup ruta 
		navPage.getSignUpButton().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/signup"),
				"ERROR: Url should be contains /signup.");
	}
	
	@Test(priority=20)
	public void checksInputTypes() {
//		Klik na sign up dugme iz navigacije
//		Verifikovati da polje za unos emaila za atribut type ima vrednost email
//		Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//		Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
		navPage.getSignUpButton().click();
		
		Assert.assertEquals(
				signUpPage.getEmailInput().getAttribute("type"), 
				"email",
				"ERROR: Input type should be email");
		
		Assert.assertEquals(
				signUpPage.getPasswordInput().getAttribute("type"), 
				"password",
				"ERROR: Input type should be password");
		
		Assert.assertEquals(
				signUpPage.getPasswordInput().getAttribute("type"), 
				"password",
				"ERROR: Input type should be password");
	}
	
	@Test(priority=30)
	public void displaysErrorsWhenUserAlreadyExists() {
//		Podaci: 
//			name: Another User
//			email: admin@admin.com
//			password: 12345
//			confirm password: 12345
//			Koraci: 
//			Klik na sign up dugme iz navigacije
//			Verifikovati da se u url-u stranice javlja /signup ruta 
//			Popuniti formu za registraciju podacima
//			Klik na sign up dugme
//			Sacekati da popu za prikaz poruke bude vidljiv
//			Verifikovati da greska sadrzi poruku E-mail already exists
//			Verifikovati da se u url-u stranice javlja /signup ruta
		navPage.getSignUpButton().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/signup"),
				"ERROR: Url should be contains /signup.");
		
		signUpPage.getNameInput().sendKeys("Another User");
		signUpPage.getEmailInput().sendKeys("admin@admin.com");
		signUpPage.getPasswordInput().sendKeys("12345");
		signUpPage.getConfirmPasswordInput().sendKeys("12345");
		signUpPage.getSignUpButton().click();
		
		messagePopUpPage.waitForPopUpToBeVisible();
		
		Assert.assertTrue(
				messagePopUpPage.getElementWithMessage()
				.getText()
				.equals("E-mail already exists"),
				"ERROR: Message should be E-mail already exists");
	}
	
	@Test(priority=40)
	public void signup() throws InterruptedException {
//		Podaci: 
//			name: Ime i prezime polaznika
//			email template: ime.prezime@itbootcamp.rs
//			password: 12345
//			confirm password: 12345
//			Koraci: 
//			Klik na sign up dugme iz navigacije
//			Popuniti formu podacima za registraciju
//			Klik na sign up dugme
//			Ucitati stranicu /home
//			Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
//			Kliknuti na Close dugme iz dijaloga
//			Kliknuti na logout
		navPage.getSignUpButton().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/signup"),
				"ERROR: Url should be contains /signup.");
		
		signUpPage.getNameInput().sendKeys("Ana Brankovic");
		signUpPage.getEmailInput().sendKeys("ana.brankovic@itbootcamp.rs");
		signUpPage.getPasswordInput().sendKeys("12345");
		signUpPage.getConfirmPasswordInput().sendKeys("12345");
		signUpPage.getSignUpButton().click();
		
		
		Assert.assertTrue(
				messagePopUpPage.getVerifyYourAccountMsg().getText().equals("IMPORTANT: Verify your account"),
				"ERROR: Wrong message.");
		
		messagePopUpPage.getCloseButton().click();
		navPage.getLogoutButton().click();

	}
}
