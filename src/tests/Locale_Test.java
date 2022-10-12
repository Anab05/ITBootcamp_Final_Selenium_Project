package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Locale_Test extends Basic_Test {
	@Test(priority=10)
	public void setLocaleToESP() {
//		Postaviti jezik na ES
//		Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje
		navPage.getChooseLanguageButton().click();
		navPage.getEspLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Página de aterrizaje"),
				"ERROR: Heder should be - Página de aterrizaje");
	}
	
	@Test(priority=20)
	public void setLocaleToENG() {
//		Postaviti jezik na EN
//		Verifikovati da se na stranici u hederu javlja tekst Landing
		navPage.getChooseLanguageButton().click();
		navPage.getEngLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Landing"),
				"ERROR: Heder should be - Landing");
	}
	
	@Test(priority=30)
	public void setLocaleToCN() {
//		Postaviti jezik na CN
//		Verifikovati da se na stranici u hederu javlja tekst 首页
		navPage.getChooseLanguageButton().click();
		navPage.getChinLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("首页"),
				"ERROR: Heder should be - 首页");
	}
	
	@Test(priority=40)
	public void setLocaleToFR() {
//		Postaviti jezik na FR
//		Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage
		navPage.getChooseLanguageButton().click();
		navPage.getFreLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Page d'atterrissage"),
				"ERROR: Heder should be - Page d'atterrissage");
	}
}
