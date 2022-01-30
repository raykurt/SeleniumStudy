package techproed.tests.excelautomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.EmployeeDefaultPage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day15_LoginTest {
    /*
     * We will get the credentials from excel sheet
     * We will send multiple credentials from excel
     * */
//    Create excel util object
    ExcelUtil excelUtil;

    //    Create a List of Map of String to store the username-password list
    List<Map<String,String>> testData;
    //    {{user1,pass1}, {user2,pass2},{user3,pass3},...}
    LoginPage loginPage;
    EmployeeDefaultPage employeeDefaultPage;
    public void logIn() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        loginPage=new LoginPage();
        employeeDefaultPage=new EmployeeDefaultPage();
        ReusableMethods.waitFor(1);
        loginPage.loginDropdown.click();
        ReusableMethods.waitFor(1);;
        try{
            loginPage.signOut.click();
            ReusableMethods.waitFor(1);
            loginPage.loginDropdown.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
//            System.out.println("Sign out link is not exist");
        }
        loginPage.signInButton.click();
//        loginPage.username.sendKeys(ConfigurationReader.getProperty("employee_username"));
//        loginPage.password.sendKeys(ConfigurationReader.getProperty("employee_password"));
//        loginPage.loginButton.click();
    }

    @Test
    public void employeeLoginTest() throws InterruptedException, IOException {
//        path of the excel sheet
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//        sheet name on the excel sheet
        String sheetName="employee_login_info";
//        Create the class object
        excelUtil = new ExcelUtil(path,sheetName);
//        Get the data using any proper excel util method
//        getDataList() => return the data list as List of Map of String
//        System.out.println(excelUtil.getDataList());
        testData=excelUtil.getDataList();
//        System.out.println(testData);//Testing if username password list accessable
        for (Map<String,String> eachData :testData){
//            System.out.println(eachData);
            logIn();
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            Asserting if log in is successful using My Operation element
            Assert.assertTrue(employeeDefaultPage.myOperationsDropdown.isDisplayed());
            ReusableMethods.getScreenshot("LoginSuccess");
        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}