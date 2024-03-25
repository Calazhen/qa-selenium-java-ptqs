package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {

    private WebDriver navegador;

    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public LoginPage informarOUsuario(String usuario) {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.findElement(By.id("usuario")).sendKeys(usuario);
        return this;
    }

    public LoginPage informarASenha(String senha) {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.findElement(By.id("senha")).sendKeys(senha);
        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeLogin() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.findElement(By.cssSelector("button[type=submit]")).click();
        return new ListaDeProdutosPage(navegador);
    }


}
