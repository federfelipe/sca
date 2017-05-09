<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Alocação Horário</title>
	
		<link
			href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
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
	</head>
	
	<body>
		<h1>Agora é só escrever a página aqui :)</h1>
		<div class="tabela">
			<table id="tabelaHorario">
				<thead>
					<tr>
						<td>Período da Disciplina</td>
						<td>Cód. Turma</td>
						<td>Cód. Disciplina</td>
						<td>Nome Disciplina</td>
						<td>Professor</td>
						<td>Qtd. Vagas</td>
						<td>Dia da Semana</td>
						<td>Hora de Início</td>
						<td>Hora de Término</td>
						<td>Local</td>
						<td>Grade do Curso</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>3</td>
						<td>620009</td>
						<td>GTSI1433</td>
						<td>Programação Orientada a Objetos</td>
						<td>Gustavo Guedes</td>
						<td>25</td>
						<td>QUA</td>
						<td>18:20</td>
						<td>21:40</td>
						<td>Pav01Lab01</td>
						<td>2014-1</td>
					</tr>
					<tr>
						<td>2</td>
						<td>690020</td>
						<td>GTSI1422</td>
						<td>Estrutura de Dados</td>
						<td>Myrna Amorim</td>
						<td>25</td>
						<td>QUA</td>
						<td>18:20</td>
						<td>21:40</td>
						<td>H-101</td>
						<td>2014-1</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="botoes">
			<input id="btnAdicionar" type="button" value="Adicionar">
			<input id="btnSalvar" type="button" value="Salvar Grade">
			<input id="btnGradesAnteriores" type="button" value="Grades Anteriores">
			<input id="btnVoltar" type="button" value="Voltar">
		</div>
	</body>
	
</html>