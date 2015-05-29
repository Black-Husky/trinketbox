<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.trinketBox.exercise.*"%>
<jsp:useBean id="exercise" type="com.trinketBox.exercise.Exercise"
	scope="request" />

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

							<h5>( Editando a atividade : # ${exercise.id})</h5>
						</c:otherwise>
					</c:choose>
					<br />
				</div>
			</div>
			<div class="row ">
				<div
					class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong> Entre Com os Dados </strong>
						</div>
						<div class="panel-body">
							<form role="form" method="post"
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
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>