package br.login.app.controller;

import br.login.app.response.BaseResponse;

public class BaseController  {
	
	public BaseResponse errorBase = new BaseResponse();
	
	public BaseController() {
		errorBase.message = "Erro inesperado";
		errorBase.statusCode = 500;
	}

}
