package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        //if sign out present --->log out
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }


    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("natalia.kaminsky142857@gmail.com", "7Zhizney!");
        app.getHelperUser().submitLogin();
        //Assert if element with text *Logged in success* is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("natalia.kaminsky142857@gmail.com", "7Zhizney!");
        app.getHelperUser().submitLogin();
        //Assert if element with text *Logged in success* is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOkButton();
    }

    @AfterMethod
    public void postconditions(){
        app.getHelperUser().clickOkButton();

    }

}
