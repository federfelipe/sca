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
			</div>
		   <div class="panel panel-primary">
  			  <div class="panel-heading lead">Turmas Cadastradas</div>
  			      <h4>Número de turmas cadastradas : ${countTurmas}</h4> 
				   		   	 	   	          
		
  			  <div class="btn-group" role="group" aria-label="...">
  			       <a href="${pageContext.request.contextPath}/menuPrincipalView"><button type="button" class="btn btn-default" >Voltar</button></a>
				   <a href=""><button type="button" class="btn btn-default">Nova Turma</button></a>
				   </div> 	<%-- <c:url value='/alocacaoHorario/novaturma' /> --%>		  
		  </div>
		  
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
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
							<th>${turma.id}</th>
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
	</div>
</body>
</html>