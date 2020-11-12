package br.login.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.login.app.request.ClienteRequest;
import br.login.app.response.BaseResponse;
import br.login.app.response.ListClienteResponse;
import br.login.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {

	@Autowired
	ClienteService _service;

	// POST - CRIAR CLIENTE
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody ClienteRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - LISTAR CLIENTES
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			ListClienteResponse response = _service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// DELETE - DELETAR CLIENTES
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> deletar(@PathVariable Long id) {
		try {
			BaseResponse response = _service.deletar(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}
