package br.login.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.login.app.model.Cliente;
import br.login.app.repository.ClienteRepository;
import br.login.app.request.ClienteRequest;
import br.login.app.response.BaseResponse;
import br.login.app.response.ListClienteResponse;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository _repository;

	// CRIAR UM CLIENTE
	public BaseResponse criar(ClienteRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome().isEmpty()) {
			response.message = "O campo de nome não pode ser vazio";
			return response;
		} else if (request.getIdade() <= 0) {
			response.message = "O campo de idade não pode ser vazio";
		}

		Cliente cliente = new Cliente();
		cliente.setNome(request.getNome());
		cliente.setIdade(request.getIdade());

		_repository.save(cliente);

		response.message = "Cliente criado com sucesso!";
		response.statusCode = 200;

		return response;
	}

	// LISTAR TODOS OS CLIENTES
	public ListClienteResponse listar() {
		List<Cliente> clientes = _repository.findAll();

		ListClienteResponse response = new ListClienteResponse();
		response.setClientes(clientes);

		response.message = "Lista encontrada";
		response.statusCode = 200;

		return response;
	}

	// DELETAR UM CLIENTE POR ID
	public BaseResponse deletar(Long id) {
		BaseResponse response = new BaseResponse();

		if (id == null) {
			response.statusCode = 400;
			response.message = "Id de conta não existe";
		}

		_repository.deleteById(id);

		response.statusCode = 200;
		response.message = "Conta excluida com sucesso";
		return response;
	}

}
