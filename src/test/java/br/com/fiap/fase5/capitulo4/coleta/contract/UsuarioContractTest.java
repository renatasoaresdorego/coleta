package br.com.fiap.fase5.capitulo4.coleta.contract;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class UsuarioContractTest {

    @Test
    public void validarContratoUsuario() throws Exception {
        Response response = given()
                .contentType("application/json")
                .body("{ \"cpf\": \"878.569.480-84\", \"nome\": \"user7\", \"telefone\": \"41998875665\", \"email\": \"user7@email.com\", \"senha\": \"123456\" }")
                .post("http://localhost:8080/api/v2/coleta/usuario/cadastro");

        Assert.assertEquals(201, response.getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream schemaStream = getClass().getResourceAsStream("/schemas/usuario-schema.json");
        JsonNode schemaNode = objectMapper.readTree(schemaStream);
        JsonNode responseNode = objectMapper.readTree(response.getBody().asString());

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);
        ProcessingReport report = schema.validate(responseNode);

        Assert.assertTrue("O contrato não é válido: " + report, report.isSuccess());
    }
}