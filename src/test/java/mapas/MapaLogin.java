package maps;

import java.util.HashMap;
import java.util.Map;

public class MapaLogin {
    public static String tokenAutenticacao;
    private static Map<String, Object> credenciais;

    public static Map<String, Object> getCredenciais() {
        return credenciais;
    }

    public static void prepararLogin() {
        credenciais = new HashMap<>();
        credenciais.put("email", "fulano@qa.com");
        credenciais.put("password", "teste");
    }
}
