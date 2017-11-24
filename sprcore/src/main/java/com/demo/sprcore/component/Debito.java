package com.demo.sprcore.component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value="dev")
public class Debito implements Tarjeta {

	@Override
	public String disponer() {
		// TODO Auto-generated method stub
		return "Es tu propio dinero!!";
	}

}
