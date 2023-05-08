package test;

import bases.Basepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Allpage;

public class Maintest extends Basepage {

    @Test(priority = 1, description = "Login with valid credentials")
    public void loginWithValid() throws InterruptedException {

        Allpage login = new Allpage(driver);
        driver.get(loginurl);
        Thread.sleep(1000);
        /*
        CredentialsPage cred = new CredentialsPage();
        String username = cred.usernameCred();
        String password = cred.passcred();

        login.usernameMethod(username);
        login.passwordMethod(password);
        login.loginMethod();
         */

        login.userNameMethod("standard_user");
        login.passwordMethod("secret_sauce");
        login.loginMethod();
        Thread.sleep(3000);
    }
    @Test(priority = 2, description = "Login with INvalid credentials")
    public void loginWithInvalid() throws InterruptedException{
        Allpage login1 = new Allpage(driver);
        driver.get(loginurl);
        Thread.sleep(1000);
        login1.userNameMethod("standard_user");
        login1.passwordMethod("ASD");
        login1.loginMethod();
        Thread.sleep(1500);
        String txtExpected="Epic sadface: Username and password do not match a";
        Assert.assertTrue(login1.ErrorMessageMethod().contains(txtExpected));
        Assert.assertEquals("Ridwan" , "Snigdha");
    }

    @Test(priority = 3, description = "Order Process")
    public void orderProcessTest() throws InterruptedException {
        Allpage login2 = new Allpage(driver);
        driver.get(loginurl);
        Thread.sleep(1000);
        login2.userNameMethod("standard_user");
        login2.passwordMethod("secret_sauce");
        login2.loginMethod();
        Thread.sleep(3000);
        login2.addToCartMethod();
        login2.addToCartIconMethod();
        Thread.sleep(3000);
        login2.checkOutMethod();
        Thread.sleep(2000);
        login2.firstNameMethod("RidwAn");
        login2.lastNameMethod("HasAN");
        login2.postalCodeMethod("1237557");
        login2.continueBttnMethod();
        Thread.sleep(2000);
        login2.finishBttnMethod();




    }
}
