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

public class AgendaContractTest {

    @Test
    public void validarContratoCadastroAgenda() throws Exception {
        Response response = given()
                .contentType("application/json")
                .body("{ \"rota\": \"1\", \"pontoDeColeta\": \"1\", \"dataProximaColeta\": \"2025-05-01T10:00:00\" }")
                .post("http://localhost:8080/api/v2/coleta/agenda/agendar-coleta");

        Assert.assertEquals(201, response.getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream schemaStream = getClass().getResourceAsStream("/schemas/agenda-schema.json");
        JsonNode schemaNode = objectMapper.readTree(schemaStream);
        JsonNode responseNode = objectMapper.readTree(response.getBody().asString());

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);
        ProcessingReport report = schema.validate(responseNode);

        Assert.assertTrue("O contrato não é válido: " + report, report.isSuccess());
    }
}