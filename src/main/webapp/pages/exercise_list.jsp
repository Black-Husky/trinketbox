<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.trinketBox.exercise.*"%>
<jsp:useBean id="exerciseDao" type="com.trinketBox.exercise.ExerciseDao" scope="request" />

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="col-md-12 column">
				<h3>
					<center>Listagem de atividades</center>
				</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Nome</th>
							<th>Assunto</th>
							<th>Arquivo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${exerciseDao.getAll()}" var="exercise">
						<tr>
							<td>${exercise.id}</td>
							<td>${exercise.name}</td>
							<td>${exercise.subject}</td>
							<td>${exercise.path}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>