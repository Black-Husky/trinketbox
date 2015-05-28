<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="row text-center ">
				<div class="col-md-12">
					<h2>Cadastro de atividades</h2>

					<h5>( Registro de Atividades )</h5>
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
							<form role="form" method="post" action="new_exercise.html">
								<br />
								<div class="form-group input-group">
									<input type="text" size="80" class="form-control"
										placeholder="Id do proprietário" id="idproprietario" name="ownerId" />
								</div>
								
								<div class="form-group input-group">
									<input type="text" size="80" class="form-control"
										placeholder="Nome" id="atividadenome" name="name" />
								</div>

								<div class="form-group input-group">
									<input type="text" size="80" class="form-control"
										placeholder="Assunto" id="atividadeassunto" name="subject" />
								</div>

								<div class="form-group input-group">
									<input type="file" class="form-control" placeholder="Arquivo"
										id="atividadearquivo" name="path" />
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