#language:pt

@Login

Funcionalidade: Autenticacao de usuarios
  Para acessar recursos protegidos,
  o sistema deve validar corretamente as credenciais.

  Cenario: Login valido com credenciais corretas
    Dado que informo um e-mail valido "fulano@qa.com" e senha "teste"
    Quando envio a requisicao de autenticacao
    Então o sistema deve retornar código 200
    E a mensagem deve indicar "Login realizado com sucesso"

  Cenario: Tentativa de login com senha incorreta
    Dado que informo um e-mail valido "fulano@qa.com" e senha "senhaInvalida"
    Quando envio a requisicao de autenticacao
    Então o sistema deve retornar código 401
    E a mensagem deve indicar "Email e/ou senha inválidos"

  Cenario: Tentativa de login com usuario inexistente
    Dado que informo um e-mail valido "naoexiste@teste.com" e senha "teste"
    Quando envio a requisicao de autenticacao
    Então o sistema deve retornar código 401
    E a mensagem deve indicar "Email e/ou senha inválidos"
