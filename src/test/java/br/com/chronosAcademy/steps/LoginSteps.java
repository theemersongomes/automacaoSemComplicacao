package br.com.chronosAcademy.steps;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.enums.Browser;
import br.com.chronosAcademy.pages.LoginPage;
import br.com.chronosAcademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {

    LoginPage loginPage;
    String userName;

    @Before
    public void iniciaNavegador(Scenario cenario) {
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario) {
        Driver.getDriver().quit();
        System.out.println(Driver.getNomeCenario()+" - "+cenario.getStatus());
        System.out.println(cenario.isFailed());
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://advantageonlineshopping.com");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();
    }

    @Quando("for realizado um clique fora da modal")
    public void forRealizadoUmCliqueForaDaModal() {
        loginPage.clickDivFecharModal();
    }

    @Quando("for realizado um clique no icone de fechar")
    public void forRealizadoUmCliqueNoIconeDeFechar() {
        loginPage.clickBtnFechar();
    }

    @Quando("for realizado um clique no link Create New Account")
    public void forRealizadoUmCliqueNoLinkCreateNewAccount() {
        loginPage.clickLinkCreateAccount();
    }

    @Entao("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        } catch (Exception e) {
            throw new Exception("A janela modal nao foi fechada");
        }

    }

    @Entao("a pagina Create new Account deve ser exibida")
    public void aPaginaCreateNewAccountDeveSerExibida() {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
    }

    @Quando("os campos de login forem preenchidos da seguinte forma")
    public void osCamposDeLoginForemPreenchidosDaSeguinteForma(Map<String, String> map) {
        userName = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));
        if (userName != null) {
            loginPage.setInpUserName(userName);
        }
        if (password != null) {
            loginPage.setInpPassword(password);
        }
        loginPage.aguardaLoader();
        if (remember) loginPage.clickInpRemember();
    }

    @Quando("for realizado um clique no botao sign in")
    public void forRealizadoUmCliqueNoBotaoSignIn() {
        loginPage.clickBtnSignIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() {
        Assert.assertEquals(userName, loginPage.getUsuarioLogado());
    }

    @Entao("o sistema deve exibir uma mensagem de erro")
    public void oSistemaDeveExibirUmaMensagemDeErro() {
        Assert.assertEquals("Incorrect user name or password.", loginPage.getErroLogin());

    }

    @Entao("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);
    }
}
