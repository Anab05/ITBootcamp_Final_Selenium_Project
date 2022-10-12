package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Auth_Routes_Test extends Basic_Test {
	@Test(priority=10)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
//		Ucitati /home stranu
//		Verifikovati da se u url-u stranice javlja ruta /login
		driver.get(baseUrl + "/home");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should ends with /login");
	
	}
	
	@Test(priority=20)
	public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
//		Ucitati /profile stranu
//		Verifikovati da se u url-u stranice javlja ruta /login
		driver.get(baseUrl + "/profile");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should ends with /login");
	}
	
	@Test(priority=30)
	public void  forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
//		Ucitati /admin/cities stranu
//		Verifikovati da se u url-u stranice javlja ruta /login
		driver.get(baseUrl + "/admin/cities");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should ends with /login");
	}
	
	@Test(priority=40)
	public void  forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
//		Ucitati /admin/users stranu
//		Verifikovati da se u url-u stranice javlja ruta /login
		driver.get(baseUrl + "/admin/users");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should ends with /login");
	}
}
