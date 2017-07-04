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
		<div class="well lead">Alocar Horário</div>
		<form:form method="POST" modelAttribute="turma" class="form-horizontal">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="nome">Codigo</label>
					<div class="col-md-7">
						<form:input type="text" path="codigo" id="codigo"
							class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="disciplina">Disciplina</label>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="disciplina.nome" id="disciplina"
									class="form-control input-sm" disabled="true" />
							</c:when>
							<c:otherwise>
								<form:input type="text" path="disciplina" id="disciplina"
									class="form-control input-sm" disabled="true" />
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="professor.nome">Professor</label>
					<div class="col-md-7">
						<form:input type="text" path="professor.nome" id="professor.nome"
							class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Dia: Inicio - Fim</label>
			<div class="col-md-7">
			<select>
				<c:forEach var="hora" items="${horas}">
					<option>${hora.dia}: ${hora.inicio} - ${hora.fim}</option>
     			</c:forEach>
			</select>
			    </div>
			  </div>
			</div>

			<div class="row">
				<a href="" class="btn btn-success custom-width">Atualizar</a>	
				<a href="<c:url value='/alocacaoHorario/list' />" class="btn btn-danger custom-width">Cancelar</a>
			</div>
		  </form:form>
	</div>
</body>
</html>