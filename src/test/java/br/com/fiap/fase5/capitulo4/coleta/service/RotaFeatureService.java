package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.model.RotaFeatureModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RotaFeatureService {
    final RotaFeatureModel rotaFeatureModel = new RotaFeatureModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String localUrl = "http://localhost:8080";

    public void setAtributosRota(String atributo, String valor) {
        switch (atributo) {
            case "id" -> rotaFeatureModel.setId(valor);
            case "nome" -> rotaFeatureModel.setNome(valor);
            case "inicio" -> rotaFeatureModel.setInicio(valor);
            case "fim" -> rotaFeatureModel.setFim(valor);
            default -> throw new IllegalStateException("Atributo inválido.");
        }
    }

    public void criarRota(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(rotaFeatureModel);
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

    public void atualizarRota(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(rotaFeatureModel);
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

    public void listarRotas(String endPoint) {
        String url = localUrl + endPoint;
        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public void obterId() {
        rotaFeatureModel.setId(response.jsonPath().getString("id"));
    }

    public void deletarRota(String endPoint, String id) {
        String url = String.format("%s%s/%s", localUrl, endPoint, id);
        response = given()
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}