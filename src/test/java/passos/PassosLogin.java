package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.E;
import io.restassured.http.ContentType;
import maps.MapaLogin;
import maps.MapaUsuarios;
import org.junit.Assert;
import utils.RequisicoesApi;

import java.util.HashMap;

public class PassosLogin {

    @Dado("que defino um usuario chamado {string} email {string} senha {string} administrador {string}")
    public void criarUsuario(String nome, String email, String senha, String administrador) {
        MapaUsuarios.prepararUsuarioPrincipal(nome, email, senha, administrador);
        RequisicoesApi.realizarPost(MapaUsuarios.getUsuarioPrincipal(), ContentType.JSON, "/usuarios");
        MapaUsuarios.setIdUsuarioPrincipal(RequisicoesApi.getResposta().jsonPath().getString("_id"));
    }

    @Quando("consulto todos os usuarios")
    public void consultarTodosUsuarios() {
        RequisicoesApi.realizarGet(new HashMap<>(), "/usuarios");
    }

    @Quando("altero suas informacoes para nome {string} email {string} senha {string} administrador {string}")
    public void alterarUsuario(String nome, String email, String senha, String administrador) {
        MapaUsuarios.prepararUsuarioPrincipal(nome, email, senha, administrador);
        RequisicoesApi.realizarPut(MapaUsuarios.getUsuarioPrincipal(), ContentType.JSON, "/usuarios/" + MapaUsuarios.getIdUsuarioPrincipal());
    }
    @Dado("que informo um e-mail valido {string} e senha {string}")
    public void informarCredenciais(String email, String senha) {
        MapaLogin.prepararLogin();
        MapaLogin.getCredenciais().put("email", email);
        MapaLogin.getCredenciais().put("password", senha);
    }

    @Quando("envio a requisicao de autenticacao")
    public void enviarRequisicaoLogin() {
        RequisicoesApi.realizarPost(MapaLogin.getCredenciais(), ContentType.JSON, "/login");
        if (RequisicoesApi.getResposta().getStatusCode() == 200) {
            MapaLogin.tokenAutenticacao = RequisicoesApi.getResposta().jsonPath().getString("authorization");
        }
    }

    @Entao("o sistema deve retornar código {int}")
    public void validarCodigoResposta(Integer codigoEsperado) {
        Assert.assertEquals(codigoEsperado.intValue(), RequisicoesApi.getResposta().getStatusCode());
    }
}


