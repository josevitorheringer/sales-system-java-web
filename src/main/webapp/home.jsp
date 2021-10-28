<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Pedido"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script></script>
</head>
<style>
main {
	width: 40%;
	margin: 0 auto;
	margin-top: 100px
}
.pedido{
	color: black;
}
</style>
<body>
	<%
		ArrayList<Pedido> listaPedidos = (ArrayList<Pedido>) request.getAttribute("listaPedidos");
	%>

	<div class="d-flex justify-content-between">
		<div class="p-6">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="cadastrar_produto.jsp">Cadastrar novo produto</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./listar_produtos.jsp">Comprar produto</a></li>
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

	<main>
		<div class="" id="">
		 	<%for (int i = 0; i < listaPedidos.size(); i++) {%>
				<div>
				
					<ul class="nav">
						<li class="nav-item"><a class="nav-link pedido" href="<%out.println("listarPedido?id="+listaPedidos.get(i).getId());%>">Nº pedido: <%out.println(listaPedidos.get(i).getId()); %> Data: <%out.println(listaPedidos.get(i).getData()); %></a></li>
					</ul>
				</div>
			<%}%>
		</div>
	</main>


</body>
</html>