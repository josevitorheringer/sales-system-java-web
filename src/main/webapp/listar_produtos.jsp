<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Procurar produto</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	const requisicao = (function(){
		let produto = $("#formProduto").val();
		$.ajax({
			type: 'POST',
			data: {formProduto: produto},
			url: 'listarProdutos',
			success: function(result){
				$('#resultado').empty();
				var produtos = JSON.parse(result);
				produtos.forEach(function(p, index){
					$('#resultado').append(
					"<tr id=" + p.id + ">" +
						"<td>"+ p.nome +"</td>"+
						"<td> "+ p.custo +"</td>"+
						"<td class=quantidade> "+ p.quantidade + "</td>"+
						"<td>"+
						(p.quantidade > 0 ? "<button class='btn btn-light'> Comprar </button>": '') +
					" </td> </tr>");
				});
			} 
		})		
	});
	


	
	$(document).ready(function(){
		requisicao();
		$("#formProduto").keyup(function(){
			requisicao();
		});
	});

	$(document).on("click","button", function () {
		const id = $(this).closest('tr').attr('id');
	   	window.location.href = "comprarProduto?id=" + id;
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
	
	<input type="text" id="formProduto" autocomplete="off" placeholder="Procure por um produto">
	<table class="table">
		  <thead>
		  	<tr>
			    <th>Nome</th>
			    <th>Custo</th>
			    <th>Quantidade</th>
			</tr>
		  </thead>
		  <tbody id=resultado>
		  </tbody>
	</table>
</body>
</html>