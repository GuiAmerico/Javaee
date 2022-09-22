<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="./imagens/telefone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="idcon" id="caixa03" readonly value="<%out.print(request.getAttribute("idcont"));%>"/></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="caixa01" value="<%out.print(request.getAttribute("nome"));%>"/></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="caixa02" value="<%out.print(request.getAttribute("fone"));%>" /></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="caixa01" value="<%out.print(request.getAttribute("email"));%>" /></td>
			</tr>
		</table>
		<button class="botao01" onclick="validar()">Salvar</button>
	</form>
	<script type="text/javascript" src="./scripts/confirmador.js"></script>
</body>
</html>