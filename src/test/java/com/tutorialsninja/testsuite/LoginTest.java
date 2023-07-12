package com.tutorialsninja.testsuite;

import com.tutorialsninja.basetest.BaseTest;
import com.tutorialsninja.pages.Homepage;
import com.tutorialsninja.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest
{
    Homepage homepage=new Homepage();
    MyAccountPage myAccountPage=new MyAccountPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Register");
        String expectedMessage="Register Account";
        Assert.assertEquals(myAccountPage.getRegisterAccountText(),expectedMessage," ");
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Login");
        String expectedMessage="Returning Customer";
        Assert.assertEquals(myAccountPage.getReturningCustomerText(),expectedMessage, " ");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Register");
        myAccountPage.enterFirstName();
        myAccountPage.enterLastName();
        myAccountPage.enterEmailId();
        myAccountPage.enterPassword();
        myAccountPage.enterConfirmPassword();
        myAccountPage.clickOnYesRadioButton();
        myAccountPage.clickOnPrivacyPolicyCheckBox();
        myAccountPage.clickOnContinueButton();
        Thread.sleep(2000);
        myAccountPage.selectMyAccountOptions("Logout");
        String expectedText="Account Logout";
        Assert.assertEquals(myAccountPage.getAccountLogoutText(),expectedText," ");
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully()
    {
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        myAccountPage.enterEmailId();
        myAccountPage.enterPassword();
        myAccountPage.clickOnLoginButton();
    }
}

