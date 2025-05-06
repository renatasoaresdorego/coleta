package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.model.UsuarioFeatureModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsuarioFeatureService {
    final UsuarioFeatureModel usuarioFeatureModel = new UsuarioFeatureModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String localUrl = "http://localhost:8080";
    String cpf;

    public void setAtributosUsuario(String atributo, String valor) {
        switch (atributo) {
            case "cpf" -> usuarioFeatureModel.setCpf(valor);
            case "nome" -> usuarioFeatureModel.setNome(valor);
            case "telefone" -> usuarioFeatureModel.setTelefone(valor);
            case "email" -> usuarioFeatureModel.setEmail(valor);
            case "senha" -> usuarioFeatureModel.setSenha(valor);
            default -> throw new IllegalStateException("Atributo inválido.");
        }
    }

    public void criarUsuario(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(usuarioFeatureModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    public void atualizarUsuario(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(usuarioFeatureModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .put(url)
                .then()
                .extract()
                .response();
    }

    public void buscarUsuario(String endPoint, String cpf) {
        String url = String.format("%s%s/%s", localUrl, endPoint, cpf);
        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public void obterCpf() {
        cpf = String.valueOf(gson.fromJson(response.jsonPath().prettify(), UsuarioFeatureModel.class).getCpf());
    }

    public void deletarUsuario(String endPoint) {
         String url = String.format("%s%s/%s", localUrl, endPoint, cpf);
        response = given()
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }

}
