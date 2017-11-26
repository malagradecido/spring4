package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.bean.Cotizacion;
import com.demo.bean.Persona;
import com.demo.component.BaseDatos;
import com.demo.component.ModalidadPago;
import com.demo.component.OrdenCompra;
import com.demo.component.Pedido;
import com.demo.component.Tarjeta;
import com.demo.properties.ServerProperties;

@SpringBootApplication
public class SprcoreApplication implements CommandLineRunner {
	
	@Autowired
    private ServerProperties serverProperties;
	
	@Autowired
	private OrdenCompra ordenCompra;
	
	@Autowired
	private Cotizacion cotizacion;
	
	@Autowired
	private Pedido pedidoPorInternet;
	
	@Autowired
	private Pedido pedidoEnTienda;
	
	@Autowired
	private Persona persona;
	
	private ModalidadPago modalidadPago;

	@Autowired
	@Qualifier("pagoInformal")
	public void setModalidadPago(ModalidadPago modalidadPago) {
		this.modalidadPago = modalidadPago;
	}
	
	@Autowired
	private Tarjeta tarjeta;
	
	@Autowired
	private BaseDatos baseDatos;

	@Override
    public void run(String... args) throws Exception {
        System.out.println(serverProperties);
        System.out.println(ordenCompra);
        System.out.println(cotizacion);
        System.out.println(cotizacion.getProducto());
        System.out.println(cotizacion.getProducto().getListaPrecio());
        
        pedidoPorInternet.setArticulo("Audifonos..");
        pedidoEnTienda.setArticulo("Par de zapatos..");
        
        System.out.println(pedidoPorInternet);
        System.out.println(pedidoEnTienda);
        
        System.out.println(persona.trabajar());
        System.out.println(modalidadPago.cobrar());
        System.out.println(tarjeta.disponer());
        System.out.println(baseDatos.leerDatos());
    }

	public static void main(String[] args) {
		SpringApplication.run(SprcoreApplication.class, args);
	}
}
