package br.login.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.login.app.model.Servico;
import br.login.app.repository.ServicoRepository;
import br.login.app.request.ServicoRequest;
import br.login.app.response.BaseResponse;
import br.login.app.response.ListServicoResponse;

@Service
public class ServicoService {

	@Autowired
	ServicoRepository _repository;

	// CRIAR UM SERVICO
	public BaseResponse criar(ServicoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome().isEmpty()) {
			response.message = "O campo de nome não pode ser vazio";
			return response;
		} else if (request.getValor() <= 0) {
			response.message = "O campo valor não pode ser zero ou menor que zero";
		}

		Servico servico = new Servico();
		servico.setNome(request.getNome());
		servico.setValor(request.getValor());

		_repository.save(servico);

		response.message = "Servico criado com sucesso!";
		response.statusCode = 200;

		return response;
	}

	// LISTAR TODOS OS SERVICOS
	public ListServicoResponse listar() {
		List<Servico> servicos = _repository.findAll();

		ListServicoResponse response = new ListServicoResponse();
		response.setServicos(servicos);

		response.message = "Lista encontrada";
		response.statusCode = 200;

		return response;
	}

	// DELETAR UM SERVICO POR ID
	public BaseResponse deletar(Long id) {
		BaseResponse response = new BaseResponse();

		if (id == null) {
			response.statusCode = 400;
			response.message = "Id de servico não existe";
		}

		_repository.deleteById(id);

		response.statusCode = 200;
		response.message = "Servico excluido com sucesso";
		return response;
	}

}