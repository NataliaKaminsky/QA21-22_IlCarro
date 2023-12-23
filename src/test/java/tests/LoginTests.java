package tests;

import manager.ApplicationManager;
import models.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        //if sign out present --->log out
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }


    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("natalia.kaminsky142857@gmail.com", "7Zhizney!");
        app.getHelperUser().submitLogin();
        //Assert if element with text *Logged in success* is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
    }
    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("natalia.kaminsky142857@gmail.com").setPassword("7Zhizney!");
//        user.setEmail("natalia.kaminsky142857@gmail.com");
//        user.setPassword("7Zhizney!");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm1(user);
        app.getHelperUser().submitLogin();
        //Assert if element with text *Logged in success* is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("natalia.kaminsky142857@gmail.com", "7Zhizney!");
        app.getHelperUser().submitLogin();
        //Assert if element with text *Logged in success* is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("natalia.kaminsky142857gmail.com", "7Zhizney!");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());


    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("natalia.kaminsky142857@gmail.com", "7Zhizney");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginUnregisteredUser() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("nataliakaminsky142857@gmail.com", "7Zhizney!");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }


    @AfterMethod
    public void postconditions() {
        app.getHelperUser().clickOkButton();

    }

}
