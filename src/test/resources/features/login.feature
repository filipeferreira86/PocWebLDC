#language: pt
Funcionalidade: Permitir fazer login no sistema Web

	@log @exec
	Cenário: Validação de tela de login
		Quando eu acessar a pagina "localhost:8080/jenkins/job/PocWebLdc/ws/src/test/resources/amb/"
		Então deve exibir "Sistema de controle de usuários" no campo "TEXTBLOCK1"
		E campo "vUSUARIOLOGIN"
		E campo "vUSUARIOSENHA"

  @log
  Cenário: Fazer login com sucesso
    Dado que estou na pagina "file:///C:\Users\filipe.jesus\Documents\Testes\scripts\PocWebLDC\src\test\resources\amb\direcionamento.html"
    Quando eu informar "Filipe" no campo "vUSUARIOLOGIN"
    E informar "1234" no campo "vUSUARIOSENHA"
    E cliar no botão "BTNLOGIN"
    Então deve logar exibindo texto "Bem vindo Filipe Ferreira de Jesus" no "BOASVINDAS_MPAGE"

  @log
  Esquema do Cenário: Fazer login com falha
    Dado que estou na pagina "file:///C:\Users\filipe.jesus\Documents\Testes\scripts\PocWebLDC\src\test\resources\amb\direcionamento.html"
    Quando eu informar <login> no campo "vUSUARIOLOGIN"
    E informar <senha> no campo "vUSUARIOSENHA"
    E cliar no botão "BTNLOGIN"
    Então exibir mensagem de erro <mensagem> no "gxErrorViewer"

    Exemplos: 
      | login            | senha   | mensagem                                                           |
      | "Login inválido" | "1234"  | "Cadastro não encontrado com este usuário e senha. Favor validar." |
      | "Filipe"         | "12"    | "Cadastro não encontrado com este usuário e senha. Favor validar." |
      | "Filipe"         | "abc"   | "Cadastro não encontrado com este usuário e senha. Favor validar." |
      | ""               | "teste" | "Favor informar usuário."                                          |
      | "Filipe"         | ""      | "Favor informar senha."                                            |
