package com.demo.service;

import com.demo.bean.Producto;

public interface ComercialService {
	
	void bonificar();
	
	void liquidarCaja() throws InterruptedException;
	
	void validarStock(int codigoProducto);
	
	void validarStock(Producto producto);

}
