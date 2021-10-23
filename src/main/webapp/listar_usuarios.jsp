
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar usuários</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">

	const requisicao = (function() {
		let cliente = $("#procurarCliente").val();
		$.ajax({
			type : 'POST',
			data : {
				formCliente : cliente
			},
			url : 'listarUsuarios',
			success : function(result) {
				$('#resultado').empty();
				var clientes = JSON.parse(result);
				clientes.forEach(function(p, index) {
					$('#resultado').append(
							"<tr> <td>" + p.nome + "</td><td> " + p.endereco
									+ "</td><td> " + p.cpf + "</td><td>"
									+ p.login +
									"</td></tr>");
				});
			}
		})
	});
	

	$(document).ready(function() {
		requisicao();
		$("#procurarCliente").keyup(function() {
			requisicao();
		});
	});
	
</script>

</head>
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
	
	<input type="text" id="procurarCliente" autocomplete="off"
		placeholder="Insira o Cliente">

	<table class="table">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Endereco</th>
				<th>CPF</th>
				<th>Nome de usuário</th>
			</tr>
		</thead>
		<tbody id=resultado>
		</tbody>
	</table>
</body>
</html>
