package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.model.AgendaFeatureModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AgendaFeatureService {
    final AgendaFeatureModel agendaFeatureModel = new AgendaFeatureModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String localUrl = "http://localhost:8080";

    public void setAtributosAgenda(String atributo, String valor) {
        switch (atributo) {
            case "rota" -> agendaFeatureModel.setRota(valor);
            case "pontoDeColeta" -> agendaFeatureModel.setPontoDeColeta(valor);
            default -> throw new IllegalStateException("Atributo inválido.");
        }
    }

    public void cadastrarAgenda(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(agendaFeatureModel);
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

    public void listarAgendas(String endPoint) {
        String url = localUrl + endPoint;
        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public void excluirAgenda(String endPoint) {
        String url = localUrl + endPoint;
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}