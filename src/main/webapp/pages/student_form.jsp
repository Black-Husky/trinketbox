<%@ include file="../WEB-INF/includes.jsp"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="row text-center ">
				<div class="col-md-12">
					<c:choose>
						<c:when test="${id == null}">
							<h2>Cadastro de alunos</h2>

							<h5>( Registro de alunos )</h5>
						</c:when>
						<c:otherwise>
							<h2>Edição de aluno</h2>

							<h5>( Editando o aluno : # ${id})</h5>
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
							<c:choose>
								<c:when test='${id == null}'>
									<c:url var="addUrl" value="new_student.html" />
								</c:when>
								<c:otherwise>
									<c:url var="addUrl" value="update_student.html?id=${id}" />
								</c:otherwise>
							</c:choose>
							<form:form id="form" method="post" action="${addUrl}"
								modelAttribute="student">
								<fieldset>
									<div
										class="form-group input-group <form:errors path='name'>has-error has-feedback</form:errors> ">

										<form:errors path="name" cssClass="control-label" />
										<div class="input-group">
											<span class="input-group-addon">Nome</span>
											<form:input path="name" size="40" cssClass="form-control"
												placeholder="Nome" />
											<form:errors path="name">
												<span
													class="glyphicon glyphicon-remove form-control-feedback"
													aria-hidden="true"></span>
											</form:errors>
										</div>
										<form:errors path="name" cssClass="sr-only" />
									</div>
									<div
										class="form-group input-group <form:errors path='age'>has-error has-feedback</form:errors> ">

										<form:errors path="age" cssClass="control-label" />
										<div class="input-group">
											<span class="input-group-addon">Idade</span>
											<form:input path="age" size="40" cssClass="form-control"
												placeholder="Idade" />
											<form:errors path="age">
												<span
													class="glyphicon glyphicon-remove form-control-feedback"
													aria-hidden="true"></span>
											</form:errors>
										</div>
										<form:errors path="age" cssClass="sr-only" />
									</div>
									<div
										class="form-group input-group <form:errors path='educationalInstitution'>has-error has-feedback</form:errors> ">

										<form:errors path="educationalInstitution"
											cssClass="control-label" />
										<div class="input-group">
											<span class="input-group-addon">Instituição
												Educacional</span>
											<form:input path="educationalInstitution" size="40"
												cssClass="form-control"
												placeholder="Instituição Educacional" />
											<form:errors path="educationalInstitution">
												<span
													class="glyphicon glyphicon-remove form-control-feedback"
													aria-hidden="true"></span>
											</form:errors>
										</div>
										<form:errors path="educationalInstitution" cssClass="sr-only" />
									</div>
									<div
										class="form-group input-group <form:errors path='email'>has-error has-feedback</form:errors> ">

										<form:errors path="email" cssClass="control-label" />
										<div class="input-group">
											<span class="input-group-addon">Email</span>
											<form:input path="email" size="40" cssClass="form-control"
												placeholder="Email" />
											<form:errors path="email">
												<span
													class="glyphicon glyphicon-remove form-control-feedback"
													aria-hidden="true"></span>
											</form:errors>
										</div>
										<form:errors path="email" cssClass="sr-only" />
									</div>
									<div
										class="form-group input-group <form:errors path='password'>has-error has-feedback</form:errors> ">

										<form:errors path="password" cssClass="control-label" />
										<div class="input-group">
											<span class="input-group-addon">Senha</span>
											<form:password path="password" size="40"
												cssClass="form-control" placeholder="Senha" />
											<form:errors path="password">
												<span
													class="glyphicon glyphicon-remove form-control-feedback"
													aria-hidden="true"></span>
											</form:errors>
										</div>
										<form:errors path="password" cssClass="sr-only" />
									</div>
								</fieldset>
								<input type="submit" value="Cadastrar"
									class="btn btn-success btn-block" />
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>