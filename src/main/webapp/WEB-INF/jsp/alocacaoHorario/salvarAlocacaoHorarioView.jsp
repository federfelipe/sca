<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alocação Horário</title>
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
			rel="stylesheet">
		<link href="<c:url value='/resources/bootstrap/css/bootstrap.css' />"
			rel="stylesheet" />
		<link href="<c:url value='/resources/css/usuarios.css' />"
			rel="stylesheet" />
		<link rel="stylesheet"
			href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script
			src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			function voltar()
			{
				window.location = "${pageContext.request.contextPath}/menuPrincipalView";
			}			
		</script>
	</head>
	
	<body>
		<center>
			<h1>Grade de Horários salva com sucesso!</h1>
				<div class="row botoes">
					<button type="button" class="btn btn-info btnVoltar" onclick="voltar()">Voltar</button>
				</div>
		</center>
	</body>
</html>