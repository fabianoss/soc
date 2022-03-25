<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container shadow-lg">
	<s:form action="/salvarExames.action">
		<div class="card mt-5">
			<div class="card-header">
				<div class="row">
					<div class="col-sm-5">
						<s:url action="todosExames" var="todos" />
						<a href="${todos}" class="btn btn-success">Exames</a>
					</div>
					<div class="col-sm">
						<h5 class="card-title">Atualizar Exame</h5>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div class="row align-items-center">
					<label for="id" class="col-sm-1 col-form-label text-center"> C�digo: </label>
					<div class="col-sm-2">
						<s:textfield cssClass="form-control" id="id" name="exameVo.rowid" readonly="true" />
					</div>
				</div>
				<div class="row align-items-center mt-3">
					<label for="nome" class="col-sm-1 col-form-label text-center"> Nome: </label>
					<div class="col-sm-5">
						<s:textfield cssClass="form-control" id="nome" name="exameVo.nome" />
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
