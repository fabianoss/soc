<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container shadow-lg">
	<s:form action="/novoFuncionarios.action">
		<div class="card mt-5">
			<div class="card-header">
				<div class="row">
					<div class="col-sm-5">
						<s:url action="todosFuncionarios" var="todos" />
						<a href="${todos}" class="btn btn-success">Funcionarios</a>
					</div>
					<div class="col-sm">
						<h5 class="card-title">Novo Funcionário</h5>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div class="row align-items-center">
					<label for="id" class="col-sm-1 col-form-label text-center"> Código: </label>
					<div class="col-sm-2">
						<s:textfield cssClass="form-control" id="id" name="funcionarioVo.rowid" readonly="true" />
					</div>
				</div>
				<div class="row align-items-center mt-3">
					<label for="nome" class="col-sm-1 col-form-label text-center"> Nome: </label>
					<div class="col-sm-5">
						<s:textfield cssClass="form-control" id="nome" name="funcionarioVo.nome" />
					</div>
				</div>
			</div>
			<div class="card-footer">
				<div class="form-row">
					<button class="btn btn-primary col-sm-4 offset-sm-1">Salvar</button>
					<button type="reset" class="btn btn-secondary col-sm-4 offset-sm-2">Limpar Formulario</button>
				</div>
			</div>
		</div>
	</s:form>
</div>
