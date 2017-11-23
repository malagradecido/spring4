package com.demo.sprcore.component;

import org.springframework.stereotype.Component;

@Component
public class Credito implements Tarjeta {

	@Override
	public String disponer() {
		// TODO Auto-generated method stub
		return "Prestadito nomas..";
	}

}
