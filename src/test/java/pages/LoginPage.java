package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");
    private By mensagemErro = By.cssSelector("[data-test='error']");  // Mensagem de erro em caso de login inválido
    private By paginaProdutos = By.className("title");  // Classe usada na página de produtos

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void digitarUsuario(String username) {
        driver.findElement(campoUsuario).sendKeys(username);
    }

    public void digitarSenha(String password) {
        driver.findElement(campoSenha).sendKeys(password);
    }

    public void clicarBotaoLogin() {
        driver.findElement(botaoLogin).click();
    }

    public void fazerLogin(String username, String password) {
        digitarUsuario(username);
        digitarSenha(password);
        clicarBotaoLogin();
    }

    public boolean isMensagemErroExibida() {
        return driver.findElement(mensagemErro).isDisplayed();
    }

    public boolean isPaginaDeProdutosExibida() {
        return driver.findElement(paginaProdutos).isDisplayed();
    }
}
