package com.demo.service;

import org.springframework.stereotype.Component;

import com.demo.annotation.LogExecutionTime;
import com.demo.bean.Producto;

@Component
public class ComercialServiceImpl implements ComercialService {

	@Override
	@LogExecutionTime
	public void bonificar() {
		// TODO Auto-generated method stub
		System.out.println("Bonificado satisfactoriamente");
	}

	@Override
	@LogExecutionTime
	public void liquidarCaja() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Cuadrando caja..");
	}

	@Override
	@LogExecutionTime
	public void validarStock(int codigoProducto) {
		// TODO Auto-generated method stub
		System.out.println(
		String.format("se valido producto con codigo: %d", codigoProducto));
	}

	@Override
	@LogExecutionTime
	public void validarStock(Producto producto) {
		// TODO Auto-generated method stub
		System.out.println("validar stock de... " + producto);
	}

}
