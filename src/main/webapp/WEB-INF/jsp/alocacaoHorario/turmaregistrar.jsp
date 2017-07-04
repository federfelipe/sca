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
       <div>
			<h1>Registrar Turma</h1>
        
        	<form:form method="POST" modelAttribute="turma" class="form-horizontal">
			  
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="codigo">Codigo</label>
					<div class="col-md-7">
						<form:select path="codigo" items="${turmas}" 
							itemValue="codigo" itemLabel="codigo" class="form-control" />
						
					</div>
				</div>
			</div>

	     <%--  <div class="row">
				<div class="form-group col-md-12">
					
					<label class="col-md-3 control-lable" for="periodo">Periodo</label>
				   <div class="col-md-7">
					<form:select path="periodo" items="${turmas}" 
							itemValue="periodo" itemLabel="periodo" class="form-control" />
				  </div>
			</div> 
		  </div> --%>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="disciplina">Disciplina</label>
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
						<form:select path="professor" items="${professores}" 
							itemValue="id" itemLabel="nome" class="form-control" />						
					</div>
				</div>
			</div>
					
			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Atualizar"
								class="btn btn-primary btn-sm" /> ou <a
								href="<c:url value='/alocacaoHorario/list' />">Cancelar</a>
				</div>
			</div>
		</form:form>
                     
	</div>
</body>
</html>