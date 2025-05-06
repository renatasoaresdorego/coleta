package br.com.fiap.fase5.capitulo4.coleta.steps;

import br.com.fiap.fase5.capitulo4.coleta.service.PontoDeColetaFeatureService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PontoDeColetaFeatureSteps {
    PontoDeColetaFeatureService pontoDeColetaFeatureService = new PontoDeColetaFeatureService();

    @Dado("os dados do ponto de coleta:")
    public void osDadosDoPontoDeColeta(List<Map<String, String>> linhas) {
        for (Map<String, String> colunas : linhas) {
            pontoDeColetaFeatureService.setAtributosPontoDeColeta(colunas.get("atributo"), colunas.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para cadastrar o ponto de coleta no endpoint {string}")
    public void euEnviarARequisiçãoParaCadastrarOPontoDeColetaNoEndpoint(String endPoint) {
        pontoDeColetaFeatureService.cadastrarPontoDeColeta(endPoint);
    }

    @Quando("eu enviar a requisição para listar os pontos de coleta no endpoint {string}")
    public void euEnviarARequisiçãoParaListarOsPontosDeColetaNoEndpoint(String endPoint) {
        pontoDeColetaFeatureService.listarPontosDeColeta(endPoint);
    }

    @Quando("eu enviar a requisição para atualizar o ponto de coleta no endpoint {string}")
    public void euEnviarARequisiçãoParaAtualizarOPontoDeColetaNoEndpoint(String endPoint) {
        pontoDeColetaFeatureService.atualizarPontoDeColeta(endPoint);
    }

    @Quando("eu enviar a requisição para deletar o ponto de coleta com id {string} no endpoint {string}")
    public void euEnviarARequisiçãoParaDeletarOPontoDeColetaComIdNoEndpoint(String id, String endPoint) {
        pontoDeColetaFeatureService.deletarPontoDeColeta(endPoint, id);
    }

    @Então("o status code da resposta do ponto de coleta deverá ser {int}")
    public void oStatusCodeDaRespostaDoPontoDeColetaDeveráSer(int statusCode) {
        Assert.assertEquals(statusCode, pontoDeColetaFeatureService.response.getStatusCode());
    }
}