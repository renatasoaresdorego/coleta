package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColetaFeatureModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

public class PontoDeColetaFeatureService {
    final PontoDeColetaFeatureModel pontoDeColetaFeatureModel = new PontoDeColetaFeatureModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String localUrl = "http://localhost:8080";

    public void setAtributosPontoDeColeta(String atributo, String valor) {
        switch (atributo) {
            case "id" -> pontoDeColetaFeatureModel.setId(valor);
            case "endereco" -> pontoDeColetaFeatureModel.setEndereco(valor);
            case "capacidadeMaxima" -> pontoDeColetaFeatureModel.setCapacidadeMaxima(new BigDecimal(valor));
            case "capacidadeAtual" -> pontoDeColetaFeatureModel.setCapacidadeAtual(new BigDecimal(valor));
            case "residuo" -> pontoDeColetaFeatureModel.setResiduo(valor);
            default -> throw new IllegalStateException("Atributo inválido.");
        }
    }

    public void cadastrarPontoDeColeta(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(pontoDeColetaFeatureModel);
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

    public void listarPontosDeColeta(String endPoint) {
        String url = localUrl + endPoint;
        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public void atualizarPontoDeColeta(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(pontoDeColetaFeatureModel);
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

    public void deletarPontoDeColeta(String endPoint, String id) {
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