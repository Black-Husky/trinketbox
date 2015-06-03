<%@ include file="../WEB-INF/includes.jsp"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="row text-center ">
				<div class="col-md-12">
					<c:choose>
						<c:when test="${exercise.id == null}">
							<h2>Cadastro de atividades</h2>

							<h5>( Registro de atividades )</h5>
						</c:when>
						<c:otherwise>
							<h2>Edição de atividade</h2>

							<h5>( Editando a atividade : # ${id})</h5>
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
							<strong> Entre Com os Dados </strong>
						</div>
						<div class="panel-body">
							<c:choose>
								<c:when test='${id == null}'>
									<c:url var="addUrl" value="new_exercise.html" />
								</c:when>
								<c:otherwise>
									<c:url var="addUrl" value="update_exercise.html?id=${id}" />
								</c:otherwise>
							</c:choose>
							<form:form id="form" method="post" action="${addUrl}"
								modelAttribute="exercise">
								<fieldset>
									<c:choose>
										<c:when test="${id == null}">
											<div
												class="form-group input-group <c:if test='${owner_error != null}'>has-error has-feedback</c:if><form:errors path='ownerId'>has-error has-feedback</form:errors> ">
												<form:errors path="ownerId" cssClass="control-label" />
												<c:if test="${owner_error != null}">
													<span class="control-label">${owner_error}</span>
												</c:if>
												<div class="input-group">
													<span class="input-group-addon">Id do Dono</span>
													<form:input path="ownerId" size="40"
														cssClass="form-control" placeholder="Id do Dono" />
													<form:errors path="ownerId">
														<span
															class="glyphicon glyphicon-remove form-control-feedback"
															aria-hidden="true"></span>
													</form:errors>
												</div>
												<form:errors path="ownerId" cssClass="sr-only" />
											</div>
										</c:when>
										<c:otherwise>
											<h5>
												Id do dono do Arquivo :
												${exercise.ownerId}
												(Não é possível Alterar por questões de segurança.)
												<form:hidden path="ownerId" />
											</h5>
										</c:otherwise>
									</c:choose>
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
										class="form-group input-group <form:errors path='subject'>has-error has-feedback</form:errors> ">

										<form:errors path="subject" cssClass="control-label" />
										<div class="input-group">
											<span class="input-group-addon">Assunto</span>
											<form:input path="subject" size="40" cssClass="form-control"
												placeholder="Assunto" />
											<form:errors path="subject">
												<span
													class="glyphicon glyphicon-remove form-control-feedback"
													aria-hidden="true"></span>
											</form:errors>
										</div>
										<form:errors path="subject" cssClass="sr-only" />
									</div>
									<c:choose>
										<c:when test="${id == null}">
											<div
												class="form-group input-group <form:errors path='path'>has-error has-feedback</form:errors>">
												<form:errors path="path" cssClass="control-label" />
												<input type="file" class="form-control"
													placeholder="Arquivo" id="atividadearquivo" name="path" />
											</div>
										</c:when>
										<c:otherwise>
											<h5>
												Caminho Atual do Arquivo :
												${exercise.path}
												(Não é possível Alterar por questões de segurança.)
												<form:hidden path="path" />
											</h5>
										</c:otherwise>
									</c:choose>
								</fieldset>
								<input type="submit" value="Cadastrar"
									class="btn btn-success btn-block" />
							</form:form>

							<%-- 							<form role="form" method="post"
								action="							<c:choose>
    <c:when test="${exercise.id == null}">new_exercise.html</c:when>
    <c:otherwise>update_exercise.html?id=${exercise.id}</c:otherwise>
</c:choose>">
								<br />
								<c:choose>
									<c:when test="${exercise.id == null}">
										<div class="form-group input-group">
											<input type="text" size="80" class="form-control"
												placeholder="Id do proprietário" id="idproprietario"
												name="ownerId" value="${exercise.ownerId}" />
										</div>
									</c:when>
									<c:otherwise>
										<h5>Id do dono do Arquivo : ${exercise.ownerId} (Não é possível
											Alterar por questões de segurança.)
											<input type="hidden" value="${exercise.ownerId}" name="ownerId" /></h5>
									</c:otherwise>
								</c:choose>


								<div class="form-group input-group">
									<input type="text" size="80" class="form-control"
										placeholder="Nome" id="atividadenome" name="name"
										value="${exercise.name}" />
								</div>

								<div class="form-group input-group">
									<input type="text" size="80" class="form-control"
										placeholder="Assunto" id="atividadeassunto" name="subject"
										value="${exercise.subject}" />
								</div>
								<c:choose>
									<c:when test="${exercise.id == null}">
										<div class="form-group input-group">
											<input type="file" class="form-control" placeholder="Arquivo"
												id="atividadearquivo" name="path" />
										</div>
									</c:when>
									<c:otherwise>
										<h5>Caminho Atual do Arquivo : ${exercise.path} (Não é
											possível Alterar por questões de segurança.)</h5>
									</c:otherwise>
								</c:choose>
								<br /> <input type="submit" value="Cadastrar"
									class="btn btn-success btn-block" />
							</form>
 --%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>