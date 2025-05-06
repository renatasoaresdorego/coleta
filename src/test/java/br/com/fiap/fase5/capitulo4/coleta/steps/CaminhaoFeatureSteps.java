package br.com.fiap.fase5.capitulo4.coleta.steps;

import br.com.fiap.fase5.capitulo4.coleta.service.CaminhaoFeatureService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CaminhaoFeatureSteps {
    CaminhaoFeatureService caminhaoFeatureService = new CaminhaoFeatureService();

    @Dado("os dados do caminhão:")
    public void osDadosDoCaminhao(List<Map<String, String>> linhas) {
        for (Map<String, String> colunas : linhas) {
            caminhaoFeatureService.setAtributosCaminhao(colunas.get("atributo"), colunas.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para cadastrar o caminhão no endpoint {string}")
    public void euEnviarARequisiçãoParaCadastrarOCaminhaoNoEndpoint(String endPoint) {
        caminhaoFeatureService.cadastrarCaminhao(endPoint);
    }

    @Quando("eu enviar a requisição para listar os caminhões no endpoint {string}")
    public void euEnviarARequisiçãoParaListarOsCaminhoesNoEndpoint(String endPoint) {
        caminhaoFeatureService.listarCaminhoes(endPoint);
    }

    @Quando("eu enviar a requisição para atualizar o caminhão no endpoint {string}")
    public void euEnviarARequisiçãoParaAtualizarOCaminhaoNoEndpoint(String endPoint) {
        caminhaoFeatureService.atualizarCaminhao(endPoint);
    }

    @Quando("eu enviar a requisição para deletar o caminhão com placa {string} no endpoint {string}")
    public void euEnviarARequisiçãoParaDeletarOCaminhaoComPlacaNoEndpoint(String placa, String endPoint) {
        caminhaoFeatureService.deletarCaminhao(endPoint, placa);
    }

    @Então("o status code da resposta do caminhão deverá ser {int}")
    public void oStatusCodeDaRespostaDoCaminhaoDeveráSer(int statusCode) {
        Assert.assertEquals(statusCode, caminhaoFeatureService.response.getStatusCode());
    }
}
