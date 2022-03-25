<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<div class="card shadow-lg">
		<div class="card-body">
			<div class="row">
				<div class="col-md-12 col-sm-12 text-center">
					<p class="h4">Relatório exames realizados</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<s:form action="/pesquisarRelatorio.action">
						<div class="row mb-3">
							<label for="dataInicial" class="col-sm-2 col-form-label">Data Inicial: </label>
							<div class="col-sm-10">
								<s:textfield cssClass="form-control" type="date" id="dataIni" name="dataInicial" />
							</div>
						</div>
						<div class="row mb-3">
							<label for="dataFinal" class="col-sm-2 col-form-label">Data Final: </label>
							<div class="col-sm-10">
								<s:textfield cssClass="form-control" type="date" id="dataFim" name="dataFinal" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 col-sm-12">
								<button type="submit" class="btn btn-primary">Pesquisar</button>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 col-sm-12 text-center">
								<p class="h4"></p>
							</div>
						</div>
					</s:form>
				</div>
			</div>
			<div class="clearfix"></div>
			<s:if test="relatorio">
				<div class="row">
					<div class="col-md-12 col-sm-12">
						<div class="card">
							<div class="card-header">Resultado</div>
							<div class="card-body">
								<table id="example" class="table table-striped" style="width: 100%">
									<thead>
										<tr>
											<th>ID</th>
											<th>Exame</th>
											<th>Funcionário</th>
											<th>Data</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="funcionariosExames">
											<tr>
												<td>${rowid}</td>
												<td>${exame.rowid}- ${exame.nome}</td>
												<td>${funcionario.rowid}- ${funcionario.nome}</td>
												<td>${dateExame}</td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</s:if>
		</div>
	</div>
</div>
<content tag="script"> <script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#example')
								.DataTable(
										{
											"language" : {
												"sEmptyTable" : "Nenhum registro encontrado",
												"sInfo" : "Mostrando de _START_ até _END_ de _TOTAL_ registros",
												"sInfoEmpty" : "Mostrando 0 até 0 de 0 registros",
												"sInfoFiltered" : "(Filtrados de _MAX_ registros)",
												"sInfoPostFix" : "",
												"sInfoThousands" : ".",
												"sLengthMenu" : "_MENU_ resultados por página",
												"sLoadingRecords" : "Carregando...",
												"sProcessing" : "Processando...",
												"sZeroRecords" : "Nenhum registro encontrado",
												"sSearch" : "Pesquisar",
												"oPaginate" : {
													"sNext" : "Próximo",
													"sPrevious" : "Anterior",
													"sFirst" : "Primeiro",
													"sLast" : "Último"
												},
												"oAria" : {
													"sSortAscending" : ": Ordenar colunas de forma ascendente",
													"sSortDescending" : ": Ordenar colunas de forma descendente"
												}
											}
										});
					});
</script></content>