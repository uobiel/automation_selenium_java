package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");
    private By mensagemErro = By.cssSelector("[data-test='error']");
    private By paginaProdutos = By.className("title");

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(botaoLogin));

        driver.findElement(botaoLogin).click();
    }

    public void fazerLogin(String username, String password) {
        digitarUsuario(username);
        digitarSenha(password);
    }

    public boolean isMensagemErroExibida() {
        return driver.findElement(mensagemErro).isDisplayed();
    }

    public boolean isPaginaDeProdutosExibida() {
        return driver.findElement(paginaProdutos).isDisplayed();
    }
}