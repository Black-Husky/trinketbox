<%@ include file="../WEB-INF/includes.jsp" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<h3>
				<center>Bem vindo(a)</center>
			</h3>
			<br>
			<div class="well center-block" style="max-width: 300px;">
				<a href="student_list.html" class="btn btn-primary btn-lg btn-block">Listagem
					de usuário </a> <a href="exercise_list.html" class="btn btn-success btn-lg btn-block">Listagem
					de atividades </a> <a href="login.html"
					class="btn btn-warning btn-lg btn-block">Login</a> <a
					href="student_form.html" class="btn btn-danger btn-lg btn-block">Cadastro</a>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>