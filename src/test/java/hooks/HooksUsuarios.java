package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maps.MapaUsuarios;
import utils.RequisicoesApi;

public class HooksUsuarios {

    @Before
    public void prepararAmbiente() {
        RequisicoesApi.definirBaseUrl("http://localhost:3000");
        removerTodosUsuarios();
    }

    @After
    public void limparContexto() {
        MapaUsuarios.limparDados();
    }

    private static void removerTodosUsuarios() {
        try {
            RequisicoesApi.realizarGet(new HashMap<>(), "/usuarios");
            if (RequisicoesApi.getResposta().getStatusCode() == 200) {
                List<Map<String, Object>> usuarios = RequisicoesApi.getResposta().jsonPath().getList("usuarios");
                if (usuarios != null && !usuarios.isEmpty()) {
                    for (Map<String, Object> usuario : usuarios) {
                        String id = (String) usuario.get("_id");
                        if (id != null) {
                            System.out.println("Removendo usuário: " + id);
                            RequisicoesApi.realizarDelete(new HashMap<>(), "/usuarios/" + id);
                            if (RequisicoesApi.getResposta().getStatusCode() == 200) {
                                System.out.println("Usuário " + id + " removido com sucesso.");
                            } else {
                                System.out.println("Falha ao remover usuário " + id + ": ");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}