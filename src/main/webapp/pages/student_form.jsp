<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.trinketBox.student.*"%>

<jsp:useBean id="student" type="com.trinketBox.student.Student"
	scope="request" />

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="row text-center ">
				<div class="col-md-12">
					<c:choose>
						<c:when test="${student.id == null}">
							<h2>Cadastro de alunos</h2>

							<h5>( Registro de alunos )</h5>
						</c:when>
						<c:otherwise>
							<h2>Edição de aluno</h2>

							<h5>( Editando o aluno : # ${student.id})</h5>
						</c:otherwise>
					</c:choose>
					<br />
				</div>
			</div>
			<div class="row ">
				<div
					class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong> Entre Com Seus Dados </strong>
						</div>
						<div class="panel-body">
							<form role="form" method="post"
								action="
							<c:choose>
    <c:when test="${student.id == null}">new_student.html</c:when>
    <c:otherwise>update_student.html?id=${student.id}</c:otherwise>
</c:choose>">
								<br />
								<div class="form-group input-group">
									<input type="text" size="40" class="form-control"
										placeholder="Seu Nome" id="nomealuno" name="name"
										value="${student.name}" />
								</div>

								<div class="form-group input-group">
									<input type="text" size="40" class="form-control"
										placeholder="Escola/Faculdade" id="escolaaluno"
										name="educationalInstitution"
										value="${student.educationalInstitution}" />
								</div>

								<div class="form-group input-group">
									<input type="text" size="40" class="form-control"
										placeholder="Idade" id="idadealuno" name="age"
										value="${student.age == '0' ? '' : student.age}" />
								</div>
								<div class="form-group input-group">
									<input type="text" size="40" class="form-control"
										placeholder=Email " id="emailaluno" name="email"
										value="${student.email}" />
								</div>
								<div class="form-group input-group">
									<input type="password" size="40" class="form-control"
										placeholder="Senha" id="senhaaluno" name="password" value="" />
								</div>
								<input type="submit" value="Cadastrar"
									class="btn btn-success btn-block" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>