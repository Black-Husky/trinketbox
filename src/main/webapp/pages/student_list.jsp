<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.trinketBox.student.*"%>
<jsp:useBean id="studentDao" type="com.trinketBox.student.StudentDao"
	scope="request" />

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="col-md-12 column">
				<h3>
					<c:set var="studentList" scope="session"
						value="${studentDao.getAll()}" />
					<center>Listagem de alunos <c:if test="${studentList.size() == 0}">- Não há alunos</c:if> </center>
					
				</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Ações</th>
							<th>#</th>
							<th>Nome</th>
							<th>Escola/Faculdade</th>
							<th>Idade</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${studentList}" var="student">
							<tr>
								<td><a type="button" class="btn btn-info" href="student_form.html?id=${student.id}"> <span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</a> <a type="button" class="btn btn-danger"
									href="delete_student.html?id=${student.id}"> <span
										class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</a></td>
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