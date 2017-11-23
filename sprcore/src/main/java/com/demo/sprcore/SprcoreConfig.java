package com.demo.sprcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.sprcore.bean.Cotizacion;
import com.demo.sprcore.bean.ListaPrecio;
import com.demo.sprcore.bean.Producto;

@Configuration
public class SprcoreConfig {
	
	@Bean
	public Cotizacion cotizacion(ListaPrecio listaPrecio) {
		return new Cotizacion(producto(listaPrecio));
	}
	
	@Bean
	public Producto producto(ListaPrecio listaPrecio) {
		return new Producto(listaPrecio);
	}
	
	@Bean
	public ListaPrecio listaPrecio() {
		return new ListaPrecio();
	}

}
