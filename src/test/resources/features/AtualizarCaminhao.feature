#language: pt
Funcionalidade: Atualizar caminhão
  Como administrador da aplicação
  Quero atualizar um caminhão existente
  Para manter as informações atualizadas

  Contexto: Cadastro bem-sucedido de uma nova rota e caminhão
    Dado os dados da rota:
      | atributo | valor          |
      | id       | 9              |
      | nome     | Rota 9         |
      | inicio   | Local Y        |
      | fim      | Local Z        |
    Quando eu enviar a requisição para criar a rota no endpoint "/api/v2/coleta/rotas/gravar"
    Então o status code da resposta da rota deverá ser 201
    E os dados do caminhão:
      | atributo         | valor          |
      | id               | 1              |
      | rota             | 1              |
      | capacidade       | 1000           |
      | placa            | ABC-1234       |
      | statusServico    | true           |
    Quando eu enviar a requisição para cadastrar o caminhão no endpoint "/api/v2/coleta/caminhoes/cadastrar-caminhao"
    Então o status code da resposta do caminhão deverá ser 201

  Cenario: Atualização bem-sucedida de um caminhão
    Dado os dados do caminhão:
      | atributo         | valor          |
      | id               | 1              |
      | rota             | 9              |
      | capacidade       | 1500           |
      | placa            | ABC-1234       |
      | statusServico    | false          |
    Quando eu enviar a requisição para atualizar o caminhão no endpoint "/api/v2/coleta/caminhoes/atualizar-caminhao"
    Então o status code da resposta do caminhão deverá ser 202