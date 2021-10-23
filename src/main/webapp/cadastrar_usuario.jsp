<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastrar Usuário</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<style>
.used {
	border: solid 2px red;
}

.container {
	margin-top: 5%;
}

.alreadyInUse {
	color: red;
	margin: 0px;
}

.alreadyInUseUsername {
	display: none;
}
</style>
<script>

const requisicao = (function(){
	let login = $("#inputUsername").val();
	$.ajax({
		type: 'POST',
		data: {loginForm: login},
		url: 'loginVerify',
		success: function(result){
			if(result===login){
				 if(!$("#inputUsername").hasClass("used")){
					    $("#inputUsername").addClass("used");
					    $("#alreadyInUseUsername").show();
					    $("#cadastrar").prop("disabled", true);
					    
				 }
				 
			}else {
				$("#alreadyInUseUsername").hide();
				$("#inputUsername").removeClass("used");
			    $("#cadastrar").prop("disabled", false);
			}
		} 
	})		
});

	function enviar(){
		document.forms["formCliente"].submit();
	}
	
	function validaCPF(cpf)
	{
			cpf = cpf.replace('.','');
			cpf = cpf.replace('.','');
			cpf = cpf.replace('-','');

			erro = new String;
			if (cpf.length < 11) erro += "Sao necessarios 11 digitos para verificacao do CPF! \n\n";
			var nonNumbers = /\D/;
			if (nonNumbers.test(cpf)) erro += "A verificacao de CPF suporta apenas numeros! \n\n";
			if (cpf == "00000000000" || cpf == "11111111111" ||
					cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" ||
			cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" ||
			cpf == "88888888888" || cpf == "99999999999"){
				  erro += "Numero de CPF invalido!"
			}
			var a = [];
			var b = new Number;
			var c = 11;
			for (i=0; i<11; i++){
				a[i] = cpf.charAt(i);
				if (i <  9) b += (a[i] *  --c);
			}
			if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }
			b = 0;
			c = 11;
			for (y=0; y<10; y++) b += (a[y] *  c--);
			if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }
			status = a[9] + ""+ a[10]
			if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10])){
				erro +="Digito verificador com problema!";
			}
			if (erro.length > 0){
				return true;
			}
			return false;
	}
	
	function validaLogin(login){
		if(/^[a-zA-Z0-9- ]*$/.test(login) == false) {
		   return true;
		}
		return false;
	}
	
	
	function validate(){
		let nome = formCliente.nome.value;
		let endereco = formCliente.endereco.value;
		let cpf = formCliente.cpf.value;
		let login = formCliente.login.value;
		let senha = formCliente.senha.value;

		if (nome === ''){
			alert("Nome vazio ou inválido");
			return false
		}else if (endereco === '') {
			alert("Endereço vazio ou inválido");
			return false
		}else if (validaCPF(cpf)) {
			alert("CPF inválido");
			return false
		}else if (validaLogin(login)) {
			alert("login inválido");
			return false
		}else if (senha === '') {
			alert("Senha inválida");
			return false
		}else{
			enviar();
		}
	}
	
	$(document).ready(function(){
		$("#inputUsername").keyup(function(){
			requisicao();
		});
	});
	
</script>
</head>
<body>
	<div class="container">
		<div class="mb-3 row justify-content-md-center">
			<div class="col-sm-4">
				<h2>Cadastrar usuário</h2>
			</div>
		</div>
		<form name="formCliente" action="signup" method="POST">

			<div class="mb-3 row justify-content-md-center">
				<div class="col-sm-4">
					<label for="inputName" class="form-label">Nome</label> <input
						name="nome" type="text" class="form-control" id="inputName"
						placeholder="nome">
				</div>
			</div>

			<div class="mb-3 row justify-content-md-center">
				<div class="col-sm-4">
					<label for="inputAdress" class="form-label">Endereço</label> <input
						name="endereco" type="text" class="form-control" id="inputAdress"
						placeholder="endereço">
				</div>
			</div>

			<div class="mb-3 row justify-content-md-center">
				<div class="col-sm-4">
					<label for="inputCpf" class="form-label">CPF</label> <input
						name="cpf" type="text" class="form-control" id="inputCpf"
						placeholder="cpf">
				</div>
			</div>

			<div class="mb-3 row justify-content-md-center">
				<div class="col-sm-4">
					<label for="inputLogin" class="form-label">Nome de usuário</label>
					<input name="login" type="text" class="form-control"
						id="inputUsername" placeholder="username">
					<p id="alreadyInUseUsername"
						class="alreadyInUseUsername alreadyInUse">Nome de usuário inválido ou já
						está sendo utilizado!</p>
				</div>
			</div>

			<div class="mb-3 row justify-content-md-center">
				<div class="col-sm-4">
					<label for="exampleInputPassword1" class="form-label">Senha</label>
					<input name="senha" type="password" class="form-control"
						id="inputPassword" placeholder="senha">
				</div>
			</div>
		</form>
		<div class="mb-3 row justify-content-md-center">
			<div class="col-sm-4">
				<button id="cadastrar" disabled=true onclick="validate()" class="btn btn-primary">Cadastrar</button>
				<a href="./login.jsp" class="btn btn-info">Voltar</a>
			</div>
		</div>

	</div>

</body>
</html>
