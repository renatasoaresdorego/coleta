package br.com.fiap.fase5.capitulo4.coleta.steps;

import br.com.fiap.fase5.capitulo4.coleta.service.RotaFeatureService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class RotaFeatureSteps {
    RotaFeatureService rotaFeatureService = new RotaFeatureService();

    @Dado("os dados da rota:")
    public void osDadosDaRota(List<Map<String, String>> linhas) {
        for (Map<String, String> colunas : linhas) {
            rotaFeatureService.setAtributosRota(colunas.get("atributo"), colunas.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para criar a rota no endpoint {string}")
    public void euEnviarARequisiçãoParaCriarARotaNoEndpoint(String endPoint) {
        rotaFeatureService.criarRota(endPoint);
    }

    @Quando("eu enviar a requisição para atualizar a rota no endpoint {string}")
    public void euEnviarARequisiçãoParaAtualizarARotaNoEndpoint(String endPoint) {
        rotaFeatureService.atualizarRota(endPoint);
    }

    @Quando("eu enviar a requisição para listar as rotas no endpoint {string}")
    public void euEnviarARequisiçãoParaListarAsRotasNoEndpoint(String endPoint) {
        rotaFeatureService.listarRotas(endPoint);
    }

    @Quando("eu enviar a requisição para deletar a rota com id {string} no endpoint {string}")
    public void euEnviarARequisiçãoParaDeletarARotaComIdNoEndpoint(String id, String endPoint) {
        rotaFeatureService.deletarRota(endPoint, id);
    }

    @Então("o status code da resposta da rota deverá ser {int}")
    public void oStatusCodeDaRespostaDaRotaDeveráSer(int statusCode) {
        Assert.assertEquals(statusCode, rotaFeatureService.response.getStatusCode());
    }

    @Dado("que eu recupere o ID da rota")
    public void queEuRecupereOIdDaRota() {
        rotaFeatureService.obterId();
    }
}