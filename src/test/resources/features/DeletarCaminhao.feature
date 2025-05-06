#language: pt
Funcionalidade: Deletar caminhão
  Como administrador da aplicação
  Quero excluir um caminhão
  Para remover veículos desativados

  Contexto: Cadastro bem-sucedido de uma nova rota e caminhão
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 1              |
      | nome     | Rota 1         |
      | inicio   | Local A        |
      | fim      | Local B        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201
    E os dados do caminhão:
      | atributo         | valor          |
      | id               | 1              |
      | rota             | Rota 1         |
      | capacidade       | 1000           |
      | placa            | ABC-1234       |
      | statusServico    | true           |
    Quando eu enviar a requisição para cadastrar o caminhão no endpoint "/api/v2/coleta/caminhoes/cadastrar-caminhao"
    Então o status code da resposta do caminhão deverá ser 201

  Cenario: Exclusão bem-sucedida de um caminhão
    Quando eu enviar a requisição para deletar o caminhão com placa "ABC-1234" no endpoint "/api/v2/coleta/caminhoes/excluir-caminhao"
    Então o status code da resposta do caminhão deverá ser 204