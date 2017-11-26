package com.demo.component;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("solicitud")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Pedido {

	private String articulo;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Mi Pedido es: " + articulo;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

}
