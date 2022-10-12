package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Admin_Cities_Test extends Basic_Test {
	@Test(priority=10)
	public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
//		Podaci: 
//			admin email: admin@admin.com
//			admin password: 12345
//			Koraci: 
//			Klik na sign up dugme iz navigacije
//			Prijaviti se na sistem admin kredencijalima
//			Klik na admin dugme iz navigacije
//			Klik na Cities dugme iz padajuceg Admin menija
//			Verifikovati da se u url-u stranice javlja /admin/cities ruta 
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLogInButton().click();
		
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/admin/cities"),
				"ERROR: Url should ends with /admin/cities");
	}
	
	@Test(priority=20)
	public void checksInputTypesForCreateEditNewCity() {
//		Klik na admin dugme iz navigacije
//		Klik na Cities dugme iz padajuceg Admin menija
//		Kliknuti na New Item dugme
//		Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//		Verifikovati da polje za unos grada za atribut type ima tekst text
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getNewItemBtn().click();
		
		citiesPage.waitForNewEditDialog();
		
		Assert.assertTrue(
				citiesPage.getInputFromNewItemDialog().getAttribute("type").equals("text"),
				"ERROR: Input type should be text");
	}
	
	@Test(priority=30)
	public void createNewCity() {
//		Podaci: 
//			city: [Ime i prezime polaznika]’s city
//			Koraci: 
//			Klik na admin dugme iz navigacije
//			Klik na Cities dugme iz padajuceg Admin menija
//			Kliknuti na New Item dugme
//			Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//			Uneti ime grada u polje
//			Kliknuti na Save dugme
//			Sacekati da popu za prikaz poruke bude vidljiv
//			Verifikovati da poruka sadrzi tekst Saved successfully
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getNewItemBtn().click();
		
		citiesPage.waitForNewEditDialog();
		
		citiesPage.getInputFromNewItemDialog().sendKeys("Ana Brankovic's city");
		citiesPage.getSaveNewDialogBtn().click();
		
		messagePopUpPage.waitForSavedSuccessfulyMsg();;
		
		Assert.assertTrue(
				messagePopUpPage.getSavedSuccessfulMsg().getText().contains("Saved successfully"),
				"ERROR: Wrong message.");
	}
	
	@Test(priority=40)
	public void editCity() throws InterruptedException {
//		Podaci: 
//			old city name: [Ime i prezime polaznika]’s city
//			new city name: [Ime i prezime polaznika]’s city Edited
//			Koraci: 
//			Klik na admin dugme iz navigacije
//			Klik na Cities dugme iz padajuceg Admin menija
//			U polje za pretragu uneti staro ime grada
//			Sacekati da broj redova u tabeli bude 1
//			Kliknuti na dugme Edit iz prvog reda
//			Uneti novo ime za grad
//			Kliknuti na dugme Save
//			Sacekati da popu za prikaz poruke bude vidljiv
//			Verifikovati da poruka sadrzi tekst Saved successfully
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Ana Brankovic's city");
		
		citiesPage.waitForNumbersOfCitiesToBe(1);
		citiesPage.getEditBtnFromRow(1).click();
		citiesPage.getInputFromNewItemDialog().sendKeys(" Edited");
		citiesPage.getSaveNewDialogBtn().click();
		messagePopUpPage.waitForSuccessfullSavedMsg();
		
		Assert.assertTrue(
				messagePopUpPage.getSavedSuccessfulMsg().getText().contains("Saved successfully"),
				"ERROR: Wrong message.");
		
		
	}
	
	@Test(priority=50)
	public void searchCity() {
//		Podaci: 
//			city name: [Ime i prezime polaznika]’s city Edited
//			Koraci: 
//			Klik na admin dugme iz navigacije
//			Klik na Cities dugme iz padajuceg Admin menija
//			U polje za pretragu uneti staro ime grada
//			Sacekati da broj redova u tabeli bude 1
//			Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Ana Brankovic's city");
		
		citiesPage.waitForNumbersOfCitiesToBe(1);
		Assert.assertTrue(
				 citiesPage.getCellFromRow(1, 2).getText().contains("Ana Brankovic's city"),
				 "ERROR: City name should contains - Ana Brankovic's city");
	}
	
	@Test(priority=60)
	public void deleteCity() {
//		Podaci: 
//			city name: [Ime i prezime polaznika]’s city Edited
//			Koraci: 
//			Klik na admin dugme iz navigacije
//			Klik na Cities dugme iz padajuceg Admin menija
//			U polje za pretragu uneti staro ime grada
//			Sacekati da broj redova u tabeli bude 1
//			Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//			Kliknuti na dugme Delete iz prvog reda
//			Sacekati da se dijalog za brisanje pojavi
//			Kliknuti na dugme Delete iz dijaloga
//			Sacekati da popu za prikaz poruke bude vidljiv
//			Verifikovati da poruka sadrzi tekst Deleted successfully
		navPage.getAdminButton().click();
		navPage.getAdminCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Ana Brankovic's city");
		
		citiesPage.waitForNumbersOfCitiesToBe(1);
		
		Assert.assertTrue(
				 citiesPage.getCellFromRow(1, 2).getText().contains("Ana Brankovic's city"),
				 "ERROR: City name should contains - Ana Brankovic's city");
		
		citiesPage.getDeleteBtnFromRow(1).click();
		citiesPage.waitForDeleteDialog();
		citiesPage.getDeleteDeleteDialogBtn().click();
		
		messagePopUpPage.waitForSuccessfullSavedMsg();
		
		Assert.assertTrue(
				messagePopUpPage.getSavedSuccessfulMsg().getText().contains("Deleted successfully"),
				"ERROR: Wrong message.");
		 
	}

}
