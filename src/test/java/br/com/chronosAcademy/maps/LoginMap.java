package br.com.chronosAcademy.maps;

import com.github.dockerjava.core.exec.WaitContainerCmdExec;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUserLink" )
    public WebElement btnLogin;
    public WebElement btnFechar;
    @FindBy(xpath = "/html/body/login-modal/div/div/div[2]")
    public WebElement divFecharModal;
    public WebElement inpUserName;
    public WebElement inpPassword;
    public WebElement btnSignIn;
    public WebElement inpRemember;
    public WebElement linkCreateAccount;

}
