package br.login.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.login.app.request.ServicoRequest;
import br.login.app.response.BaseResponse;
import br.login.app.response.ListServicoResponse;
import br.login.app.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController extends BaseController {

	@Autowired
	ServicoService _service;

	// POST - CRIAR SERVICO
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody ServicoRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - LISTAR SERVICO
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			ListServicoResponse response = _service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// DELETE - DELETAR SERVICO
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
