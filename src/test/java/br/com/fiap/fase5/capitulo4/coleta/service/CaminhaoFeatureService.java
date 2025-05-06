package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.model.CaminhaoFeatureModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CaminhaoFeatureService {
    final CaminhaoFeatureModel caminhaoFeatureModel = new CaminhaoFeatureModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String localUrl = "http://localhost:8080";

    public void setAtributosCaminhao(String atributo, String valor) {
        switch (atributo) {
            case "id" -> caminhaoFeatureModel.setId(valor);
            case "rota" -> caminhaoFeatureModel.setRota(valor);
            case "capacidade" -> caminhaoFeatureModel.setCapacidade(Long.parseLong(valor));
            case "placa" -> caminhaoFeatureModel.setPlaca(valor);
            case "statusServico" -> caminhaoFeatureModel.setStatusServico(Boolean.parseBoolean(valor));
            default -> throw new IllegalStateException("Atributo inválido.");
        }
    }

    public void cadastrarCaminhao(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(caminhaoFeatureModel);
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

    public void listarCaminhoes(String endPoint) {
        String url = localUrl + endPoint;
        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public void atualizarCaminhao(String endPoint) {
        String url = localUrl + endPoint;
        String bodyToSend = gson.toJson(caminhaoFeatureModel);
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

    public void deletarCaminhao(String endPoint, String placa) {
        String url = String.format("%s%s/%s", localUrl, endPoint, placa);
        response = given()
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }

    public Response cadastrarCaminhao(Object dadosCaminhao) {
        return given()
                .contentType("application/json")
                .body(dadosCaminhao)
                .when()
                .post("/api/v2/coleta/caminhoes/cadastrar-caminhao");
    }

    public Response atualizarCaminhao(Object dadosCaminhao) {
        return given()
                .contentType("application/json")
                .body(dadosCaminhao)
                .when()
                .put("/api/v2/coleta/caminhoes/atualizar-caminhao");
    }

    public Response excluirCaminhao(String placa) {
        return given()
                .contentType("application/json")
                .pathParam("placa", placa)
                .when()
                .delete("/api/v2/coleta/caminhoes/excluir-caminhao");
    }

    public Response listarCaminhoes() {
        return given()
                .contentType("application/json")
                .when()
                .get("/api/v2/coleta/caminhoes/listar");
    }
}