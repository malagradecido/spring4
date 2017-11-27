package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.bean.Producto;
import com.demo.service.ComercialService;

@SpringBootApplication
public class SprcoreApplication implements CommandLineRunner {
	
	@Autowired
	ComercialService comercialService;
	
	@Autowired
	Producto producto;

	@Override
    public void run(String... args) throws Exception {
		comercialService.bonificar();
		comercialService.liquidarCaja();
		comercialService.validarStock(1);
		comercialService.validarStock(producto);
    }

	public static void main(String[] args) {
		SpringApplication.run(SprcoreApplication.class, args);
	}
}
