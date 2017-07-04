<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário de Registro de Usuário</title>

	<link href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet" />
	<link href="<c:url value='/resources/css/usuarios.css' />" rel="stylesheet" />

</head>

<body>

   <div class="generic-container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
			</div>
		   <div class="panel panel-primary">
  			  <div class="panel-heading lead">Turmas com Horários Alocados</div>
  		  </div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id Turma</th>
						<th>Código Turma</th>
						<th>Disciplina</th>
						<th>Professor</th>
						<th>Dia</th>
						<th>Inicio</th>
						<th>Fim</th>
						<th width="100"></th>
						<th width="100"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${alocacaoHorario}" var="alocacaoHorario">
						<tr>
							<td>${alocacaoHorario.turma.id}</td>
							<td>${alocacaoHorario.turma.codigo}</td>
							<td>${alocacaoHorario.turma.disciplina.nome}</td>
							<td>${alocacaoHorario.turma.professor.nome}</td>
							<td>${alocacaoHorario.itemHorario.dia}</td>
							<td>${alocacaoHorario.itemHorario.inicio}</td>
							<td>${alocacaoHorario.itemHorario.fim}</td>
							<%-- <td><a href="<c:url value='/alocacaoHorario/edit-turma-${turma.id}' />"
								class="btn btn-warning custom-width">editar</a></td>
							<td><a href="<c:url value='/alocacaoHorario/edit-turmaAlocaHorario-${turma.id}' />"
								class="btn btn-success custom-width">alocar horarios</a></td>	 --%>
							<td><a href="<c:url value='/alocacaoHorario/delete-alocacaoHorario-${alocacaoHorario.id}' />"
								class="btn btn-danger custom-width">excluir</a></td>
																															
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="well">
			<a href="${pageContext.request.contextPath}/menuPrincipalView"><button type="button" class="btn btn-default" >Voltar</button></a>
		</div>
	</div> 	
</body>
</html>