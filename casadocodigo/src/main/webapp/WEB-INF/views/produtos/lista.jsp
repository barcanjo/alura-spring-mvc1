<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produto Ok</title>
</head>
<body>
	<h1>Lita de Produtos</h1>

	<div>${sucesso }</div>
	
	<table>
		<thead>
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Páginas</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td>${produto.titulo }</td>
					<td>${produto.descricao }</td>
					<td>${produto.paginas }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>