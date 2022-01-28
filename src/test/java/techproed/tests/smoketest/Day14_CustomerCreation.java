package techproed.tests.smoketest;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.CreateCustomerPage;
import techproed.pages.EmployeeDefaultPage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day14_CustomerCreation {
    LoginPage loginPage;
    EmployeeDefaultPage employeeDefaultPage;
    CreateCustomerPage createCustomerPage;
    @Test
    public void createCustomerAsEmployee() throws IOException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
//        calling the loginApplication method to log in
        loginPage = new LoginPage();
        employeeDefaultPage = new EmployeeDefaultPage();
        createCustomerPage = new CreateCustomerPage();
        loginPage.loginApplication(ConfigurationReader.getProperty("employee_username"),ConfigurationReader.getProperty("employee_password"));
        employeeDefaultPage.myOperationsDropdown.click();
        employeeDefaultPage.manageCustomers.click();
        createCustomerPage.createANewCustomer.click();
        createCustomerPage.firstname.sendKeys("Testfirst");
        createCustomerPage.lastname.sendKeys("Testlast");
        createCustomerPage.middleInitial.sendKeys("T");
        createCustomerPage.email.sendKeys("test@gmail.com");
        createCustomerPage.mobilePhoneNumber.sendKeys("111-111-1111");
        createCustomerPage.phoneNumber.sendKeys("111-111-1111");
        createCustomerPage.zipCode.sendKeys("11111");
        createCustomerPage.address.sendKeys("Test Address 123");
        createCustomerPage.city.sendKeys("TestCity");
        createCustomerPage.ssn2.sendKeys("111-11-1111");
//        SELECTING ELEMENT FROM DROPDOWN USING SELECT OBJECT
//        WebElement countryDropdown = Driver.getDriver().findElement(By.id("tp-customer-country"));
//       Select select = new Select(countryDropdown);
//       select.selectByVisibleText("USA");

        Select country = new Select(createCustomerPage.countryDropdown);
        country.selectByVisibleText("USA");

        createCustomerPage.state.sendKeys("Texas");

        Select user = new Select(createCustomerPage.userDrop);
        user.selectByIndex(2);

        Select account = new Select(createCustomerPage.accountDropdown);
        account.selectByIndex(3);

        createCustomerPage.zelleEnrolledCheckbox.click();

        createCustomerPage.saveButton.click();

        ReusableMethods.getScreenshot("CustomerCreated");


    }
}