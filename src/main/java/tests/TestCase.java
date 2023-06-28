package tests;


import common.TestBasic;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import Pages.HomePage;
import Pages.PageLogin;
public class TestCase {
    TestBasic testBase = new TestBasic();
    @Parameters("browser")
    @BeforeTest
    public void openWeb(String Browser) {
        testBase.openWebsite(Browser);
        PageLogin pageLogin = new PageLogin(testBase.driver);
        HomePage homePage = pageLogin.loginKV("Truyen","admin", "1");
    }
}
