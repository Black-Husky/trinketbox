<%@ include file="../WEB-INF/includes.jsp" %>

<%@page import="com.trinketBox.exercise.*"%>
<jsp:useBean id="exerciseDao" type="com.trinketBox.exercise.ExerciseDao"
	scope="request" />

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="col-md-12 column">
				<h3>
					<c:set var="exerciseList" scope="session"
						value="${exerciseDao.getAll()}" />
					<center>Listagem de Atividades <c:if test="${exerciseList.size() == 0}">- Não há Atividades</c:if> </center>
				</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Ações</th>
							<th>#</th>
							<th>Nome</th>
							<th>Assunto</th>
							<th>Arquivo</th>
							<th>Id do Dono</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${exerciseList}" var="exercise">
							<tr>
								<td><a type="button" class="btn btn-info" href="exercise_form.html?id=${exercise.id}"> <span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</a> <a type="button" class="btn btn-danger"
									href="delete_exercise.html?id=${exercise.id}"> <span
										class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</a></td>
								<td>${exercise.id}</td>
								<td>${exercise.name}</td>
								<td>${exercise.subject}</td>
								<td>${exercise.path}</td>
								<td>${exercise.ownerId}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>