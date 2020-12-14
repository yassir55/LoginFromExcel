package com.api.cucumber.stepdfn;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.api.cucumber.pagefactory.LoginPage_PF;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDfn {

	WebDriver driver = null;
	LoginPage_PF login;

	@Given("^User is at the login page of the application$")
	public void user_is_at_the_login_page_of_the_application() throws Throwable {
		System.out.println("===============I am inside RegisterSteps class ========= ");

		// declaration and instantiation of objects/variables
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		String url="https://opensource-demo.orangehrmlive.com/";
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	
	@When("^User login with the following username and password with data in excel at \"([^\"]*)\"$")
	public void user_login_with_the_following_username_and_password_with_data_in_excel_at(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		login = new LoginPage_PF(driver);

		List<String> dataList = table.asList(String.class);

		for(String str : dataList){
			if( dataList.indexOf(str) > 1  ) {
				if(dataList.indexOf(str)%2==0)
					login.enterEmail(str);
				else
					login.enterPassword(str);
			}
			login.clilckOnConection();
			Thread.sleep(2000);
		}



	}
}
