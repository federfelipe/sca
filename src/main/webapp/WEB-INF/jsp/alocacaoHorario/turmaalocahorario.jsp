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
		<div class="well lead">Formulário de Alocação de Horário</div>
		<form:form method="POST" modelAttribute="turma" class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="nome">Codigo</label>
					<div class="col-md-7">
						<form:input type="text" path="codigo" id="codigo"
							class="form-control input-sm"/>
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
									class="form-control input-sm" />
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
							class="form-control input-sm" />
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

			<%-- <div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="userProfiles">Perfis</label>
					<div class="col-md-7">
						<form:select path="userProfiles" items="${roles}" multiple="true"
							itemValue="id" itemLabel="type" class="form-control" />
						<div class="has-error">
							<form:errors path="userProfiles" class="help-inline" />
						</div>
					</div>
				</div>
			</div> --%>

			<div class="row">
				<%-- <div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Atualizar"
								class="btn btn-primary btn-sm" /> ou <a
								href="<c:url value='/alocacaoHorario/list' />">CancelarF</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Registrar"
								class="btn btn-danger" /> ou <a
								href="<c:url value=' />">CancelarF</a>
						</c:otherwise>
					</c:choose> --%>
						<td><a href="<c:url value='/alocacaoHorario/edit-turma-${turma.id}' />"
							class="btn btn-success custom-width">Atualizar</a></td>	
							<td><a href="<c:url value='/alocacaoHorario/list' />"
								class="btn btn-danger custom-width">Cancelar</a></td>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>