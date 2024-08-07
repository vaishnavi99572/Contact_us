package Steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contactus_steps {
	WebDriver driver;
	
	@Given("Open the browser, enter the sparsh hospital URL")
	public void open_the_browser_enter_the_sparsh_hospital_url() {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.sparshhospital.com/");
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	} 

	@Given("Clicks the contact us button")
	public void clicks_the_contact_us_button() {
		 driver.findElement(By.linkText("Contact Us")).click();
	    
	}

	@When("when user enters firstname, lastname ,phone, email and textbox")
	public void when_user_enters_firstname_lastname_phone_email_and_textbox() {
		  driver.findElement(By.id("contact_first_name")).sendKeys("Vaishnavi");
		   driver.findElement(By.id("contact_last_name")).sendKeys("Lakhore");
		   driver.findElement(By.id("contact_phone")).sendKeys("7828184869");
		   driver.findElement(By.id("contact_email")).sendKeys("vaishnavilakhore@gmail.com");
		
	}

	@When("Select Yashwantpur hospital from Hospital dropdown")
	public void select_yashwantpur_hospital_from_hospital_dropdown() {
		 Select ho= new Select(driver.findElement(By.cssSelector("select[name='contact_hospital']")));
		   
		   ho.selectByValue("SPARSH Hospital, Yeswanthpur");
		   
		   Select in = new Select(driver.findElement(By.cssSelector("select[name='contact_enquiry_type']")));
		   
		   in.selectByValue("Appointment Related");
		   
	}

	@When("Write a message and click on send button")
	public void write_a_message_and_click_on_send_button() {
		driver.findElement(By.id("contact_message")).sendKeys("Hello, i am from Maharashtra");
		
		
		driver.findElement(By.cssSelector("button[id=\"contact_submit\"]")).click();
		
		//driver.navigate().refresh();
		
		
	   
	}

	@Then("Thankyou message should be displayed")
	public void thankyou_message_should_be_displayed() {
		
		String actual = driver.findElement(By.xpath("//h1[@class='font-700 mb-4']")).getText();
	     
		String expec = "Thank you";
		
		org.junit.Assert.assertEquals(expec, actual);
	
		
		
	}

	@Then("bank info available in the page")
	public void bank_info_available_in_the_page() {
		String actualbank = driver.findElement(By.cssSelector("class=\"text-blue font-700 border-bottom-blue mb-4 text-center\"")).getText();
		String expString = "Make UPI Payment:";
		
		org.junit.Assert.assertEquals(expString, actualbank);
		driver.close();
	   
	}
	// the following method for scenario outline
	@When("when user enters {string}, {string} ,{string}, {string} and textbox")
	public void when_user_enters_and_textbox(String firstname, String lastname, String phone, String email) {
		 driver.findElement(By.id("contact_first_name")).sendKeys(firstname);
		   driver.findElement(By.id("contact_last_name")).sendKeys(lastname);
		   driver.findElement(By.id("contact_phone")).sendKeys(phone);
		   driver.findElement(By.id("contact_email")).sendKeys(email);
	    
	}
}

