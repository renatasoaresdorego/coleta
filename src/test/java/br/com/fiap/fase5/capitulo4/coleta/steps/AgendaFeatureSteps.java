package br.com.fiap.fase5.capitulo4.coleta.steps;

import br.com.fiap.fase5.capitulo4.coleta.service.AgendaFeatureService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.E;
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

    @Quando("eu enviar a requisição para excluir a agenda no endpoint {string}")
    public void euEnviarARequisiçãoParaExcluirAAgendaNoEndpoint(String endPoint) {
        agendaFeatureService.excluirAgenda(endPoint);
    }

    @Então("o status code da resposta da agenda deverá ser {int}")
    public void oStatusCodeDaRespostaDaAgendaDeveráSer(int statusCode) {
        Assert.assertEquals(statusCode, agendaFeatureService.response.getStatusCode());
    }

    @Então("o status code da resposta da exclusão deverá ser {int}")
    public void oStatusCodeDaRespostaDaExclusãoDeveráSer(int statusCode) {
        Assert.assertEquals(statusCode, agendaFeatureService.response.getStatusCode());
    }

    @E("o corpo da resposta da agenda deverá retornar a mensagem {string}")
    public void oCorpoDaRespostaDaAgendaDeveráRetornarAMensagem(String mensagemEsperada) {
        if (agendaFeatureService.response == null) {
            throw new IllegalStateException("A resposta da requisição é nula. Certifique-se de que a requisição foi enviada corretamente.");
        }
        String responseBody = agendaFeatureService.response.getBody().asString();
        Assert.assertNotNull("O corpo da resposta não deve ser nulo", responseBody);
        Assert.assertTrue("A mensagem esperada não está presente no corpo da resposta", responseBody.contains(mensagemEsperada));
    }
}