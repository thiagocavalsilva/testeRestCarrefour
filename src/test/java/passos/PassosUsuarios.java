package steps;

import io.cucumber.java.pt.E;
import io.restassured.http.ContentType;
import maps.MapaUsuarios;
import utils.RequisicoesApi;

public class PassosUsuarios {


    @E("tambem cadastro o usuario {string} email {string} senha {string} administrador {string}")
    public void criarOutroUsuario(String nome, String email, String senha, String administrador) {
        MapaUsuarios.prepararUsuarioSecundario(nome, email, senha, administrador);
        RequisicoesApi.realizarPost(MapaUsuarios.getUsuarioSecundario(), ContentType.JSON, "/usuarios");
        MapaUsuarios.setIdUsuarioSecundario(RequisicoesApi.getResposta().jsonPath().getString("_id"));
    }

}





