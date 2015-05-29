<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="row text-center ">
				<div class="col-md-12">
					<h2>Cadastro de alunos</h2>

					<h5>( Registro de alunos )</h5>
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
							<form role="form" method="post" action="new_student.html">
								<br />
								<div class="form-group input-group">
									<input type="text" size="40" class="form-control"
										placeholder="Seu Nome" id="nomealuno" name="name" />
								</div>

								<div class="form-group input-group">
									<input type="text" size="40" class="form-control"
										placeholder="Escola/Faculdade" id="escolaaluno"
										name="educationalInstitution" />
								</div>

								<div class="form-group input-group">
									<input type="text" size="40" class="form-control"
										placeholder="Idade" id="idadealuno" name="age" />
								</div>
								<div class="form-group input-group">
									<input type="text" size="40" class="form-control"
										placeholder=Email " id="emailaluno" name="email" />
								</div>
								<div class="form-group input-group">
									<input type="password" size="40" class="form-control"
										placeholder="Senha" id="senhaaluno" name="password" />
								</div>
								<input type="submit" value="Cadastrar" class="btn btn-success btn-block"/>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>