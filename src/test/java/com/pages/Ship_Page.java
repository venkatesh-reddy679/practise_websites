package com.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;

public class Ship_Page {
	public Boolean royal = false;
	public Boolean whale = false;
	WebDriver driver;

	public Ship_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id=\"rciHeaderMenuItem-1\"]")
	WebElement cruise;
	@FindBy(xpath = "//*[@id=\'rciHeaderMenuItem-2\']")
	WebElement ships;
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div[6]/div/section/div/div[16]")
	WebElement rhapsodyOfShips;
	@FindBy(xpath = "//*[@id='superHero-1073688544']/div[4]/div/div/div/div/div[3]/a")
	WebElement deckPlan;

	@FindBy(className = "deck-dropdown")
	WebElement deckDropDown;

	public void shipClick() throws InterruptedException {
		Thread.sleep(5000);
		cruise.click();
		Thread.sleep(2000);
		ships.click();
		Thread.sleep(3000);
	}

	public void check_link() {
		List<WebElement> links = driver.findElements(By.linkText("Whale Watching"));
		if (links.size() > 0) {
			whale = true;
		}
	}

	public void rhapsodyOfShips() {
		rhapsodyOfShips.click();
	}

	public void select_Deck(int deckNo) throws InterruptedException {
		deckPlan.click();
		Thread.sleep(2000);

		Select deck = new Select(deckDropDown);
		Actions action = new Actions(driver);
		for (int i = 0; i <= deckNo - 3; i++) {
			deckDropDown.click();
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		Thread.sleep(5000);
	}

	public void check_Suite(String check_suite) {

		List<WebElement> Suite = driver.findElements(By.className("deck-plan__stateroom__subtype__name"));
		for (WebElement check : Suite) {
			String suite_Name = check.getText();
			if (suite_Name.equalsIgnoreCase(check_suite)) {
				royal = true;
			}
		}

	}

	public void result() {
		 assertFalse(whale, "does not meet my requirement");
		 System.out.println("whale is not present");
		 assertTrue(royal,  "does not meet my requirement");
		 System.out.println("royal is present");
		
	
	}

}