package com.demo.bean;

public class Producto {

	private ListaPrecio listaPrecio;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(ListaPrecio listaPrecio) {
		super();
		this.listaPrecio = listaPrecio;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Mi Producto";
	}

	public ListaPrecio getListaPrecio() {
		return listaPrecio;
	}

	public void setListaPrecio(ListaPrecio listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

}
