#language: pt
Funcionalidade: Cadastrar ponto de coleta
  Como administrador da aplicação
  Quero cadastrar um novo ponto de coleta
  Para gerenciar os locais de coleta de resíduos

  Cenario: Cadastro bem-sucedido de um novo ponto de coleta
    Dado os dados do ponto de coleta:
      | atributo          | valor              |
      | id                | 1                  |
      | endereco          | Rua A, 123         |
      | capacidadeMaxima  | 100.0              |
      | capacidadeAtual   | 50.0               |
      | residuo           | PLASTICO           |
    Quando eu enviar a requisição para cadastrar o ponto de coleta no endpoint "/api/v2/coleta/pontos-de-coleta/cadastrar"
    Então o status code da resposta do ponto de coleta deverá ser 201

  Cenario: Atualização bem-sucedida de um ponto de coleta
    Dado os dados do ponto de coleta:
      | atributo          | valor              |
      | id                | 1                  |
      | endereco          | Rua B, 456         |
      | capacidadeMaxima  | 200.0              |
      | capacidadeAtual   | 100.0              |
      | residuo           | VIDRO              |
    Quando eu enviar a requisição para atualizar o ponto de coleta no endpoint "/api/v2/coleta/pontos-de-coleta/atualizar"
    Então o status code da resposta do ponto de coleta deverá ser 202

  Cenario: Cadastro sem sucesso devido a dados inválidos
    Dado os dados do ponto de coleta:
      | atributo          | valor              |
      | id                |                    |
      | endereco          |                    |
      | capacidadeMaxima  | -10.0              |
      | capacidadeAtual   | 200.0              |
      | residuo           |                    |
    Quando eu enviar a requisição para cadastrar o ponto de coleta no endpoint "/api/v2/coleta/pontos-de-coleta/cadastrar"
    Então o status code da resposta do ponto de coleta deverá ser 400

  Cenario: Cadastro sem sucesso devido a ponto de coleta já existente
    Dado os dados do ponto de coleta:
      | atributo          | valor              |
      | id                | 1                  |
      | endereco          | Rua A, 123         |
      | capacidadeMaxima  | 100.0              |
      | capacidadeAtual   | 50.0               |
      | residuo           | PLASTICO           |
    Quando eu enviar a requisição para cadastrar o ponto de coleta no endpoint "/api/v2/coleta/pontos-de-coleta/cadastrar"
    Então o status code da resposta do ponto de coleta deverá ser 404

  Cenario: Exclusão bem-sucedida de um ponto de coleta
    Quando eu enviar a requisição para deletar o ponto de coleta com id "1" no endpoint "/api/v2/coleta/pontos-de-coleta/excluir"
    Então o status code da resposta do ponto de coleta deverá ser 204

  Cenario: Listagem de pontos de coleta
    Quando eu enviar a requisição para listar os pontos de coleta no endpoint "/api/v2/coleta/pontos-de-coleta/listar"
    Então o status code da resposta do ponto de coleta deverá ser 200