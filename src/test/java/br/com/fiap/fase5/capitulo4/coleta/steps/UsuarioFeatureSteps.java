package br.com.fiap.fase5.capitulo4.coleta.steps;

import br.com.fiap.fase5.capitulo4.coleta.model.ErrorMessageModel;
import br.com.fiap.fase5.capitulo4.coleta.service.UsuarioFeatureService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class UsuarioFeatureSteps {
    UsuarioFeatureService usuarioFeatureService = new UsuarioFeatureService();

    @Dado("os meus dados pessoais:")
    public void osMeusDadosPessoais(List<Map<String, String>> linhas) {
        for(Map<String, String> colunas : linhas) {
            usuarioFeatureService.setAtributosUsuario(colunas.get("atributo"), colunas.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string}")
    public void euEnviarARequisiçãoParaOEndpoint(String endPoint) {
        usuarioFeatureService.criarUsuario(endPoint);
    }

    @Então("o status code da resposta deverá ser {int}")
    public void oStatusCodeDaRespostaDeveráSer(int statusCode) {
        Assert.assertEquals(statusCode, usuarioFeatureService.response.getStatusCode());
    }

    @E("o corpo da resposta deverá retornar a mensagem {string}")
    public void oCorpoDaRespostaDeveráRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = usuarioFeatureService.gson.fromJson(
                usuarioFeatureService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    @Dado("que eu recupere o CPF do usuário")
    public void queEuRecupereOCPFDoUsuário() {
        usuarioFeatureService.obterCpf();
    }

    @Quando("eu enviar a requisição com o CPF para o endpoint {string}")
    public void euEnviarARequisiçãoComOCPFParaOEndpointApiVColetaUsuarioExcluirUsuario(String endPoint) {
        usuarioFeatureService.deletarUsuario(endPoint);
    }

    @Quando("eu enviar a requisição com os dados atualizadas para o endpoint {string}")
    public void euEnviarARequisiçãoComOsDadosAtualizadasParaOEndpoint(String endPoint) {
        usuarioFeatureService.atualizarUsuario(endPoint);
    }

    @Quando("eu enviar a requisição para buscar o usuário no endpoint {string} com o CPF {string}")
    public void euEnviarARequisiçãoParaBuscarOUsuárioNoEndpointComOCPF(String endPoint, String cpf) {
        usuarioFeatureService.buscarUsuario(endPoint, cpf);
    }

    @E("o corpo da resposta deverá conter os dados do usuário")
    public void oCorpoDaRespostaDeveráConterOsDadosDoUsuário() {
        String responseBody = usuarioFeatureService.response.getBody().asString();
        Assert.assertNotNull("O corpo da resposta não deve ser nulo", responseBody);
        Assert.assertFalse("O corpo da resposta não deve estar vazio", responseBody.isEmpty());

        Map<String, Object> usuario = usuarioFeatureService.response.jsonPath().getMap("$");
        Assert.assertNotNull("Os dados do usuário não devem ser nulos", usuario);
        Assert.assertTrue("O CPF do usuário deve estar presente", usuario.containsKey("cpf"));
    }
}
