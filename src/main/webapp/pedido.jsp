<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Pedido"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meu pedido</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

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

<% 	Pedido pedido = (Pedido) request.getAttribute("pedido"); %>

	<h3>Produto: <% out.println(pedido.getProduto().getNome()); %></h3>
	<h3>Preço: <% out.println(pedido.getProduto().getCusto()); %></h3>
	<h3>Endereço de entrega: <% out.println(pedido.getUsuario().getEndereco()); %></h3>
	<h3>Remetente: <% out.println(pedido.getUsuario().getNome()); %></h3>
	<h3>Data da compra: <% out.println(pedido.getData()); %></h3>
	<h3>CPF: <% out.println(pedido.getUsuario().getCpf()); %></h3>
	
	
</body>
</html>