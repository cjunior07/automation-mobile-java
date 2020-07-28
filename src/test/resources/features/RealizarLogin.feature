#language: pt
#enconding: UTF-8

@FT001_Realizar_login
Funcionalidade: App Food

  @CE001_Criar_conta
  Cenario: CE001 - Criar conta com sucesso
    Dado que estou na pagina inicial do app e clico em "I AM NEW"
    Quando escrevo "junior.andrade.360@hotmail.com" no campo "E-mail"
    E escrevo "61986364434" no campo "Phone number"
    E escrevo "123456" no campo "Password"
    E clico em "CREATE ACCOUNT"
    E digito o codigo de verificacao
    E clico em "SUBMIT CODE"
    Entao vejo a tela inicial

  @CE002_Realizar_login_sucesso
  Cenario: CE002 - Realizar login com sucesso
    Dado que estou na pagina inicial do app e clico em "I HAVE BEEN HERE"
    Quando escrevo "junior.andrade.360@hotmail.com" no campo "E-mail or phone number"
    E escrevo "123456" no campo "Password"
    E clico em "SIGN IN"
    Entao vejo a tela inicial

  @CE003_Validar_Login_com_botao_facebook
  Cenario: CE003 - Validar login com botão do facebook
    Dado que estou na pagina inicial do app e clico em "I HAVE BEEN HERE"
    E clico em "SIGN IN WITH FACEBOOK"
    Entao vejo a tela inicial

  @CE004_Validar_Login_com_botao_google
  Cenario: CE004 - Validar login com botao do google
    Dado que estou na pagina inicial do app e clico em "I HAVE BEEN HERE"
    E clico em "SIGN IN WITH GOOGLE"
    Entao vejo a tela inicial

  @CE005_Validar_skip_tela_inicial
  Cenario: CE005 - Validar botão skip da tela inicial e acessar pagina inicial do app
    Dado que estou na pagina inicial do app e clico em "Skip"
    Entao vejo a tela inicial

  @CE006_Resetar_senha
  Cenario: CE006 - Resetar senha no app
    Dado que estou na pagina inicial do app e clico em "I HAVE BEEN HERE"
    E clico em "Forgot password?"
    E escrevo "junior.andrade.360@hotmail.com" no campo "E-mail address"
    E clico em "RESET PASSWORD"
    Entao vejo a mensagem "Sending instructions"

  @CE007_Validar_Termos_condicoes
  Cenario: CE007 - Validar termos e condições
    Dado que estou na pagina inicial do app e clico em "I HAVE BEEN HERE"
    E clico em "Terms & Conditions"
    Entao vejo a mensagem "Terms and Conditions"

  @CE008_Validar_Politicas_de_privacidade
  Cenario: CE008 - Validar termos e condições
    Dado que estou na pagina inicial do app e clico em "I HAVE BEEN HERE"
    E clico em "Privacy Policy"
    Entao vejo a mensagem "Terms and Conditions"

  @CE009_Realizar_compra
  Cenario: CE009 - Realizar Compras com sucesso
    Dado que estou na pagina inicial do app e clico em "I HAVE BEEN HERE"
    Quando escrevo "junior.andrade.360@hotmail.com" no campo "E-mail or phone number"
    E escrevo "123456" no campo "Password"
    E clico em "SIGN IN"
    E clico no carrinho
    E clico em "Checkout"
    E clico em "Next"
    E clico em "Next"
    E clico em "Place Order"
    Entao vejo a mensagem "SUCCESS!"
