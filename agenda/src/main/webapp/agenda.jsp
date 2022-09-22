<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
List<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="./imagens/telefone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao01">Novo Contato</a>
	<a href="report" class="botao02">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (JavaBeans contato : lista) {
			%>
			<tr>
				<td><%=contato.getIdcon()%></td>
				<td><%=contato.getNome()%></td>
				<td><%=contato.getFone()%></td>
				<td><%=contato.getEmail()%></td>
				<td><a href="select?idcont=<%=contato.getIdcon()%>"
					class="botao01">Editar</a> 
					<a href="javascript: confirmar(<%=contato.getIdcon()%>)"
					class="botao02">Excluir</a></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script type="text/javascript" src="./scripts/confirmador.js"></script>
</body>
</html>