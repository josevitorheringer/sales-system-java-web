<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar produto</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
</head>
<style>
	.container{
		margin-top: 5%;
	}
</style>

<script>
function send(){
	document.forms["formProduto"].submit();
}

function validate(){
	let nome = formProduto.nome.value;
	let custo = formProduto.custo.value;
	let quantidade = formProduto.quantidade.value;
	if (nome === ''){
		alert("Nome vazio ou inválido");
		return false
	}else if (isNaN(custo) || custo === '') {
		alert("Custo vazio ou inválido");
		return false
	}else if (isNaN(quantidade) || quantidade =='') {
		alert("Quantidade vazia ou inválida");
		return false
	}else{
		send();
	}
}
</script>
<body>
		<div class="d-flex justify-content-between">
			<div class="p-6">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link"
						href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="cadastrar_produto.jsp">Cadastrar novo produto</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./listar_produtos.jsp">Listar produtos</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./listar_usuarios.jsp">Listar usuários</a></li>
				</ul>
			</div>

			<div class="p-6">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link"
						href="profile">Perfil</a></li>
					<li class="nav-item"><a href="./logout" class="btn btn-danger">Encerrar sessão</a></li>
				</ul>

			</div>
		</div>
		
			<div class="container">
		<div class="mb-3 row justify-content-md-center">
			<div class="col-sm-4">
			<h2>Cadastrar produto</h2>
			</div>
		</div>
		<form name="formProduto" action="insertProduto" method="POST">
		
		<div class="mb-3 row justify-content-md-center">
			<div class="col-sm-4">
		    	<label for="inputName" class="form-label">Nome</label>
		    	<input name="nome" type="text" class="form-control" id="inputName" placeholder="nome">
		    </div>
	  	</div>
		
		<div class="mb-3 row justify-content-md-center">
			<div class="col-sm-4">
		    	<label for="inputCusto" class="form-label">Custo</label>
		    	<input name="custo" type="text" class="form-control" id="inputCusto" placeholder="Preço">
		    </div>
	  	</div>
	  	
	  	<div class="mb-3 row justify-content-md-center">
			<div class="col-sm-4">
		    	<label for="inputQuantidade" class="form-label">Quantidade</label>
		    	<input name="quantidade" type="text" class="form-control" id="inputQuantidade" placeholder="Quantidade">
		    </div>
	  	</div>
	  	</form>
	  	<div class="mb-3 row justify-content-md-center">
	  		<div class="col-sm-4">
	 			<button onclick="validate()" class="btn btn-primary">Inserir</button>
	  		</div>
	 	</div>
		
	</div>
</body>
</html>