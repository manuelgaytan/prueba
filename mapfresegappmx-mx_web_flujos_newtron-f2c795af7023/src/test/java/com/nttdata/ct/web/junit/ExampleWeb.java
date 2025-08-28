package com.nttdata.ct.web.junit;

import com.nttdata.ct.web.actions.UIActions;
import com.nttdata.ct.web.evidence.ScreenShot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ExampleWeb extends BaseConfigTest{

    @Autowired
    private ScreenShot screenShot;
    @Autowired
    private UIActions actions;

    @Autowired
    private LoginPage login;

    @Test
    public void login() {
        actions.typeOn(login.userInput, "locked_out_user");
        screenShot.shotElementAsFile(login.userInput, "userInput");
//        actions.typeOn(login.passwordInput,"secret_sauce");
//        screenShot.shotElementAsFile(login.passwordInput, "passwordInput");
//        actions.clickOn(login.loginButton);
//        screenShot.shotElementAsFile(login.loginButton, "loginButton");
        screenShot.shotAsFile("full_evidence");
    }

}
