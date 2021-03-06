<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container shadow-lg">
	<s:form action="/salvarCadastro.action">
		<div class="card mt-5">
			<div class="card-header">
				<div class="row">
					<div class="col-sm-5">
						<s:url action="todosCadastro" var="todos" />
						<a href="${todos}" class="btn btn-success">Funcion?rio Exames</a>
					</div>
					<div class="col-sm">
						<h5 class="card-title">Atualizar Exame</h5>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div class="mb-3 row">
					<label for="codigo" class="col-sm-2 col-form-label">C?digo:</label>
					<div class="col-sm-10">
						<s:textfield cssClass="form-control" id="codigo" name="funcionarioExameVo.rowid" readonly="true" />
					</div>
				</div>
				<div class="mb-3 row">
					<label for="exame" class="col-sm-2 col-form-label">Exame:</label>
					<div class="col-sm-10">
						<s:textfield cssClass="form-control" id="codigo" name="funcionarioExameVo.exame.nome" readonly="true" />
						<s:hidden name="funcionarioExameVo.exame.rowid"/>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="exame" class="col-sm-2 col-form-label">Funcionario:</label>
					<div class="col-sm-10">
						<s:textfield cssClass="form-control" id="codigo" name="funcionarioExameVo.funcionario.nome" readonly="true" />
						<s:hidden name="funcionarioExameVo.funcionario.rowid"/>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="exame" class="col-sm-2 col-form-label">Data Exame:</label>
					<div class="col-sm-10">
						<s:textfield cssClass="form-control" type="date" id="data"  name="funcionarioExameVo.dateExame" />
					</div>
				</div>
			</div>
			<div class="card-footer">
				<div class="form-row">
					<button class="btn btn-primary col-sm-4 offset-sm-1">Atualizar</button>
				</div>
			</div>
		</div>
	</s:form>
</div>
