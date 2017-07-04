<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificação de Turma</title>

	<link href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet" />
	<link href="<c:url value='/resources/css/usuarios.css' />" rel="stylesheet" />

</head>

<body>
    
	<div class="generic-container">
		<div class="well lead">Modificar Turma</div>
		<form:form method="POST" modelAttribute="turma" class="form-horizontal">
			<%-- <form:input type="hidden" path="id" id="id" />  --%>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="codigo">Codigo</label>
					<div class="col-md-7">
						<form:input type="text" path="codigo" id="codigo"
							class="form-control input-sm" disabled="true"/>
						
					</div>
				</div>
			</div>

	      <div class="row">
				<div class="form-group col-md-12">
					
					<label class="col-md-3 control-lable" for="disciplina">Disciplina</label>
					<div class="col-md-7">
							<form:input type="text" path="disciplina.nome" id="disciplina"
									class="form-control input-sm" disabled="true" />
					</div>
					<br><br>
					<label class="col-md-3 control-lable" for="novadisciplina">Nova Disciplina</label>
					<div class="col-md-7">
					<form:select path="disciplina" items="${disciplinas}" 
							itemValue="id" itemLabel="nome" class="form-control" />
					</div>
				</div>
			</div> 
			
			<div class="row">
				<div class="form-group col-md-12">
					
					<label class="col-md-3 control-lable" for="professor">Professor</label>
					<div class="col-md-7">
							<form:input type="text" path="professor.nome" id="professor"
									class="form-control input-sm" disabled="true" />
					</div>
					<br><br>
					<label class="col-md-3 control-lable" for="novoProfessor">Novo Professor</label>
					<div class="col-md-7">
					<form:select path="professor" items="${professores}" 
							itemValue="id" itemLabel="nome" class="form-control" />
				    </div>	
				</div>
			</div> 
		
			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Atualizar"
								class="btn btn-primary btn-sm" /> ou <a
								href="<c:url value='/alocacaoHorario/list' />" class="btn btn-danger custom-width">Cancelar</a>
				</div>
			</div>
		</form:form>
	</div>      
	
</body>
</html>