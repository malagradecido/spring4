package com.demo.sprcore.bean;

public class Cotizacion {

	private Producto producto;

	public Cotizacion() {
		// TODO Auto-generated constructor stub
	}

	public Cotizacion(Producto producto) {
		super();
		this.producto = producto;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Mi Cotizacion!!";
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
