package stepDefinations;

import pageObjects.HomePage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;


public class HomeStep {
	public WebDriver driver;
	public HomePage hp;
	WebDriverWait wait;


	@Before()
	public void launch_browser()  {
	   System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
	   driver=new ChromeDriver();
	   hp=new HomePage(driver);
	   driver.manage().window().maximize();

 
	}
	
	@After()
	public void tearDown()  {
	driver.close();
	}

	
	
	
	@Given("User launch Pizzahut application with (.*)$")
	public void user_launch_pizzahut_application_with_https_www_pizzahut_co_in(String URL) {
		System.out.println("on homepage pizzahut");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(URL);
	//	driver.get(URL);
	}
	
	
	
	@When("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() {

	}

	@Then("^User type address as(.*)$")
	public void user_type_address_as_pune_sasane_nagar_pizza_hut(String Location) {
		
		hp.setLocation(Location);
	}

	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() {
		
		hp.selectfirstItem();
	}

	@When("User navigate to deal page")
	public void User_navigate_to_deals_page() {
		hp. dealspage();

	
    }
	
	
	@Then("User validate vegetarian radio button flag is off")
	public void validate_vegetarian_radio_button_flag() {

		hp.radiobuttonvalidation();

			}

	@Then("User clicks on Pizzas menu bar option")
	public void clicks_on_Pizzas_menu_bar() {
		hp.pizzamenubar();
	}

	@When("User select add button of any pizza from Recommended")
	public void select_add_button_of_any_pizza() {
		hp.buttonanaypizza();
	}

	@Then("User see that the pizza is getting added under Your Basket")
	public void pizza_getting_added_under_Basket() {
		hp.pizzaaddedbasket();

	}

	@Then("User validate pizza price plus Tax is checkout price")
	public void validate_pizza_price_plus_Tax_checkout_price() {
		hp.validatepizza_taxchecoutprice();
	}

	@Then("User validate checkout button contains Item count")
	public void validate_checkout_button_contains_Itemcount() {
		hp.checkout_itemcount();


	}

	@Then("User validate checkout button contains total price count")
	public void validate_checkout_button_contains_total_price_count() {
		hp.checkoutbutton_totalprice();
	}
	

	@Then("User clicks on Drinks option")
	public void clicks_on_Drinks_option() {

		hp.drinkoption();
	}

	@Then("User select Pepsi option to add into the Basket")
	public void Pepsi_option_to_add_into_the_Basket() {
		hp.pepsioptionbasket();
	}

	@Then("User see 2 items are showing under checkout button")
	public void validate_2_items_checkout_button() {
		hp.twoitemcheckoutbttn();
	}

	@And("User see total price is now more than before")
	public void validate_Totalprice_morethan_before() {
		hp.totalpricemorethanbefore();


	}

	@Then("User remove the Pizza item from Basket")
	public void remove_pizza_frombasket() {
		hp.removefrombasket();

	}

	@And("User see Price tag got removed from the checkout button")
	public void Price_tag_got_removed_checkout() {

		hp.removepricetagcheckoutbutn();
	}

	@And("User see 1 item showing in checkout button")
	public void oneitem_checkboxbtn() {
		hp.chceckbtn_oneitem();
	}

	@Then("User Clicks on Checkout button")
	public void Clickson_checkboxbtn() {
		hp.checkboxbtn_clciksn();


	}

	@And("User see minimum order required pop up is getting displayed")
	public void minimum_order_popup() {
		hp.popup_minimumorder();
	}
  
	@Then("close browser")
	public void close_browser() {
	System.out.println("closing browser");
	}

	
	
	
	
	
	
	
	
	
}
