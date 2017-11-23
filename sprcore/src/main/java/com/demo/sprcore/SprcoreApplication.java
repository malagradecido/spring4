package com.demo.sprcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.sprcore.bean.Cotizacion;
import com.demo.sprcore.component.OrdenCompra;
import com.demo.sprcore.component.Pedido;
import com.demo.sprcore.properties.ServerProperties;

@SpringBootApplication
public class SprcoreApplication implements CommandLineRunner {
	
	@Autowired
    private ServerProperties serverProperties;
	
	@Autowired
	private OrdenCompra ordenCompra;
	
	@Autowired
	private Cotizacion cotizacion;
	
	@Autowired
	private Pedido pedido;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(serverProperties);
        System.out.println(ordenCompra);
        System.out.println(cotizacion);
        System.out.println(cotizacion.getProducto());
        System.out.println(cotizacion.getProducto().getListaPrecio());
        System.out.println(pedido);
    }

	public static void main(String[] args) {
		SpringApplication.run(SprcoreApplication.class, args);
	}
}
