package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;
    private WebDriver driver;

    @Given("que estou na página de login do Swag Labs")
    public void queEstouNaPaginaDeLoginDoSwagLabs() {
        driver = BaseTest.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("eu insiro o usuário {string} e a senha {string}")
    public void euInsiroOUsuarioEASenha(String username, String password) {
        loginPage.fazerLogin(username, password);
    }

    @And("clico no botão de login")
    public void clicoNoBotaoDeLogin() {
        loginPage.clicarBotaoLogin();
    }

    @Then("devo ver a página de produtos")
    public void devoVerAPaginaDeProdutos() {
        assertTrue(loginPage.isPaginaDeProdutosExibida(), "A página de produtos não foi exibida.");
    }

    @Then("devo ver uma mensagem de erro")
    public void devoVerUmaMensagemDeErro() {
        assertTrue(loginPage.isMensagemErroExibida(), "A mensagem de erro não foi exibida.");
    }

    @After
    public void finalizarDriver() {
        BaseTest.quitDriver();
    }
}