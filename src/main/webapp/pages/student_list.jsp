<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.trinketBox.student.*"%>
<jsp:useBean id="studentDao" type="com.trinketBox.student.StudentDao" scope="request" />

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="col-md-12 column">
				<h3>
					<center>Listagem de alunos</center>
				</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Nome</th>
							<th>Escola/Faculdade</th>
							<th>Idade</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${studentDao.getAll()}" var="student">
						<tr>
							<td>${student.id}</td>
							<td>${student.name}</td>
							<td>${student.educationalInstitution}</td>
							<td>${student.age}</td>
							<td>${student.email}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>