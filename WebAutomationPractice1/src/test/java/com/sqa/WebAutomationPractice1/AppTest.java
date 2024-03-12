package com.sqa.WebAutomationPractice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AppTest extends BaseDriver{

	@Test
	public void navigateBrowser() throws InterruptedException {

		driver.manage().window().maximize();

		// A Navigate to the website. https://magento.softwaretestingboard.com/
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);



		// B Log in to the website.
		WebElement signInButton = driver.findElement(By.linkText("Sign In"));
		signInButton.click(); Thread.sleep(3000);

		WebElement signInEmailField = driver.findElement(By.id("email"));
		signInEmailField.sendKeys("testbymamun1113@gmail.com"); Thread.sleep(3000);

		WebElement signInPassField = driver.findElement(By.id("pass"));
		signInPassField.sendKeys("azDC1278"); Thread.sleep(3000);

		WebElement sendButton = driver.findElement(By.id("send2"));
		sendButton.click(); Thread.sleep(3000);



		// C Add a product to the cart.
		WebElement productView = driver.findElement(By.xpath("//div[@class='products-grid grid']/ol[1]/li[4]"));
		productView.click();
		Thread.sleep(3000);

		WebElement sizeOption = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")); 
		sizeOption.click();
		Thread.sleep(3000);

		WebElement colorOption = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]"));
		colorOption.click();
		Thread.sleep(3000);

		WebElement addtocartButton = driver.findElement(By.id("product-addtocart-button"));
		addtocartButton.click();
		Thread.sleep(5000);



		// D Verify if the product is successfully added to the cart.
		WebElement prmptMsg = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
		String promptMessage = prmptMsg.getText();
		Thread.sleep(3000);

		WebElement productName = driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[2]/div[1]/h1[1]"));
		String toValidate = "You added " + productName.getText() + " to your shopping cart.";
		Thread.sleep(3000);

		if(promptMessage.equals(toValidate))
		{
			System.out.println("\nProduct added to cart successfully.\n" + toValidate + "\n");
		}
		else
		{
			System.out.println("Something went wrong!");
		}	
	}
}
