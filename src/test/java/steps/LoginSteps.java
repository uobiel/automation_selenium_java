package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;
    private WebDriver driver = BaseTest.driver;

    // Passo 1: Navegar para a página de login
    @Given("que estou na página de login do Swag Labs")
    public void queEstouNaPaginaDeLoginDoSwagLabs() {
        driver.get("https://www.saucedemo.com/");  // Acessando a URL da página de login
        loginPage = new LoginPage(driver);
    }

    // Passo 2: Inserir usuário e senha
    @When("eu insiro o usuário {string} e a senha {string}")
    public void euInsiroOUsuarioEASenha(String username, String password) {
        loginPage.fazerLogin(username, password);  // Realiza o login com os dados informados
    }

    // Passo 3: Clicar no botão de login
    @And("clico no botão de login")
    public void clicoNoBotaoDeLogin() {
        loginPage.clicarBotaoLogin();  // Clica no botão de login
    }

    // Passo 4: Verificar se a página de produtos foi exibida (Login com sucesso)
    @Then("devo ver a página de produtos")
    public void devoVerAPaginaDeProdutos() {
        assertTrue(loginPage.isPaginaDeProdutosExibida(), "A página de produtos não foi exibida.");
    }

    // Passo 5: Verificar se uma mensagem de erro foi exibida (Login com falha)
    @Then("devo ver uma mensagem de erro")
    public void devoVerUmaMensagemDeErro() {
        assertTrue(loginPage.isMensagemErroExibida(), "A mensagem de erro não foi exibida.");
    }
}
