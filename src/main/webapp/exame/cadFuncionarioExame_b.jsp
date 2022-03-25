<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container shadow-lg">
	<div class="row mt-5 mb-2">
		<div class="col-sm p-0">
			<s:form action="/filtrarCadastro.action">
				<div class="input-group">
					<span class="input-group-text">
						<strong>
							<s:text name="label.buscar.por" />
						</strong>
					</span>
					<s:select cssClass="form-select" 
						name="filtrar.opcoesCombo" 
						list="listaOpcoesCombo" headerKey="" 
						headerValue="Escolha..." 
						listKey="%{codigo}" 
						listValueKey="%{descricao}" 
						value="filtrar.opcoesCombo.codigo" id="opcoesFiltro"/>
					<s:textfield cssClass="form-control" id="nomeText" type="" name="filtrar.valorBusca" />					
					<button class="btn btn-primary" type="submit">
						<s:text name="label.pesquisar" />
					</button>
				</div>
			</s:form>
		</div>
	</div>
	<div class="row">
		<table class="table table-light table-striped align-middle">
			<thead>
				<tr>
					<th>
						<s:text name="label.id" />
					</th>					
					<th class="text-end mt-5">
						<s:text name="label.nomeExame" />
					</th>
					<th class="text-end mt-5">
						<s:text name="label.nomeFuncionario" />
					</th>
					<th class="text-end mt-5">
						<s:text name="label.date" />
					</th>
					<th class="text-end mt-5">
						<s:text name="label.acao" />
					</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="funcionarioExames">
					<tr>
						<td class="text-end mt-5">${rowid}</td>
						<td class="text-end mt-5">${exame.nome}</td>
						<td class="text-end mt-5">${funcionario.nome}</td>						
						<td class="text-end mt-5">${dateExame}</td>
						<td class="text-end">
							<s:url action="editarCadastro" var="editar">
								<s:param name="funcionarioExameVo.rowid" value="rowid"></s:param>
							</s:url>
							<a href="${editar}" class="btn btn-warning text-white">
								<s:text name="label.editar" />
							</a>
							<a href="#" class="btn btn-danger" data-bs-toggle="modal" data-val="${rowid}" data-bs-target="#confirmarExclusao">
								<s:text name="label.excluir" />
							</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot class="table-secondary">
				<tr>
					<td colspan="5">
						<s:url action="novoCadastro" var="novo" />
						<a href="${novo}" class="btn btn-success">
							<s:text name="label.novo" />
						</a>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	<div class="row"></div>
</div>
<div class="modal fade" id="confirmarExclusao" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">
					<s:text name="label.modal.titulo" />
				</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<span>
					<s:text name="label.modal.corpo" />
				</span>
			</div>
			<div class="modal-footer">
				<a class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">
					<s:text name="label.nao" />
				</a>
				<a id="urlExcluir" href="#" class="btn btn-primary">
					<s:text name="label.sim" />
				</a>
			</div>
		</div>
	</div>
</div>
<content tag="script"> <script type="text/javascript">
	$('#confirmarExclusao').on(
			'show.bs.modal',
			function(event) {
				$("#urlExcluir").attr(
						"href",
						"/avaliacao/excluirCadastro.action?funcionarioExameVo.rowid="
								+ $(event.relatedTarget).data("val"));
			});
	$("#opcoesFiltro").change(function() {
		  if(this.value == "4" ){
			  $("#nomeText").prop('type','date');
			  $("#nomeText").va("");
		  }else{
			  $("#nomeText").prop('type','');
			  $("#nomeText").va("");
		  }
	});
</script></content>