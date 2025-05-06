#language: pt
Funcionalidade: Atualizar ponto de coleta
  Como administrador da aplicação
  Quero atualizar um ponto de coleta existente
  Para manter as informações atualizadas

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