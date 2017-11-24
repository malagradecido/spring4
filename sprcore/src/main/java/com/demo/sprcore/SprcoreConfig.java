package com.demo.sprcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.demo.sprcore.bean.Cotizacion;
import com.demo.sprcore.bean.JefeProyecto;
import com.demo.sprcore.bean.ListaPrecio;
import com.demo.sprcore.bean.Persona;
import com.demo.sprcore.bean.Producto;
import com.demo.sprcore.bean.Programador;
import com.demo.sprcore.component.BaseDatos;
import com.demo.sprcore.component.OracleBD;
import com.demo.sprcore.component.PostgresBD;

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
