<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Iniciar sessão</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
	.container{
		margin-top: 15%;
	}
</style>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script>
let searchParams = new URLSearchParams(window.location.search);

if(searchParams.has('error')){
	alert("erro ao efetuar login");
}

</script>
</head>
<body>

<div class="container">
	<form action="logon" method="POST">
		<div class="mb-3 row justify-content-md-center">
			<div class="col-sm-4">
		    	<label for="exampleInputEmail1" class="form-label">Nome de usuário</label>
		    	<input name="login" type="text" class="form-control" id="inputUsername" aria-describedby="emailHelp" placeholder="username">
		    </div>
	  	</div>
	  	<div class="mb-3 row justify-content-md-center">
	  		<div class="col-sm-4">
	  			<label for="exampleInputPassword1" class="form-label">Senha</label>
		   		<input name="senha" type="password" class="form-control" id="inputPassword" placeholder="senha" >
	  		</div>
	 	</div>
	  	<div class="mb-3 row justify-content-md-center">
	  		<div class="col-sm-4">
	 			<button type="submit" class="btn btn-primary">Entrar</button>
	 			<a href="./cadastrar_usuario.jsp" class="btn btn-info">Cadastrar</a>
	  		</div>
	 	</div>

	</form>
</div>

</body>
</html>