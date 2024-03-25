package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class FormularioDeAdicaoDeProdutoPage {

    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }


    public FormularioDeAdicaoDeProdutoPage preencherNomeDoProduto(String produtoNome) {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage preencherValorDoProduto(String produtoValor) {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        navegador.findElement(By.id("produtovalor")).sendKeys(produtoValor);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage preencherCorDoProduto(String produtoCores) {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCores);
        return this;
    }

    public ListaDeProdutosPage submeterFormularioComErro() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutosPage(navegador);
    }

    public FormularioDeEdicaoDeProdutoPage submeterFormularioComSucesso() {
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new FormularioDeEdicaoDeProdutoPage(navegador);
    }
}



