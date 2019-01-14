#language: pt

Funcionalidade: Permitir fazer login no sistema Web

	@nexec
  Cenário: Fazer login com sucesso
    Dado que estou na pagina "nome da pagina"
		Quando eu informar "nome do usuário" no campo "login"
    E informar "senha válida" no campo "senha"
    E cliar no botão "Login"
    Então deve logar exibindo texto "login com sucesso" no "campo de login"

  @nexec
  Esquema do Cenário: Fazer login com falha
    Dado que estou na pagina "nome da pagina"
		Quando eu informar <login> no campo "login"
    E informar <senha> no campo "senha"
    E cliar no botão "Login"
    Então deve logar exibindo texto <mensagem> no "campo de login"

    Exemplos: 
      |login														| senha 															|mensagem					|
      |"Login inválido"									|"senha válida"												|"Login inválido"	|
      |"Senha válida" 									|"Senha invalida" 										|"Senha inválida"	|
      |"Login válido"										|"Senha válida mas de outro usuário"	|"Senha inválida"	|
