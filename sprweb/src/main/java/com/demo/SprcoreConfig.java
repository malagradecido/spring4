package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.demo.bean.Cotizacion;
import com.demo.bean.JefeProyecto;
import com.demo.bean.ListaPrecio;
import com.demo.bean.Persona;
import com.demo.bean.Producto;
import com.demo.bean.Programador;
import com.demo.component.BaseDatos;
import com.demo.component.OracleBD;
import com.demo.component.PostgresBD;

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
	
	@Bean
	public Persona programador() {
		return new Programador();
	}
	
	@Bean
	@Primary
	public Persona jefeProyecto() {
		return new JefeProyecto();
	}
	
	@Bean
	@Profile(value="dev")
	public BaseDatos oracleBD() {
		return new OracleBD();
	}
	
	@Bean
	@Profile(value="prod")
	public BaseDatos postgresBD() {
		return new PostgresBD();
	}

}
