<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Usuario"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seu perfil</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<%
	Usuario u = (Usuario) request.getAttribute("usuario");
	%>

	<div class="d-flex justify-content-between">
		<div class="p-6">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
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
				<li class="nav-item"><a class="nav-link" href="profile">Perfil</a></li>
				<li class="nav-item"><a href="./logout" class="btn btn-danger">Encerrar
						sessão</a></li>
			</ul>

		</div>
	</div>
	<h1>
		Nome:
		<%out.println(u.getNome());%>
	</h1>
	<h1>
		CPF:
		<%out.println(u.getCpf());%>
	</h1>
	<h1>
		Endereço:
		<%out.println(u.getEndereco());%>
	</h1>
	
</body>
</html>