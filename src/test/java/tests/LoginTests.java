package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("natalia.kaminsky142857@gmail.com", "7Zhizney!");
        app.getHelperUser().submitLogin();
        //Assert if element with text *Logged in success* is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        app.getHelperUser().clickOkButton();
    }

}
