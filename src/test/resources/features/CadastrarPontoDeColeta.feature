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