package br.com.fiap.fase5.capitulo4.coleta.steps;

import br.com.fiap.fase5.capitulo4.coleta.service.AgendaFeatureService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AgendaFeatureSteps {
    AgendaFeatureService agendaFeatureService = new AgendaFeatureService();

    @Dado("os dados da agenda:")
    public void osDadosDaAgenda(List<Map<String, String>> linhas) {
        for (Map<String, String> colunas : linhas) {
            agendaFeatureService.setAtributosAgenda(colunas.get("atributo"), colunas.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para cadastrar a agenda no endpoint {string}")
    public void euEnviarARequisiçãoParaCadastrarAAgendaNoEndpoint(String endPoint) {
        agendaFeatureService.cadastrarAgenda(endPoint);
    }

    @Quando("eu enviar a requisição para listar as agendas no endpoint {string}")
    public void euEnviarARequisiçãoParaListarAsAgendasNoEndpoint(String endPoint) {
        agendaFeatureService.listarAgendas(endPoint);
    }

    @Quando("eu enviar a requisição para atualizar a agenda no endpoint {string}")
    public void euEnviarARequisiçãoParaAtualizarAAgendaNoEndpoint(String endPoint) {
        agendaFeatureService.atualizarAgenda(endPoint);
    }

    @Quando("eu enviar a requisição para deletar a agenda com id {string} no endpoint {string}")
    public void euEnviarARequisiçãoParaDeletarAAgendaComIdNoEndpoint(String id, String endPoint) {
        agendaFeatureService.deletarAgenda(endPoint, id);
    }

    @Então("o status code da resposta da agenda deverá ser {int}")
    public void oStatusCodeDaRespostaDaAgendaDeveráSer(int statusCode) {
        Assert.assertEquals(statusCode, agendaFeatureService.response.getStatusCode());
    }
}