package br.login.app.response;

import java.util.List;

import br.login.app.model.Servico;

public class ListServicoResponse extends BaseResponse {

	private List<Servico> servicos;

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}
