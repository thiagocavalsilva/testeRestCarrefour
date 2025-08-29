package maps;

import java.util.HashMap;
import java.util.Map;

public class MapaUsuarios {
    private static Map<String, Object> usuarioPrincipal;
    private static Map<String, Object> usuarioSecundario;
    public static String idUsuarioPrincipal;
    private static String idUsuarioSecundario;

    public static Map<String, Object> getUsuarioPrincipal() {
        return usuarioPrincipal;
    }

    public static Map<String, Object> getUsuarioSecundario() {
        return usuarioSecundario;
    }

    public static String getIdUsuarioPrincipal() {
        return idUsuarioPrincipal;
    }

    public static String getIdUsuarioSecundario() {
        return idUsuarioSecundario;
    }

    public static void setIdUsuarioPrincipal(String id) {
        idUsuarioPrincipal = id;
    }

    public static void setIdUsuarioSecundario(String id) {
        idUsuarioSecundario = id;
    }

    public static void prepararUsuarioPrincipal(String nome, String email, String senha, String administrador) {
        usuarioPrincipal = new HashMap<>();
        usuarioPrincipal.put("nome", nome);
        usuarioPrincipal.put("email", email);
        usuarioPrincipal.put("password", senha);
        usuarioPrincipal.put("administrador", administrador);
    }

    public static void prepararUsuarioSecundario(String nome, String email, String senha, String administrador) {
        usuarioSecundario = new HashMap<>();
        usuarioSecundario.put("nome", nome);
        usuarioSecundario.put("email", email);
        usuarioSecundario.put("password", senha);
        usuarioSecundario.put("administrador", administrador);
    }

    public static void limparDados() {
        usuarioPrincipal = null;
        usuarioSecundario = null;
        idUsuarioPrincipal = null;
        idUsuarioSecundario = null;
    }
}
