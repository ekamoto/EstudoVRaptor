<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Produto</title>
</head>
<body>

	<c:forEach items="${errors }" var="error">
		${error.category } - ${error.message }  
	</c:forEach>

	<table>

		<form action="<c:url value="/produto/adiciona"/>" method="POST">
			<tr>
				<td>Nome:</td>
				<td>
					<input type="text" name="produto.nome" value="${produto.nome }">
				</td>
			</tr>
			<tr>
				<td>Descrição:</td>
				<td>
					<input type="text" name="produto.descricao" value="${produto.descricao }">
				</td>
			</tr>
			<tr>
				<td>Preço:</td>
				<td>
					<input type="text" name="produto.preco" value="${produto.preco }">
				</td>
			</tr>
			<tr>
				<td>Cor:</td>
				<td>
					<input type="text" name="produto.cor" value="${produto.cor }">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="Adicionar">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>