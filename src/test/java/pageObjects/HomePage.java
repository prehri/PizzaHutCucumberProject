package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class HomePage  {
	public WebDriver ldriver;
	WebDriverWait wait;

	public HomePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	float previousCheckoutValue;
//	float f;
	
	By location=By.xpath("//input[@placeholder='Enter your location for delivery']");
	By selectdropdwn=By.xpath("//div[@class='flex flex-col']//button");
	By firstoptionbutton=By.xpath("//button[2]");
	By pagedeal=By.xpath("//a[@class='menu-link pb-10 capitalize text-white bold inline-block bg-red']");
    By buttonRadio=By.xpath("//div[contains(@class,'w-full bg-white border-t py-5 justify-end md:hidden lg:flex 2xl:hidden')]//input[contains(@name,'toggle-button-0')]");
    By menupizza=By.xpath("//a[@data-synth='link--pizzas--side']");
    By pizzabuttonany=By.xpath("//button[@data-synth='button--awesome-american-cheesy-recommended-pan-personal--one-tap']");
    By pizzasprice=By.xpath("//span[contains(@class,'subtotal')]");
    By chargeshandling=By.xpath("//div[@class='display-supplement-value']");
	By taxes=By.xpath("//span[contains(text(),'₹21.50')]");
	By dueamount=By.xpath("//span[@class='amountdue']");
	By itemtaxe=By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']");
	By textcheckout=By.xpath("//span[@data-synth='basket-value'][contains(text(),'₹451.50')]");
    By dueamounts=By.xpath("//span[@class='amountdue']");
	By drinkoptions=By.xpath("//a[contains(@data-synth,'link--drinks--side')]");
	//By drinkoptions=By.xpath("//a[@class='menu-link pb-10 capitalize text-white bold inline-block bg-red']//span[contains(text(),'Drinks')]");
	By drinkpepsi=By.xpath("//button[@data-synth='button--pepsi-600ml--one-tap']");
	By textitem=By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']");
	By amountduenew=By.xpath("//span[@class='ml-auto text-right']");
	By pizzaremove=By.xpath("//button[@data-synth='basket-item-remove--awesome-american-cheesy-recommended-pan-personal']");
    By tagprice=By.xpath("//span[@class='ml-auto text-right']");
    By oneitemcheckbox=By.xpath("//span[contains(@class,'mr-auto text-left')]");
    By buttoncheckboxone=By.xpath("//span[contains(text(),'Checkout')]");
    By checkboxbtn=By.xpath("//h3[@class='typography-2 mt-30']");
    
  //a[@data-synth='link--drinks--side']//span[contains(text(),'Drinks')]
    
    public void setLocation(String Location) {
		WebElement locationtxtfield = ldriver.findElement(location);
		// Assuming you have already found the WebElement you want to scroll to

		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", locationtxtfield);

		locationtxtfield.sendKeys(Location);
	}
    
    

   
	public void selectfirstItem() {

		wait = new WebDriverWait(ldriver, Duration.ofSeconds(50));
		WebElement autocomplete = wait.until(
				ExpectedConditions.visibilityOfElementLocated((selectdropdwn)));
	WebElement first_option = ldriver.findElement(firstoptionbutton);

		first_option.click();

	}

	public void dealspage() {
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement dealspage = ldriver
				.findElement(pagedeal);
		System.out.println(dealspage.getAttribute("href"));
		Assert.assertEquals(dealspage.getAttribute("href"), "https://www.pizzahut.co.in/order/deals/");

	}

	public void radiobuttonvalidation()
	{
		WebElement radiobutton = ldriver.findElement(buttonRadio);
		boolean isSelected = radiobutton.isSelected();

		// Print the value
		System.out.println("vegetarian radio button value: " + isSelected);
        Assert.assertFalse("Vegetarian radio button flag is off", isSelected);

	}


	public void pizzamenubar() {
		WebElement pizzaMenubarOption = ldriver.findElement(menupizza);
	    pizzaMenubarOption.click();

		}

	public void buttonanaypizza() {
		System.out.println("User select any pizza from recommendation");
		WebElement addtocart = ldriver.findElement(pizzabuttonany);
		addtocart.click();
		}


	public void pizzaaddedbasket() {

		WebElement basketElement = ldriver.findElement(By.id("basket"));
		// Check if the basket element is displayed
		boolean isPizzaAddedToBasket = basketElement.isDisplayed();
		// Validate that the pizza is added to the basket
		Assert.assertTrue("Pizza should be added to the basket", isPizzaAddedToBasket);



	}

	public void validatepizza_taxchecoutprice() {

		WebElement pizaprize = ldriver.findElement(pizzasprice);
		WebElement handlingcharges = ldriver.findElement(chargeshandling);
		WebElement tax = ldriver.findElement(taxes);
		WebElement amountdue = ldriver.findElement(dueamounts);


		Float fPizaprice = Float.parseFloat(pizaprize.getText().replaceAll("[₹]", ""));
		Float fHandlingCharges = Float.parseFloat(handlingcharges.getText().replaceAll("[₹]", ""));
		Float fTax = Float.parseFloat(tax.getText().replaceAll("[₹]", ""));
		Float fCheckoutprice = Float.parseFloat(amountdue.getText().replaceAll("₹", ""));



		Float totalPrice = fPizaprice + fHandlingCharges + fTax;
        System.out.println(totalPrice.toString());
        Assert.assertEquals(totalPrice, fCheckoutprice);


	}

	public void checkout_itemcount() {

		WebElement itemtext = ldriver.findElement(itemtaxe);
		System.out.println(itemtext.getText());
		Integer itemcount = Integer.parseInt(itemtext.getText().replaceAll("[item]", "").trim());
		System.out.println(itemcount.toString());
        Assert.assertTrue(itemcount >= 1);
	}

	public void checkoutbutton_totalprice() {
/*
		WebElement checkouttext = ldriver.findElement(textcheckout);
		Float pricecount = Float.parseFloat(checkouttext.getText().replaceAll("[₹]", ""));
		// System.out.println(pricecount.toString());

		WebElement amountdue = ldriver.findElement(dueamounts);
		float fCheckoutprice = Float.parseFloat(amountdue.getText().replaceAll("₹", ""));
       
		previousCheckoutValue = fCheckoutprice;
		System.out.println(previousCheckoutValue);

		Assert.assertEquals(pricecount, fCheckoutprice);
		*/
		
		 WebElement count=ldriver.findElement(By.xpath("//span[@data-synth='basket-value'][contains(text(),'₹451.50')]"));
		 String text=count.getText();
		 String r=text.replace('₹', ' ');
		 Float f=Float.parseFloat(r.trim());
		 System.out.println(f+" "+"is total price count");
	
		
		
	

	}
	public void drinkoption() {
		
		WebElement Drinks_option = ldriver.findElement(drinkoptions);
		

		Drinks_option.click();
		System.out.println("on drink page");

	}
	

	public void pepsioptionbasket() {

		WebElement select_Pepsi_option = ldriver.findElement(drinkpepsi);
		select_Pepsi_option.click();
	}

	public void twoitemcheckoutbttn() {
		WebElement itemtext = ldriver.findElement(textitem);
		System.out.println(itemtext.getText());
		Integer itemcount = Integer.parseInt(itemtext.getText().replaceAll("[items]", "").trim());
		System.out.println(itemcount.toString());

		Assert.assertTrue(itemcount >= 2);


	}


	public void totalpricemorethanbefore(){
		WebElement Newamountdue = ldriver.findElement(amountduenew);

		Float fnewCheckoutprice = Float.parseFloat(Newamountdue.getText().replaceAll("₹", ""));
		System.out.println(fnewCheckoutprice.toString());
		System.out.println("previousCheckoutValue = " + previousCheckoutValue);
        Assert.assertTrue(fnewCheckoutprice > previousCheckoutValue);


	}

	public void removefrombasket() {
		WebElement remove_pizza =ldriver.findElement(pizzaremove);
		remove_pizza.click();
		System.out.println("pizza item is removed");

	}

	public void removepricetagcheckoutbutn() {
		boolean pricetagflag;
		try {
			WebElement pricetag = ldriver.findElement(tagprice);
			System.out.println("price tag is visible");
			pricetagflag = true;
			Assert.assertTrue(pricetagflag);
		} catch (Throwable e) {
			pricetagflag = false;
			Assert.assertFalse(pricetagflag);
			System.out.println("price tag is not visible");
		}
	}

	public void chceckbtn_oneitem() {
		WebElement checkboxoneitem = ldriver.findElement(oneitemcheckbox);
		System.out.println(checkboxoneitem.getText());
	}


	public void checkboxbtn_clciksn() {

		WebElement checkboxonebtn = ldriver.findElement(buttoncheckboxone);
		checkboxonebtn.click();
	}

	public void popup_minimumorder() {
		WebElement checkboxonebtn = ldriver.findElement(checkboxbtn);
		boolean popupminimumorder = checkboxonebtn.isDisplayed();
		Assert.assertTrue("Pizza should be added to the basket", popupminimumorder);

	}

	
	
	

}
