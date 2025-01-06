package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");
    private By mensagemErro = By.cssSelector("[data-test='error']");
    private By paginaProdutos = By.className("title");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void digitarUsuario(String username) {
        type(campoUsuario, username);
    }

    public void digitarSenha(String password) {
        type(campoSenha, password);
    }

    public void clicarBotaoLogin() {
        click(botaoLogin);
    }

    public void fazerLogin(String username, String password) {
        digitarUsuario(username);
        digitarSenha(password);
        clicarBotaoLogin();
    }

    public boolean isMensagemErroExibida() {
        return find(mensagemErro).isDisplayed();
    }

    public boolean isPaginaDeProdutosExibida() {
        return find(paginaProdutos).isDisplayed();
    }
}