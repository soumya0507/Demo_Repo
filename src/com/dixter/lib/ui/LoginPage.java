package com.dixter.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void waitToPageLoad() {
		wait = new WebDriverWait(driver, 100);
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//nobr[text()='actiTIME 2019.2 Pro']"))));
	}

	public WebElement getUserTextBox() {
		try {
			WebElement elm = driver.findElement(By.name("username"));
			return elm;
		} catch (Exception e) {
			return null;

		}

	}

	public WebElement getPasswordTextBox() {

		try {
			WebElement elm = driver.findElement(By.name("pwd"));
			return elm;
		} catch (Exception e) {
			return null;

		}
	}

	public void loginButton() {
		driver.findElement(By.xpath("//div[text()='Login ']"));
	}

	public String getErrorMsg() {
		try {
			WebElement elm = driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']"));
		String textToVerify=	elm.getText();
			return textToVerify;
		} catch (Exception e) {
			return null;
		}

	}
}
