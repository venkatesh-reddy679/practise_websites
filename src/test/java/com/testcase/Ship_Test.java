package com.testcase;

import org.testng.annotations.Test;

import com.baseclass.WrapperClass;
import com.pages.Ship_Page;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Ship_Test extends WrapperClass {

	
	Ship_Page searchShip;
	

	@Test
	public void f() throws InterruptedException {
		searchShip = new Ship_Page(driver);
		Thread.sleep(3000);
		searchShip.check_link();
		searchShip.shipClick();
		Thread.sleep(3000);
		searchShip.rhapsodyOfShips();
		Thread.sleep(5000);
		searchShip.select_Deck(8);
		Thread.sleep(3000);
		searchShip.check_Suite("Royal Suite - 1 Bedroom");
		Thread.sleep(3000);
		searchShip.result();
		

	}

	@BeforeClass
	public void beforeClass() {
		launchApplication("chrome", "https://www.royalcaribbean.com/alaska-cruises");
		
	}

	@AfterClass
	public void afterClass() {
		quit();
	}

}
