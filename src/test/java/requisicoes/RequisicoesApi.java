package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class RequisicoesApi {

    private static String baseUrl;
    private static Response ultimaResposta;

    public static void definirBaseUrl(String url) {
        baseUrl = url;
    }

    public static Response getResposta() {
        return ultimaResposta;
    }

    public static void realizarGet(Map<String, ?> parametros, String endpoint) {
        ultimaResposta =
                given()
                        .queryParams(parametros)
                        .when()
                        .get(baseUrl + endpoint);
    }

    public static void realizarPost(Object corpo, ContentType tipoConteudo, String endpoint) {
        ultimaResposta =
                given()
                        .contentType(tipoConteudo)
                        .body(corpo)
                        .when()
                        .post(baseUrl + endpoint);
    }

    public static void realizarPostComHeaders(Map<String, String> headers, Object corpo, ContentType tipoConteudo, String endpoint) {
        ultimaResposta =
                given()
                        .headers(headers)
                        .contentType(tipoConteudo)
                        .body(corpo)
                        .when()
                        .post(baseUrl + endpoint);
    }

    public static void realizarPut(Object corpo, ContentType tipoConteudo, String endpoint) {
        ultimaResposta =
                given()
                        .contentType(tipoConteudo)
                        .body(corpo)
                        .when()
                        .put(baseUrl + endpoint);
    }

    public static void realizarPutComHeaders(Map<String, String> headers, Object corpo, ContentType tipoConteudo, String endpoint) {
        ultimaResposta =
                given()
                        .headers(headers)
                        .contentType(tipoConteudo)
                        .body(corpo)
                        .when()
                        .put(baseUrl + endpoint);
    }

    public static void realizarDelete(Map<String, ?> parametros, String endpoint) {
        ultimaResposta =
                given()
                        .queryParams(parametros)
                        .when()
                        .delete(baseUrl + endpoint);
    }

    public static void realizarDeleteComHeaders(Map<String, String> headers, Map<String, ?> parametros, String endpoint) {
        ultimaResposta =
                given()
                        .headers(headers)
                        .queryParams(parametros)
                        .when()
                        .delete(baseUrl + endpoint);
    }
}
