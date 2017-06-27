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
			<h1>Formulário de Registro de Turma</h1>
		 <form:form action="${pageContext.request.contextPath}/alocacaoHorario/felipe"  method="post" modelAttribute="turmaModel">
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
             <table>
                <tr>
                   <td>
                    <form:select path="codigo">
                         <c:forEach var="turma" items="${turmas}">
							<option value="${turma.codigo}">${turma.codigo}</option>
					     </c:forEach>
					</form:select>
                </td> 
                											                
                <td>
                   <form:select path="periodo">
                       <c:forEach var="turma" items="${turmas}">
							<option value="${turma.periodo}">${turma.periodo}</option>
					   </c:forEach>
				   </form:select>   
                </td>
                <td>
					<form:select path="disciplina">
						<c:forEach var="disciplina" items="${disciplinas}">
							<option>${disciplina.nome}</option>
						</c:forEach>
					</form:select>
				</td>
				<td>
					<form:select path="professor">
						<c:forEach var="professor" items="${professores}">
							<option>${professor.pessoa.nome}</option>
						</c:forEach>
					</form:select>
				</td> 
                
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="contactNumber">Contact Number</form:label></td>
                    <td><form:input path="contactNumber"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>                 
	</div>
</body>
</html>