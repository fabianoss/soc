<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Login avaliação SOC</title>
<!-- Bootstrap core CSS -->
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

html, body {
	height: 100%;
}

body {
	display: flex;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-floating:focus-within {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body class="text-center">
	<main class="form-signin">
		<s:if test="%{loginError}">
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				<strong>Ops!</strong>
				Usúario ou senha inválidos!
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</s:if>
		<s:form action="login">
			<h1 class="h3 mb-3 fw-normal">Login</h1>
			<div class="form-floating">
				<s:textfield type="text" name="username" class="form-control" id="floatingInput" placeholder="username" />
				<label for="floatingInput">Username</label>
			</div>
			<div class="form-floating">
				<s:password type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password" />
				<label for="floatingPassword">Password</label>
			</div>
			<div class="checkbox mb-3"></div>
			<s:submit class="w-100 btn btn-lg btn-primary" value="Entrar" type="submit" />
		</s:form>
	</main>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/docsearch.js@2/dist/cdn/docsearch.min.js"></script>
	<script src="webjars/bootstrap/5.1.3/js/docs.min.js"></script>
</body>


</html>
