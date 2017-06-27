<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			<h1>Criação de Turma</h1>
			<form:form action="${pageContext.request.contextPath}/alocacaoHorario/salvaGrade" method="post" modelAttribute="turma">
				<div class="tabela">
					<table>
						<thead>
							<tr>
								<td>Código Turma</td>
								<td>Nome da Disciplina</td>
								<td>Professor</td>
								<td>Dia da Semana</td>
								
							</tr>
						</thead>
						<tbody>
							<%-- <%for(int i = 0; i < 3; i++){%> --%>
							<tr>
								<td>
									<select>
										<c:forEach var="turma" items="${turmas}">
											<option value="${turma.codigo}">${turma.codigo}</option>
										</c:forEach> 
									</select>
								</td>
								<td>
									<select>
										<c:forEach var="disciplina" items="${disciplinas}">
											<option>${disciplina.nome}</option>
										</c:forEach>
									</select>
								</td>
								<td>
									<select>
										<c:forEach var="professor" items="${professores}">
											<option>${professor.pessoa.nome}</option>
										</c:forEach>
									</select>
								</td> 
								
								<%-- <td>
									<select>
										<c:forEach var="dia" items="${diasSemana}">
											<option>${dia}</option>
										</c:forEach>
									</select>
								</td>
								<td>
									<select>
										<c:forEach var="hora" items="${horas}">
											<option>${hora.inicio}</option>
										</c:forEach>
									</select>
								</td>
								<td>
									<select>
										<c:forEach var="hora" items="${horas}">
											<option>${hora.fim}</option>
										</c:forEach>
									</select>
								</td> --%>
								
								
								<td>
									<select>
										<c:forEach var="hora" items="${horas}">
											<option>${hora.dia}: ${hora.inicio} - ${hora.fim}</option>
										</c:forEach>
									</select>
								</td>
								<%-- <td>
									<select>
										<c:forEach var="localAula" items="${locaisAula}">
											<option>${localAula.descricao}</option>
										</c:forEach>
									</select>
								</td>  --%>
					
							</tr> 



							<%-- <%}%> --%>
						</tbody>
					</table>
					
											
				</div>

				<br/>
	
				<div class="row botoes">
					<input type="submit" class="btn btn-success btnSalvar" value="Salvar" />
					<button type="button" class="btn btn-info btnVoltar" onclick="voltar()">Voltar</button>
				</div>
			</form:form>
		</center>
	</body>
</html>


