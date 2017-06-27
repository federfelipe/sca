<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCA - Lista de Turmas</title>

	<link href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet" />
	<link href="<c:url value='/resources/css/usuarios.css' />" rel="stylesheet" />

</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Lista de Turmas</span>
			</div>
			<div class="well">
			<a href="<c:url value='/alocacaoHorario/newturma' />">Adicionar Nova Turma</a>
		   </div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Disciplina</th>
						<th>Professor</th>
						<th width="100"></th>
						<th width="100"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${turmas}" var="turma">
						<tr>
							<td>${turma.codigo}</td>
							<td>${turma.disciplina.nome}</td>
							<td>${turma.professor.nome}</td>
							<td><a href="<c:url value='/alocacaoHorario/edit-turma-${turma.id}' />"
								class="btn btn-warning custom-width">editar</a></td>
							<td><a href="<c:url value='/alocacaoHorario/edit-turmaAlocaHorario-${turma.id}' />"
								class="btn btn-success custom-width">alocar horarios</a></td>	
							<td><a href="<c:url value='/alocacaoHorario/delete-turma-${turma.id}' />"
								class="btn btn-danger custom-width">excluir</a></td>
																																
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="well">
			<a href="<c:url value='/usuarios/newuser' />">Adicionar Novo Usuário</a>
		</div>
	</div>
</body>
</html>
