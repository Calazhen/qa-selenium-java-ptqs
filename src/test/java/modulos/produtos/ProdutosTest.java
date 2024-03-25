package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

@DisplayName("Teste Web do modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;
    String basePath = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", basePath);
        this.navegador = new ChromeDriver();

        navegador.manage().window().maximize();

        navegador.get("http://165.227.93.41/lojinha-web/v2/");


    }

    @Test
    @DisplayName("Não é permitido registar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .preencherNomeDoProduto("Macbook Pro")
                .preencherValorDoProduto("000")
                .preencherCorDoProduto("preto, branco")
                .submeterFormularioComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Não é permitido registar um produto com valor maior que sete mil")
    public void testNaoEPermitidoRegistrarProdutoComValorAcimaDeSeteMil() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .preencherNomeDoProduto("Iphone")
                .preencherValorDoProduto("700001")
                .preencherCorDoProduto("preto e azul")
                .submeterFormularioComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos na faixa de valor entre 0,01 a 7.000,00")
    public void testPossoAdicionarProdutosComValorDeUmCentavoASeteMilReais() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .preencherNomeDoProduto("Playstation 4")
                .preencherValorDoProduto("30000")
                .preencherCorDoProduto("preto e azul")
                .submeterFormularioComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos no valor de R$7.000,00")
    public void testPossoAdicionarProdutosComValorDeSeteMilReais() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .preencherNomeDoProduto("Playstation 5")
                .preencherValorDoProduto("700000")
                .preencherCorDoProduto("preto e azul")
                .submeterFormularioComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @AfterEach
    public void tearDown() {
        // Vou fechar o navegador
        navegador.quit();
    }

}
