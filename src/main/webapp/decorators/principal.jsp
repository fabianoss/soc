<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
response.setHeader("Cache-control", "no-cache, no-store");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "-1");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
/* Show it's not fixed to the top */
body {
	min-height: 75rem;
}
</style>
<decorator:getProperty property="page.style" />
<decorator:head />
</head>
<body class="bg-secondary">
	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<div class="container-fluid">
			<a class="navbar-brand" href="/avaliacao/index.action">SOC</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-bs-toggle="dropdown" aria-expanded="false">Exames</a>
						<ul class="dropdown-menu" aria-labelledby="dropdown01">
							<li>
								<a class="dropdown-item" href="/avaliacao/todosExames.action">Exames</a>
							</li>
							<li>
								<a class="dropdown-item" href="/avaliacao/todosCadastro.action">Exame Funcionário</a>
							</li>
							
						</ul>
					</li>					
					<li class="nav-item">
						<a class="nav-link" href="/avaliacao/todosFuncionarios.action">Funcionários</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/avaliacao/indexRelatorio.action">Relatório</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<decorator:body />
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
	<decorator:getProperty property="page.script" />
</body>
</html>
