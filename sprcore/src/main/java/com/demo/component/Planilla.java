package com.demo.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pagoFormal")
public class Planilla implements ModalidadPago {

	@Override
	public String cobrar() {
		// TODO Auto-generated method stub
		return "Hola, recibire mi gratificacion!!";
	}

}
