package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.RequisicoesApi;

public class PassosComuns {

    @Entao("o sistema deve retornar codigo {int}")
    public void validarCodigoResposta(Integer codigoEsperado) {
        Assert.assertEquals(codigoEsperado.intValue(), RequisicoesApi.getResposta().getStatusCode());
    }

    @E("a mensagem deve indicar {string}")
    public void validarMensagemResposta(String mensagemEsperada) {
        Response resposta = RequisicoesApi.getResposta();
        String mensagemAtual = resposta.jsonPath().getString("message");
        Assert.assertTrue(mensagemAtual.contains(mensagemEsperada));
    }
}
